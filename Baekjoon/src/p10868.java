import java.util.*;
import java.io.*;

public class p10868 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        for(int i=1;i<=N;i++) arr[i] = Integer.parseInt(br.readLine());

        int[] tree = new int[4*N];
        init(arr, tree, 1, 1, N);
        StringBuilder sb = new StringBuilder();
        while(M-->0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(find(tree, 1, 1, N, a, b)).append('\n');
        }

        System.out.println(sb);
    }

    public static int init(int[] arr, int[] tree, int node, int start, int end){
        if(start==end) return tree[node] = arr[end];
        else{
            int mid = (start+end)/2;
            return tree[node] = Math.min(init(arr, tree, node*2, start, mid), init(arr, tree, node*2+1, mid+1, end));
        }
    }

    public static int find(int[] tree, int node, int start, int end, int left, int right){
        if(right<start || end < left) return Integer.MAX_VALUE;
        if(left<=start && end <= right) return tree[node];
        else{
            int mid = (start+end)/2;
            return Math.min(find(tree, node*2, start, mid, left, right), find(tree, node*2+1, mid+1, end, left, right));
        }
    }
}

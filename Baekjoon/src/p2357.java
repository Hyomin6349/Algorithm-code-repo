import java.util.*;
import java.io.*;

public class p2357 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        for(int i=1;i<=N;i++) arr[i] = Integer.parseInt(br.readLine());

        int[] maxTree = new int[4*N];
        int[] minTree = new int[4*N];
        init(arr, maxTree, 1, 1, N, 1);
        init(arr, minTree, 1, 1, N, 0);

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int min = find(minTree, 1, 1, N, a, b, 0);
            int max = find(maxTree, 1, 1, N, a, b, 1);
            sb.append(min+" "+max).append('\n');
        }

        System.out.println(sb);
    }

    public static int init(int[] arr, int[] tree, int node, int start, int end, int mode){
        if(start==end) return tree[node] = arr[start];

        int mid = (start+end)/2;
        int left = init(arr, tree, node*2, start, mid, mode);
        int right = init(arr, tree, node*2+1, mid+1, end, mode);

        if(mode==1) return tree[node] = Math.max(left, right);
        else return tree[node] = Math.min(left, right);
    }

    public static int find(int[] tree, int node, int start, int end, int left, int right, int mode){
        if(end < left || start > right){
            if(mode==0) return Integer.MAX_VALUE;
            else return 0;
        }
        if(left<=start && end<=right) return tree[node];

        int mid = (start+end)/2;
        int lc = find(tree, node*2, start, mid, left, right, mode);
        int rc = find(tree, node*2+1, mid+1, end, left, right, mode);

        if(mode==0) return Math.min(lc, rc);
        else return Math.max(lc, rc);
    }
}

import java.util.*;
import java.io.*;

//100프로에서 넘버포맷 에러
public class p2042 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] arr = new long[N+1];
        long[] tree = new long[N*4];
        for(int i=1;i<=N;i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        init(arr, tree, 1, 1, N);
        for(int i=0;i<M+K;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Integer.parseInt(st.nextToken());
            if(a==1){
                long diff = c - arr[b];
                arr[b] = c;
                update(tree, 1, 1, N, b,diff);
            }
            else{
                long val = sum(tree, 1, 1, N, b, (int)c);
                sb.append(val).append('\n');
            }
        }

        System.out.println(sb);
    }

    public static long init(long[] arr, long[] tree, int node, int start, int end){
        if(start==end){
            return tree[node] = arr[start];
        }
        else{
            int mid = (start+end)/2;
            return tree[node] = init(arr, tree, 2*node, start, mid) + init(arr, tree, 2*node+1, mid+1, end);
        }
    }

    public static void update(long[] tree, int node, int start, int end, int index, long diff){
        if(index<start || index>end) return;
        tree[node] += diff;
        if(start!=end){
            int mid = (start+end)/2;
            update(tree, 2*node, start, mid, index, diff);
            update(tree, 2*node+1, mid+1, end, index, diff);
        }
    }

    public static long sum(long[] tree, int node, int start, int end, int left, int right){
        if(left>end || right<start) return 0;
        if(left<=start && end<= right) return tree[node];
        int mid = (start+end)/2;
        return sum(tree, 2*node, start, mid, left, right) + sum(tree, 2*node+1, mid+1, end, left, right);
    }
}

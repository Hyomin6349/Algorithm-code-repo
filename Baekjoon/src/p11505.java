import java.util.*;
import java.io.*;

public class p11505 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        for(int i=1;i<=N;i++) arr[i] = Integer.parseInt(br.readLine());

        long[] tree = new long[4*N];
        init(arr, tree, 1, 1, N);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M+K; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a==1){
                update(tree , 1, 1, N, b, c);
                arr[b] = c;
            }
            else {
                long val = find(tree, 1, 1, N, b, c);
                sb.append(val).append('\n');
            }
        }

        System.out.println(sb);
    }

    static int INF = 1000000007;

    public static long init(int[] arr, long[] tree, int node, int start, int end){
        if(start==end) return tree[node] = arr[end];
        else{
            int mid = (start+end)/2;
            return tree[node] = (init(arr, tree, node*2, start, mid) * init(arr, tree, node*2+1, mid+1, end))%INF;
        }
    }

    public static long find(long[] tree, int node, int start, int end, int left, int right){
        if(right<start || end < left) return 1;
        if(left<=start && end <= right) return tree[node];
        else{
            int mid = (start+end)/2;
            long lc = find(tree, node*2, start, mid, left, right);
            long rc = find(tree, node*2+1, mid+1, end, left, right);
            return (lc*rc)%INF;
        }
    }

    //리프에서 탑으로 이동
    public static long update(long[] tree, int node, int start, int end, int index, int value){
        if(index<start || end<index) return tree[node];
        if(start==end) return tree[node] = value;
        int mid = (start+end)/2;

        long lc = update(tree, node*2, start, mid, index, value);
        long rc = update(tree, node*2+1, mid+1, end, index, value);

        return tree[node] = (lc*rc)%INF;
    }
}

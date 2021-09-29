import java.util.*;
import java.io.*;

public class p7578 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] A = new String[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) A[i] = st.nextToken();

        HashMap<String, Integer> map = new HashMap<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) map.put(st.nextToken(), i);

        //세그먼트 트리 생성
        long[] tree = new long[N*4];

        long answer = 0;

        //앞에서 부터 연결하기
        for(int i=0;i<N;i++){
            int idx = map.get(A[i]);
            answer += sum(tree, 1, 0, N, idx+1, N);

            update(tree, 1, 0, N, idx, 1);
        }

        System.out.println(answer);
    }

    public static long sum(long[] tree, int node, int start, int end, int left, int right){
        if(left > end || start > right) return 0;
        if(left<=start && end<=right) return tree[node];
        int mid = (start+end)/2;
        return sum(tree, node*2, start, mid, left, right) + sum(tree, node*2+1, mid+1, end, left, right);
    }

    public static void update(long[] tree, int node, int start, int end, int index, int val){
        if(index<start || index > end) return;
        tree[node] += 1;
        if(start!=end){
            int mid = (start+end)/2;
            update(tree, node*2, start, mid, index, val);
            update(tree, node*2+1, mid+1, end, index, val);
        }
    }
}

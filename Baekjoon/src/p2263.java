import java.util.*;
import java.io.*;

public class p2263 {

    static int[] in, post, in_order; // 값의 위치를 찾기 위한 배열
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        in = new int[N+1];
        post = new int[N+1];
        in_order = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int idx = 1;
        while(st.hasMoreTokens()) in[idx++] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        idx = 1;
        while(st.hasMoreTokens()) post[idx++] = Integer.parseInt(st.nextToken());
        for(int i=1;i<=N;i++) in_order[in[i]] = i; //idx에 값을, 값에 idx를

        //인오더: left => root => left
        //프리오더: root => left => right
        //포스트오더: left => right => root

        getPreOrder(1, N, 1, N);
        System.out.println(sb);

    }

    //포스트 오더의 가장 끝 값은 루트!
    //찾은 루트를 기준으로 인오더를 나누면 앞쪽은 레프트, 뒤쪽은 라이트 부분..
    public static void getPreOrder(int in_start, int in_end, int post_start, int post_end){
        if(in_start>in_end || post_start>post_end) return;

        int root = post[post_end];
        sb.append(root+" ");

        int rootIdx = in_order[root];
        int left = rootIdx - in_start;

        getPreOrder(in_start, rootIdx-1, post_start, post_start+left-1);
        getPreOrder(rootIdx+1, in_end,post_start+left, post_end-1);
    }
}

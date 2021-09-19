import java.io.*;
import java.util.*;

public class p11062 {

    static int[] arr;
    static int[][] memo;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr = new int[N];
            memo = new int[N+1][N+1];
            for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());

            sb.append(play(0, N)).append('\n');
        }

        System.out.println(sb);
    }

    public static int play(int start, int end){
        if(memo[start][end]!=0) return memo[start][end];

        if(start>end) return 0;
        if(start==end) return arr[start];
        if(end-start==1) return arr[start];
        if(end-start==2) {
            memo[start][end] = Math.max(arr[start], arr[start+1]);
            return memo[start][end];
        }


        //case 1
        int a1 = arr[start];
        if(arr[start+1]<arr[end-1]) a1 += play(start+1, end-1);
        else a1 += play(start+2, end);
        //case 2
        int a2 = arr[end-1];
        if(arr[start] < arr[end-2]) a2 += play(start, end-2);
        else a2 += play(start+1, end-1);


        memo[start][end] = Math.max(a1, a2);
        return  memo[start][end];
    }
}

import java.util.*;
import java.io.*;

public class p10942 {

    static int[][] memo = new int[2001][2001]; //1=true, 2=false
    static int[] arr;
    static int N;

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++) arr[i] = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            sb.append(isP(s,e)).append('\n');
        }

        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }

    public static int isP(int s, int e){
        if(memo[s][e]!=0) return memo[s][e]%2;
        if(s==e){
            memo[s][e] = 1;
            return 1;
        }
        if(arr[s]!=arr[e]){
            memo[s][e] = 2;
            while(1<s && e<N) memo[s--][e++] = 2;
            return 0;
        }

        if(s==e-1){
            memo[s][e] = 1;
            return 1;
        }
        memo[s][e] = isP(s+1, e-1);
        return memo[s][e]%2;
    }
}

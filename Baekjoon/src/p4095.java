import java.util.*;
import java.io.*;

public class p4095 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(true){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if(N==0 && M==0) break;

            int[][] dp = new int[N+1][M+1];

            int max = 0;

            for(int i=1;i<=N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=1;j<=M;j++){
                    dp[i][j] = Integer.parseInt(st.nextToken());
                    if(dp[i][j]==1) dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));

                    if(max < dp[i][j]) max = dp[i][j];
                }
            }
            sb.append(max).append('\n');
        }


        System.out.println(sb);

    }
}

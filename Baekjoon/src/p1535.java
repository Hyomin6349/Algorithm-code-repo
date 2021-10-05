import java.util.*;
import java.io.*;

public class p1535 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] hp = new int[N];
        int[] happy = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) hp[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) happy[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[100];

        for(int i=0;i<N;i++){
            for(int j=99;j>=1;j--){
                if(j>=hp[i]){
                    dp[j] = Math.max(dp[j-hp[i]]+happy[i], dp[j]);
                }
            }
        }
        System.out.println(dp[99]);
    }
}

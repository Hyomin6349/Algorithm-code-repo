import java.util.*;

public class p15993 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int INF = 1000000009;
        int t = sc.nextInt();

        int[][] dp = new int[100001][2];
        dp[1][1] = 1;
        dp[2][0] = 1;
        dp[2][1] = 1;
        dp[3][0] = 2;
        dp[3][1] = 2;
        for(int i=4; i<=100000;i++){
            dp[i][0] = ((dp[i-1][1]%INF + dp[i-2][1]%INF)%INF + dp[i-3][1]%INF)%INF;
            dp[i][1] = ((dp[i-1][0]%INF + dp[i-2][0]%INF)%INF + dp[i-3][0]%INF)%INF;
        }

        while(t-->0){
            int n = sc.nextInt();
            sb.append(dp[n][1]+" "+dp[n][0]).append('\n');
        }

        System.out.println(sb);
    }
}

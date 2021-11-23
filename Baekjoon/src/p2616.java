import java.util.*;

public class p2616 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());

        int[] sum = new int[N+1];
        int[][] dp = new int[N+1][4];
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        for(int i=1;i<=N;i++){
            sum[i] = sum[i-1] + Integer.parseInt(st.nextToken());

        }
        int K = Integer.parseInt(sc.nextLine());

        for(int i=K;i<=N;i++){
            int val = sum[i] - sum[i-K];
            if(i<K*2){
                dp[i][1] = Math.max(dp[i-1][1], val); //k~2k
            } else if(i<K*3){
                dp[i][2] = Math.max(dp[i-1][2], dp[i-K][1] + val); //k~2k
            } else {
                dp[i][3] = Math.max(dp[i-1][3], dp[i-K][2] + val);
            }
        }

        System.out.println(dp[N][3]);
    }
}

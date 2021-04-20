import java.util.*;

public class p10422 {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int tc = input.nextInt();

        long[] dp = new long[5001];
        dp[0] = 1;
        dp[2] = 1;
        for(int i = 2; i <= 2500; i++) {
            for(int j = 0; j <= i-1; j++) {
                dp[i*2] += dp[j*2]*dp[(i-1-j)*2];
                dp[i*2] %= 1000000007L;
            }
        }


        while(tc-->0){
            int num = input.nextInt();
            System.out.println(dp[num]);
        }
    }
}

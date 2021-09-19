import java.io.*;
import java.util.*;

public class p11062 {
    static int[][][] dp;
    static int[] arr;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());
            arr = new int[N];
            String[] input = br.readLine().split(" ");

            for(int j=0; j<N; j++)
                arr[j] = Integer.parseInt(input[j]);

            dp = new int[2][N][N];

            int max = dfs(0, N-1, 1);

            System.out.println(max);
        }
    }

    public static int dfs(int left, int right, int turn) {
        if(left>right) return 0;

        int res = dp[turn][left][right];

        if(res!=0) return res;

        if(turn==1)
            res = Math.max(dfs(left+1, right, 0)+arr[left], dfs(left, right-1, 0)+arr[right]);

        else
            res = Math.min(dfs(left+1, right, 1), dfs(left, right-1, 1));

        return dp[turn][left][right] = res;
    }
}

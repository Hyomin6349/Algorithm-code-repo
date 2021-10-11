import java.util.*;
import java.io.*;

public class p2533 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new int[N+1][2];
        tree = new ArrayList[N+1];
        for(int i=1; i<=N;i++) tree[i] = new ArrayList<>();

        while(N-->1){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        dp(1, -1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));

    }

    static ArrayList<Integer>[] tree;
    static int[][] dp;

    public static void dp(int cur, int parent){
        dp[cur][0] = 0;
        dp[cur][1] = 1;

        for(int next: tree[cur]){
            if(next!=parent){
                dp(next, cur);
                dp[cur][0] += dp[next][1]; //무조건 얼리어답터
                dp[cur][1] += Math.min(dp[next][0], dp[next][1]);
            }
        }
    }
}

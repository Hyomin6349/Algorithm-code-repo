import java.io.*;
import java.util.*;

class epper13_09 {
    public static int max(int a, int b){
        if(a>b) return a;
        else return b;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int[] m  = new int[n];
        int[] dp = new int[n]; //최대 돈의 값을 저장할 배열
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++) m[i] = Integer.parseInt(st.nextToken());

        int answer;

        dp[0] = m[0];
        if(n>1) dp[1] = m[0]+m[1];
        if(n>2) dp[2] = max(dp[1],max(m[1]+m[2],m[0]+m[2]));
        for(int i=3; i<n; i++) dp[i] = max(dp[i-3]+m[i-1]+m[i], max(dp[i-2]+m[i], dp[i-1]));

        System.out.println(dp[n-1]);
    }
}
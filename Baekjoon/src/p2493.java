import java.util.*;
import java.io.*;

public class p2493 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(int i=1;i<=N;i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            for(int j=i-1 ; j > 0;) {
                if(arr[j] > arr[i]) {
                    dp[i] = j;
                    break;
                }
                j = dp[j];
            }
            sb.append(dp[i]+" ");
        }

        System.out.println(sb);

    }

}
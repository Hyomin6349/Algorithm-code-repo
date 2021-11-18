import java.util.*;
import java.io.*;

public class p14465 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        boolean[] broken = new boolean[N+1];
        for(int i=0;i<B;i++){
            broken[Integer.parseInt(br.readLine())] = true;
        }

        int[] sum = new int[N+1];
        sum[1] = broken[1] ? 1:0;

        int min = N;
        for(int i=2;i<=N;i++){
            sum[i] = sum[i-1] + (broken[i]?1:0);
            if(i>=K && sum[i] - sum[i-K] < min) {
                min =  sum[i] - sum[i-K];
            }
        }

        System.out.println(min);
    }
}

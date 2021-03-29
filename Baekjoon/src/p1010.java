import java.util.*;
import java.io.*;

public class p1010 {
    static int[][] memo;

    public static int solution(int b, int a){
        if(memo[b][a] != -1) return memo[b][a];
        else{
            if(b==a || a==0){
                memo[b][a] = 1;
                return 1;
            }
            else{
                int res = solution(b-1, a-1) + solution( b-1, a);
                memo[b][a] = res;
                return res;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.valueOf(st.nextToken());
            int b = Integer.valueOf(st.nextToken());
            memo = new int[b+1][a+1];
            for(int i=0;i<=b;i++){
                for(int j=0;j<=a;j++) memo[i][j] = -1;
            }
            System.out.println(solution(b, a));
        }
    }
}

import java.util.*;
import java.io.*;

public class p2096 {

    static int N, max = 0, min = 900000;
    static int[][] arr;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N][3];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<3;j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }

        dfs(1, -1, 0);
        System.out.println(max+" "+min);
    }

    public static void dfs(int row, int col, int sum){
        if(col == N){
            if(max < sum) max = sum;
            if(min > sum) min = sum;
            return;
        }

        for(int i=-1; i<2;i++){
            int next = row + i;
            if(0<=next && next<3){
                if(col==-1) dfs(next, col+1, sum);
                else{
                    sum += arr[col][next];
                    dfs(next, col+1, sum);
                    sum -= arr[col][next];
                }
            }
        }
    }
}

import java.util.*;
import java.io.*;

public class p1937 {
    static int N, answer = 0;
    static int[][] map;
    static int[][] memo;
    static int[][] d = {{-1,1,0,0},{0,0,-1,1}};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        memo = new int[N][N];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int j = 0;
            while(st.hasMoreTokens()) map[i][j++] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                int n = dfs(i, j);
                if(n > answer) answer = n;
            }
        }

        System.out.println(answer);
    }

    public static int dfs(int col, int row){
        if(memo[col][row]!=0) return memo[col][row];

        int root = 1;
        for(int i=0;i<4;i++){
            int nc = col + d[0][i];
            int nr = row + d[1][i];

            if(0<=nc && nc<N && 0<=nr && nr<N){
                if(map[col][row] < map[nc][nr]){
                    int val = dfs(nc, nr) + 1;
                    if(root < val) root = val;
                }
            }
        }

        memo[col][row] = root;
        return root;
    }
}

import java.util.*;
import java.io.*;

public class p10971 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<N;i++){
            boolean[] visit = new boolean[N];
            visit[i] = true;
            dfs(i,i, 1, visit, 0);
        }

        System.out.println(answer);
    }

    static int[][] map;
    static int N, answer = Integer.MAX_VALUE;

    public static void dfs(int start, int cur, int cnt, boolean[] visit, int sum){
        if(cnt==N){
            if(map[cur][start]==0) return;
            sum += map[cur][start];
            if(sum<answer) answer = sum;
            return;
        }

        if(sum > answer) return;

        for(int i=0;i<N;i++){
            if(!visit[i] && map[cur][i]!=0){
                visit[i] = true;
                dfs(start, i, cnt+1, visit, sum+map[cur][i]);
                visit[i] = false;
            }
        }
    }
}

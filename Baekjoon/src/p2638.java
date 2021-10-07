import java.util.*;
import java.io.*;

public class p2638 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        int cnt = 0;

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                int val = Integer.parseInt(st.nextToken());
                map[i][j] = val;
                if(val==1) cnt++;
            }
        }

        if(cnt==0){
            System.out.println(0);
            System.exit(0);
        }

        int time = 0;

        while(true){
            boolean melt = false;
            visit = new boolean[N][M];
            time++;

            dfs(0, 0);

            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(map[i][j]>=3){
                        melt = true;
                        map[i][j] = 0;
                    }
                    if(map[i][j]==2) map[i][j] = 1;
                }
            }

            if(!melt) break;
        }

        System.out.println(time-1);

    }

    static int N, M;
    static int[][] map, d={{-1, 1, 0, 0}, {0, 0, -1, 1}};
    static boolean[][] visit;

    public static void dfs(int r, int c){
        visit[r][c] = true;

        for(int i=0;i<4;i++){
            int nr = r + d[0][i];
            int nc = c + d[1][i];

            if(0<=nr && nr<N && 0<=nc && nc<M){
                if(map[nr][nc]>0) map[nr][nc] ++;
                if(!visit[nr][nc] && map[nr][nc]==0) dfs(nr, nc);
            }
        }
    }
}

import java.util.*;
import java.io.*;

public class p15684 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        map = new boolean[H+1][N+1];
        while(M-->0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = true;
        }

        for(int i=0;i<=3;i++){
            comb(0, 0, i);
        }

        System.out.println(-1);
    }

    static int N,M,H;
    static boolean[][] map;

    public static void comb(int idx, int cnt, int n){
        if(cnt==n){
            if(start()){
                System.out.println(n);
                System.exit(0);
            }
            return;
        }

        for (int i = idx; i < (N - 1) * H; i++) {
            int r = i/(N-1)+1;
            int c = i%(N-1)+1;
            if(!map[r][c] && !map[r][c+1] && !map[r][c-1]){
                map[r][c] = true;
                comb(i+1, cnt+1, n);
                map[r][c] = false;
            }
        }
    }

    public static boolean start(){
        for(int i=1;i<=N;i++){
            int line = i;
            for(int j=1;j<=H;j++){
                boolean move = false;
                if(line<N && map[j][line]){
                    line++;
                    move = true;
                }
                if(!move && 0<=line-1 && map[j][line-1]) line--;
            }
            if(line!=i) return false;
        }
        return true;
    }
}

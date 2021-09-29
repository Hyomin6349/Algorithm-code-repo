import java.util.*;
import java.io.*;

public class p20056 {

    public static class Fireball {
        int row, col, mass, dir, speed;
        public Fireball(int r, int c, int m, int d, int s){
            row = r; col=c; mass = m; dir=d; speed=s;
        }
    }

    public static class Info {
        int cnt, massSum, speedSum, dir;
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Fireball> q = new LinkedList<>();

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            q.add(new Fireball(r,c,m,d,s));
        }

        int[][] d = {{-1, -1, 0, 1, 1, 1, 0, -1}, {0, 1, 1, 1, 0, -1, -1,-1}};
        int[][] nd = {{0, 2, 4, 6}, {1, 3, 5, 7}};
        Info[][] map = new Info[N][N];
        int answer = 0;

        while(K-->0){
            iniMap(map, N);
            int size = q.size();

            while(size-->0) {
                Fireball fireball = q.poll();

                int nr = (fireball.row + N + (d[0][fireball.dir] * (fireball.speed%N))) %N;
                int nc = (fireball.col + N + (d[1][fireball.dir] * (fireball.speed%N))) %N;

                Info info = map[nr][nc];
                info.cnt++;
                info.massSum += fireball.mass;
                info.speedSum += fireball.speed;
                if(info.dir<0) continue;

                if(info.cnt==1)  info.dir = fireball.dir;
                else if(info.dir%2 != fireball.dir%2) info.dir = -1;
            }

            answer = 0;

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    Info info = map[i][j];
                    if(info.cnt==0) continue;
                    if(info.cnt==1){
                        q.add(new Fireball(i, j, info.massSum, info.dir, info.speedSum));
                        answer += info.massSum;
                    }
                    else {
                        int mass = info.massSum/5;
                        if(mass==0) continue;
                        int speed = info.speedSum/info.cnt;
                        int dir = 1;
                        if(info.dir>=0) dir=0;

                        for(int k=0;k<4;k++){
                            answer += mass;
                            q.add(new Fireball(i, j, mass, nd[dir][k], speed));
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }

    public static void iniMap(Info[][] map, int n){
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                map[i][j] = new Info();
            }
        }
    }
}

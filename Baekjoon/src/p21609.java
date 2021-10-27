import java.util.*;
import java.io.*;

public class p21609 {

    public static class Pos{
        int row, col;
        public Pos(int r, int c){
            row = r; col = c;
        }
    }

    public static class Group implements Comparable<Group> {
        int cnt, rainbow;
        Pos standard;
        Pos pos;

        public Group(int c, int r, Pos standard, Pos pos){
            cnt = c;
            rainbow = r;
            this.standard = standard;
            this.pos = pos;
        }
        public int compareTo(Group o){
            if(cnt==o.cnt){
                if(rainbow == o.rainbow){
                    if(standard.row == o.standard.row) return o.standard.col - standard.col;
                    else return o.standard.row - standard.row;
                }
                else return o.rainbow - rainbow;
            }
            else return o.cnt - cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int score = 0;

        while(true) {
            pq = new PriorityQueue<>();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] > 0) {
                        find(map, new Pos(i, j), 0);
                    }
                }
            }

            if(pq.isEmpty()) break;
            Group group = pq.poll();
            find(map, group.pos, 1);
            score += group.cnt * group.cnt;

            down(map);
            map = turn(map);
            down(map);

        }

        System.out.println(score);
    }

    static int N;
    static int[][] d= {{-1, 1, 0, 0}, {0, 0, -1, 1}};
    static PriorityQueue<Group> pq;

    public static void find(int[][] map, Pos pos, int state){
        int cnt = 0;
        int rainbow = 0;
        Pos standard = pos;

        int color = map[pos.row][pos.col];
        boolean[][] visit = new boolean[N][N];

        Queue<Pos> q = new LinkedList<>();
        q.add(pos);
        visit[pos.row][pos.col] = true;
        if(state==1) map[pos.row][pos.col] = -2;

        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                Pos cur = q.poll();
                cnt++;

                for(int j=0;j<4;j++){
                    int nr = cur.row + d[0][j];
                    int nc = cur.col + d[1][j];
                    if(0<=nr && nr<N && 0<=nc && nc<N && !visit[nr][nc]){
                        if(map[nr][nc]==color || map[nr][nc]==0) {
                            visit[nr][nc] = true;
                            q.add(new Pos(nr, nc));
                            if(map[nr][nc]==0) rainbow++;
                            if(map[nr][nc]!=0 && standard.row > nr) standard = new Pos(nr, nc);
                            if(map[nr][nc]!=0 && standard.row == nr && standard.col > nc) standard = new Pos(nr, nc);
                            if(state==1)  map[nr][nc] = -2;
                        }
                    }
                }
            }
        }

        if(cnt>=2) pq.add(new Group(cnt, rainbow, standard, pos));
    }

    public static void down(int[][] map){
        for(int i=0;i<N;i++){
            int ground = N-1;
            for(int j=N-1; j>=0;j--){
                if(map[j][i]==-1) ground = j-1;
                if(map[j][i]>=0){
                    map[ground][i] = map[j][i];
                    if(j!=ground) map[j][i] = -2;
                    ground --;
                }
            }
        }
    }

    public static int[][] turn(int[][] map){
        int[][] newMap = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                newMap[N-1-j][i] = map[i][j];
            }
        }
        return newMap;
    }

}

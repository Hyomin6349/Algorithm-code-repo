import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1600 {

    public static class Pos{
        int row, col, jump, move;
        public Pos(int r, int c, int j, int m) {
            row = r; col = c; jump = j; move = m;
        }
    }

    static int height, weight;
    static int[][] map;
    static boolean[][][] visit;
    static int[][] d = {{-1, 1, 0, 0}, {0, 0, -1, 1}};
    static int[][] j = {{-1, -2, -2, -1, 1, 2, 2, 1}, {-2, -1, 1, 2, -2, -1 , 1, 2}};

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        weight = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());
        map = new int[height][weight];
        visit = new boolean[height][weight][k+1];

        for(int i=0;i<height;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<weight;j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        int answer = -1;

        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(0, 0, 0, 0));
        visit[0][0][0] = true;

        while(!q.isEmpty()) {
            Pos cur = q.poll();
            if(cur.row == height-1 && cur.col == weight-1) {
                answer = cur.move;
                break;
            }

            for(int i=0;i<4;i++) {
                int nr = cur.row + d[0][i];
                int nc = cur.col + d[1][i];
                if(canGo(nr, nc, cur.jump)) {
                    q.offer(new Pos(nr, nc, cur.jump, cur.move+1));
                    visit[nr][nc][cur.jump] = true;
                }
            }
            if(cur.jump<k) {
                for(int i=0;i<8;i++) {
                    int nr = cur.row + j[0][i];
                    int nc = cur.col + j[1][i];
                    if(canGo(nr, nc, cur.jump+1)) {
                        q.offer(new Pos(nr, nc, cur.jump+1, cur.move+1));
                        visit[nr][nc][cur.jump+1] = true;
                    }
                }
            }
        }

        System.out.println(answer);
    }

    public static boolean canGo(int row, int col, int jump) {
        if(0<=row && row<height && 0<=col && col<weight && map[row][col]==0 && !visit[row][col][jump]) return true;
        else return false;
    }

}


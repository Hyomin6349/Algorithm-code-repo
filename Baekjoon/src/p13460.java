import java.util.*;

public class p13460 {

    static int N, M;
    static char[][] map;
    static int[][] d = {{-1, 1, 0, 0}, {0, 0, -1, 1}};

    public static class State{
        int Rrow, Rcol, Brow, Bcol, move;
        public State(){
            move = 0;
        }
        public State(int rr, int rc, int br, int bc, int m){
            Rrow = rr;
            Rcol = rc;
            Brow = br;
            Bcol = bc;
            move = m;
        }
    }

    public static void main(String[] args) {
        //입력
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new char[N][M];

        State ini = new State();
        int[] hole = new int[2];

        for(int i=0;i<N;i++){
            String str = sc.next();
            for(int j=0;j<M;j++){
                char c = str.charAt(j);
                map[i][j] = c;
                if(c=='O'){
                    hole[0] = i;
                    hole[1] = j;
                }
                if(c=='R'){
                    ini.Rrow = i;
                    ini.Rcol = j;
                    map[i][j] = '.';
                }
                if(c=='B'){
                    ini.Brow = i;
                    ini.Bcol = j;
                    map[i][j] = '.';
                }
            }
        }


        Queue<State> q = new LinkedList<>();
        boolean[][][][] visit = new boolean[N][M][N][M];
        q.add(ini);
        visit[ini.Rrow][ini.Rcol][ini.Brow][ini.Bcol] = true;
        int answer = -1;

        while(!q.isEmpty()){
            State cur = q.poll();
            if(cur.Brow==hole[0] && cur.Bcol==hole[1]) continue;
            if(cur.Rrow==hole[0] && cur.Rcol==hole[1]){
                answer = cur.move;
                break;
            }

            for(int i=0;i<4;i++){
                if(getFirst(cur, i) <= 0) { //R우선 굴리기
                    int[] next = moveBall(cur.Rrow, cur.Rcol, cur.Brow, cur.Bcol, i);
                    int[] red = {next[0], next[1]};
                    int[] blue = {next[2], next[3]};
                    if(!visit[red[0]][red[1]][blue[0]][blue[1]] && cur.move<10){
                        visit[red[0]][red[1]][blue[0]][blue[1]] = true;
                        q.add(new State(red[0], red[1], blue[0], blue[1], cur.move+1));
                    }
                }
                else {
                    int[] next = moveBall(cur.Brow, cur.Bcol, cur.Rrow, cur.Rcol, i);
                    int[] red = {next[2], next[3]};
                    int[] blue = {next[0], next[1]};
                    if(!visit[red[0]][red[1]][blue[0]][blue[1]] && cur.move<10){
                        visit[red[0]][red[1]][blue[0]][blue[1]] = true;
                        q.add(new State(red[0], red[1], blue[0], blue[1], cur.move+1));
                    }
                }
            }
        }

        System.out.println(answer);
    }

    //음수면 R우선
    public static int getFirst(State state, int dir){
        switch(dir){
            case 0: //상
                return state.Rrow - state.Brow;
            case 1: //하
                return (state.Rrow - state.Brow)*-1;
            case 2: //좌
                return state.Rcol - state.Bcol;
            case 3: //우
                return (state.Rcol - state.Bcol)*-1;
            default: return 0;
        }
    }

    public static int[] moveBall(int r1, int c1, int r2, int c2, int dir){
        int[] next = new int[4];

        //ball1 먼저 굴리기
        int nr1 = r1 + d[0][dir];
        int nc1 = c1 + d[1][dir];

        while(0<=nr1 && nr1<N && 0<=nc1 && nc1<M){
            if(map[nr1][nc1]=='#'){
                nr1 -= d[0][dir];
                nc1 -= d[1][dir];
                break;
            }
            if(map[nr1][nc1]=='O') break;
            nr1 += d[0][dir];
            nc1 += d[1][dir];
        }

        next[0] = nr1;
        next[1] = nc1;

        //ball2 굴리기
        int nr2 = r2 + d[0][dir];
        int nc2 = c2 + d[1][dir];

        while(0<=nr2 && nr2<N && 0<=nc2 && nc2<M){
            if(map[nr2][nc2]=='O') break;
            if(map[nr2][nc2]=='#' || (nr1==nr2 && nc1==nc2)){
                nr2 -= d[0][dir];
                nc2 -= d[1][dir];
                break;
            }
            nr2 += d[0][dir];
            nc2 += d[1][dir];
        }

        next[2] = nr2;
        next[3] = nc2;

        return next;
    }
}

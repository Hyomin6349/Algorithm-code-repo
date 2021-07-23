import java.util.*;

public class p2573 {

    static int[][] map;
    static boolean[][] visit;
    static int[][] d = {{-1, 1, 0, 0}, {0, 0, -1, 1}};
    static int N, M, count = 0;

    public static class Pos{
        int col;
        int row;
        int val;

        public Pos(int c, int r, int v){
            col = c;
            row = r;
            val = v;
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        M = input.nextInt();
        input.nextLine();
        map = new int[N][M];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(input.nextLine());
            for(int j=0;j<M;j++){
                int val = Integer.parseInt(st.nextToken());
                map[i][j] = val;
                if(val>0) count++;
            }
        }

        int year = 0;

        while_loop: while(true){
            year++;
            melting();

            if(count==0){ //다 녹았으면
                System.out.println(0);
                System.exit(0);
            }

            visit = new boolean[N][M];
            for_loop: for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(map[i][j] != 0){
                        if(keep(i,j)) break for_loop;
                        else break while_loop;
                    }
                }
            }
        }

        System.out.println(year);
    }

    public static void melting(){
        ArrayList<Pos> list = new ArrayList<>();

        for(int i=0; i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]!=0){
                    int c = 0;
                    for(int k=0;k<4;k++){
                        int dc = i + d[0][k];
                        int dr = j + d[1][k];

                        if(0<=dc && dc<N && 0<=dr && dr<M){
                            if(map[dc][dr]==0) c++;
                        }
                    }
                    list.add(new Pos(i,j,map[i][j]-c));
                }
            }
        }

        count = 0;
        for(Pos p : list){
            if(p.val > 0){
                map[p.col][p.row] = p.val;
                count++;
            }
            else map[p.col][p.row] = 0;
        }
    }

    public static boolean keep(int col, int row){
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(col,row,0));
        int size = 1;
        visit[col][row] = true;

        while(!q.isEmpty()){
            Pos p = q.poll();

            for(int i=0;i<4;i++){
                int dc = p.col + d[0][i];
                int dr = p.row + d[1][i];

                if(0<=dc && dc<N && 0<=dr && dr<M){
                    if(map[dc][dr]!=0 && !visit[dc][dr]){
                        q.add(new Pos(dc, dr, 0));
                        visit[dc][dr] = true;
                        size++;
                    }
                }
            }
        }

        if(size==count) return true;
        else return false;
    }
}

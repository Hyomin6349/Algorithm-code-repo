import java.util.*;

public class p7569 {

    public static class Pos{
        int col;
        int row;
        int floor;

        public Pos(int f, int c, int r){
            col = c;
            row = r;
            floor = f;
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int M = input.nextInt();
        int N = input.nextInt();
        int H = input.nextInt();

        int[][][] map = new int[H][N][M];
        boolean[][][] visit = new boolean[H][N][M];
        Queue<Pos> q = new LinkedList<>();

        for(int k=0;k<H;k++){
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    int val = input.nextInt();
                    map[k][i][j] = val;
                    if(val == 1){
                        q.add(new Pos(k, i, j));
                        visit[k][i][j] = true;
                    }
                }
            }
        }

        int[][] d = {{1,-1,0,0,0,0},{0,0,-1,1,0,0},{0,0,0,0,-1,1}};
        int day = -1;
        int size = q.size();

        while(size != 0){
            day++;
            for(int j=0;j<size;j++){
                Pos p = q.poll();

                for(int i=0;i<6;i++){
                    int df = p.floor + d[0][i];
                    int dc = p.col + d[1][i];
                    int dr = p.row + d[2][i];

                    if(0<=df && df<H && 0<=dc && dc<N && 0<=dr && dr<M){
                        if(map[df][dc][dr] == 0 && !visit[df][dc][dr]){
                            map[df][dc][dr] = 1;
                            visit[df][dc][dr] = true;
                            q.add(new Pos(df, dc, dr));
                        }
                    }
                }
            }
            size = q.size();
        }


        for(int k=0;k<H;k++){
            for(int i=0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(map[k][i][j] == 0){
                        System.out.println(-1);
                        System.exit(0);
                    }
                }
            }
        }

        System.out.println(day);
    }
}

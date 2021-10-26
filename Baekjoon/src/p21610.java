import java.util.*;
import java.io.*;

public class p21610 {

    public static class Pos{
        int row, col;
        public Pos(int r, int c){
            row = r; col = c;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        q.add(new Pos(N-1,0));
        q.add(new Pos(N-1,1));
        q.add(new Pos(N-2,0));
        q.add(new Pos(N-2,1));


        while(M-->0){
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken())-1;
            int s = Integer.parseInt(st.nextToken())%N;
            int size = q.size();

            for(int i=0;i<size;i++){
                Pos pos = q.poll();
                move(pos, d, s);
            }

            boolean[][] check = new boolean[N][N];
            while(!q.isEmpty()){
                Pos pos = q.poll();
                check[pos.row][pos.col] = true;
                copy(pos);
            }

            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(map[i][j] >=2 && !check[i][j]){
                        map[i][j] -= 2;
                        q.add(new Pos(i, j));
                    }
                }
            }
        }

        int sum = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j <N;j++){
                sum += map[i][j];
            }
        }

        System.out.println(sum);
    }

    static int N;
    static int[][] map;
    static Queue<Pos> q = new LinkedList<>();
    static int[][] dir = {{0, -1, -1, -1, 0, 1, 1, 1}, {-1, -1, 0, 1, 1, 1, 0 ,-1}};

    public static void move(Pos pos, int d, int s){
        int row = ((pos.row + N) + dir[0][d]*s)%N;
        int col = ((pos.col + N) + dir[1][d]*s)%N;
        map[row][col]++;
        q.add(new Pos(row,col));
    }

    public static void copy(Pos pos){
        int cnt = 0;

        for(int i=1; i<8; i+=2){
            int r = pos.row + dir[0][i];
            int c = pos.col + dir[1][i];

            if(0<=r && r<N && 0<=c && c<N && map[r][c]>0) cnt++;
        }

        map[pos.row][pos.col] += cnt;
    }
}

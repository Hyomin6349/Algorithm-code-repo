import java.util.*;
import java.io.*;

public class p18290 {

    static int N,M,K, answer = Integer.MIN_VALUE;
    static Point[] selected;
    static int[][] map;
    static boolean[][] visited;

    public static class Point{
        int row;
        int col;
        public Point(int r, int c){
            row = r;
            col = c;
        }
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        selected = new Point[K];
        visited = new boolean[N][M];

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0,0);
        System.out.println(answer);
    }

    public static void dfs(int select, int row, int col){
        if(select == K){
            int sum = cal();
            if(sum > answer) answer = sum;
            return;
        }
        for(int i = row; i<N; i++){
            for(int j=col; j<M; j++){
                Point p = new Point(i,j);
                if(!visited[i][j] && isPossible(select,p)){
                    selected[select] = p;
                    visited[i][j] = true;
                    dfs(select+1, i, j);
                    visited[i][j] = false;
                }
            }
            col = 0;
        }
    }

    public static int cal(){
        int res = 0;
        for(Point p: selected){
            res += map[p.row][p.col];
        }
        return res;
    }

    public static boolean isPossible(int k, Point p){
        for(int i=0;i<k;i++){
            Point point = selected[i];
            if(Math.abs(point.row - p.row)==1 && (point.col-p.col)==0) return false;
            if(Math.abs(point.col - p.col)==1 && (point.row-p.row)==0) return false;
        }
        return true;
    }
}
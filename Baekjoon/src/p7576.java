import java.util.*;
import java.io.*;

public class p7576 {

    static Queue<Point> q = new LinkedList<>();

    public static class Point{
        int row;
        int col;
        public Point(int r, int c){
            row = r;
            col = c;
        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int box[][] = new int[n][m];
        int not = 0;
        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m;j++){
                box[i][j] = Integer.parseInt(st.nextToken());
                if(box[i][j]==1) q.add(new Point(i,j));
                if(box[i][j]==-1) not++;
            }
        }

        if(q.size() == m*n-not){
            System.out.println(0);
            return;
        }

        int day = -1;
        int[] dx = {-1, 0, 1 ,0};
        int[] dy = {0, -1, 0 ,1};
        while(!q.isEmpty()){
            day++;
            int size = q.size();

            for(int i=0;i<size;i++){
                Point cur = q.poll();
                for(int j=0;j<4;j++){
                    int col = cur.col + dx[j];
                    int row = cur.row + dy[j];
                    if(0<=col && col<m && 0<=row && row<n){
                        if(box[row][col]==0){
                            box[row][col] = 1;
                            q.add(new Point(row,col));
                        }
                    }
                }
            }
        }

        boolean check = true;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(box[i][j]==0) check = false;
            }
        }

        if(check) System.out.println(day);
        else System.out.println(-1);
    }
}

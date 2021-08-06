import java.util.*;

public class p1405 {

    static int N;
    static int[][] d = {{0, 0, 1, -1}, {1, -1, 0, 0}};
    static double[] moveP = new double[5];
    static boolean[][] visit = new boolean[100][100];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for(int i=0;i<4;i++) moveP[i] = sc.nextInt()/100.0;
        visit[50][50] = true;
        moveP[4] = 1.0;
        System.out.println(dfs(50,50,0,4,1.0));
    }

    public static double dfs(int col, int row, int cnt, int dir, double p){
        p *= moveP[dir];    // p: 단순할 확률
        if(cnt == N) return p;

        double percent = 0;
        for(int i=0;i<4;i++){
            int nc = col + d[0][i];
            int nr = row + d[1][i];

            if(!visit[nc][nr]){
                visit[nc][nr] = true;
                percent += dfs(nc, nr, cnt+1, i, p);
                visit[nc][nr] = false;
            }
        }
        return percent;
    }
}

import java.util.*;
import java.io.*;

public class p1012 {
    static int answer;
    static int m, n, visit[][], field[][];

    public static void dfs(int root, int x, int y){
        visit[x][y] = 1;

        if(field[x][y] == 1){
            if(x>0 && visit[x-1][y]==0 && field[x-1][y]==1) dfs(0,x-1,y);
            if(x<m-1 && visit[x+1][y]==0 && field[x+1][y]==1) dfs(0,x+1,y);
            if(y<n-1 && visit[x][y+1]==0 && field[x][y+1]==1) dfs(0,x,y+1);
            if(y>0 && visit[x][y-1]==0 && field[x][y-1]==1) dfs(0,x,y-1);
        }

        if(root==1){
           for(int i=0;i<m;i++){
               for(int j=0;j<n;j++){
                   if(visit[i][j]==0 && field[i][j]==1){
                       answer++;
                       dfs(1,i,j);
                       return;
                   }
               }
           }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.valueOf(br.readLine());
        while(t-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.valueOf(st.nextToken());
            n = Integer.valueOf(st.nextToken());
            int k = Integer.valueOf(st.nextToken());
            visit = new int[m][n];
            field = new int[m][n];
            answer=0;

            while(k-->0){
                st = new StringTokenizer(br.readLine());
                int x = Integer.valueOf(st.nextToken());
                int y = Integer.valueOf(st.nextToken());
                field[x][y] = 1;
            }
            if(field[0][0]==1) answer++;
            dfs(1, 0,0);
            System.out.println(answer);
        }
    }
}

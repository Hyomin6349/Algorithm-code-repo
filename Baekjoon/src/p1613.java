import java.util.*;
import java.io.*;

public class p1613 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] graph = new int[n+1][n+1];

        for(int i=0;i<k;i++){
           st = new StringTokenizer(br.readLine());
           int a = Integer.parseInt(st.nextToken());
           int b = Integer.parseInt(st.nextToken());
           graph[a][b] = -1;
           graph[b][a] = 1;
        }

        for(int a=1;a<=n;a++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    if(i==j || graph[i][j]!=0) continue;
                    if(graph[i][a]==-1 && graph[a][j]==-1){
                        graph[i][j]=-1;
                    }
                    if(graph[i][a]==1 && graph[a][j]==1){
                        graph[i][j]=1;
                    }
                }
            }
        }

        int s = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(graph[a][b]).append('\n');
        }

        System.out.println(sb);
    }

}

import java.io.*;
import java.util.*;

public class p9466_2 {
    static boolean[] visit, done;
    static int[] s;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            s = new int[n+1];
            visit = new boolean[n+1];
            done = new boolean[n+1];
            count = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            int i=1;
            while(st.hasMoreTokens()){
                s[i]= Integer.parseInt(st.nextToken());
                i++;
            }
            for(i=1; i<=n; i++){
                if(!done[i]) dfs(i);
            }
            sb.append(n - count).append('\n');

        }
        System.out.println(sb);
    }

    public static void dfs(int now){
        if(visit[now]){
            done[now] = true;
            count++;
        }else{
            visit[now] = true;
        }

        int next = s[now];

        if(!done[next]) dfs(next);

        visit[now] = false;
        done[now] = true;
    }
}

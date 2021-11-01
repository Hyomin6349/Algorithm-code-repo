import java.util.*;
import java.io.*;

public class p16168 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        graph = new ArrayList[V+1];
        visit = new boolean[V+1];

        for(int i=1;i<=V;i++){
            graph[i] = new ArrayList<>();
        }

        int[] degrees = new int[V+1];
        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
            degrees[a]++;
            degrees[b]++;
        }

        int cnt = 0;
        for(int i=1;i<=V;i++){
            if(!visit[i]){
                dfs(i);
                cnt ++;
            }
        }

        if(cnt!=1) System.out.println("NO");
        else {
            int odd = 0;
            for(int i=1;i<=V;i++){
                if(degrees[i]%2==1) odd++;
            }

            if(odd==0 || odd==2) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    static ArrayList<Integer>[] graph;
    static boolean[] visit;
    static int V, E;

    public static void dfs(int i){
        if(visit[i]) return;
        visit[i] = true;

        for(int j: graph[i]){
            dfs(j);
        }
    }
}

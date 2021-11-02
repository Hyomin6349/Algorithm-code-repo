import java.util.*;
import java.io.*;

public class p2099 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        ans = new HashSet[N+1];

        for(int i=1;i<=N;i++){
            graph[i] = new ArrayList<>();
            ans[i] = new HashSet<>();

            st = new StringTokenizer(br.readLine());
            int p1 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            graph[i].add(p1);
            if(p1!=p2) graph[i].add(p2);
        }

        for(int i=1;i<=N;i++){
            go(i, i, 0);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(ans[a].contains(b)) sb.append("death").append('\n');
            else sb.append("life").append('\n');
        }

        System.out.println(sb);
    }

    static int N, K, M;
    static ArrayList<Integer>[] graph;
    static HashSet<Integer>[] ans;

    public static void go(int start, int cur, int cnt){
        if(cnt==K){
            ans[start].add(cur);
            return;
        }

        for(int j=0;j<graph[cur].size();j++){
            go(start, graph[cur].get(j), cnt+1);
        }
    }
}

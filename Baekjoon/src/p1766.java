import java.util.*;
import java.io.*;

public class p1766 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] pro = new boolean[N+1];
        ArrayList<Integer>[] graph = new ArrayList[N+1];
        int[] degree = new int[N+1];
        for(int i=1;i<=N;i++) graph[i] = new ArrayList<>();

        for(int i=0; i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            degree[b]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=1;i<=N;i++){
            if(degree[i]==0) pq.add(i);
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            int cur = pq.poll();
            sb.append(cur).append(' ');

            for(int i=0;i<graph[cur].size();i++){
                int next = graph[cur].get(i);
                if(degree[next]>0){
                    degree[next]--;
                    if(degree[next]==0) pq.add(next);
                }
            }
        }

        System.out.println(sb);
    }

}

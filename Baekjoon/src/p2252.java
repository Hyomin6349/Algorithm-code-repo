import java.util.*;
import java.io.*;

public class p2252 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] graph = new ArrayList[N+1];
        for(int i=1;i<=N;i++) graph[i] = new ArrayList<>();
        int[] indegree = new int[N+1];

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);//a<-b
            indegree[b]++;//b에서 나가는 화살표 수
        }

        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        for(int i=1;i<=N;i++){
            if(indegree[i] == 0) q.add(i);
        }

        while(!q.isEmpty()){
            int cur = q.poll();
            sb.append(cur+" ");

            for(int i=0;i<graph[cur].size();i++){
                int next = graph[cur].get(i);
                indegree[next]--;
                if(indegree[next]==0) q.add(next);
            }
        }

        System.out.println(sb);
    }
}

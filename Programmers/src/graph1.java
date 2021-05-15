
import java.util.*;

public class graph1 {
    public static class Node{
        int link;
        int idx;

        public Node(int l, int i){
            link = l;
            idx=i;
        }
    }
    public static int solution(int n, int[][] edge) {
        int answer = 0;
        int[] dis = new int[n+1];
        boolean[] visited = new boolean[n+1];
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        Queue<Node> q = new LinkedList<>();

        dis[1] = 0;
        visited[1] = true;
        for(int i=1;i<=n;i++) graph[i] = new ArrayList<>();

        for(int i=0;i<edge.length;i++){
            graph[edge[i][0]].add(edge[i][1]);
            graph[edge[i][1]].add(edge[i][0]);
            if(edge[i][0] == 1) q.add(new Node(1, edge[i][1]));
            if(edge[i][1] == 1) q.add(new Node(1, edge[i][0]));
        }

        while(!q.isEmpty()){
            Node cur = q.poll();
            if(visited[cur.idx]) continue;
            visited[cur.idx] = true;
            dis[cur.idx] = dis[cur.link]+1;
            for(int i=0; i<graph[cur.idx].size();i++){
                int next = graph[cur.idx].get(i);
                if(!visited[next]) q.add(new Node(cur.idx, next));
            }
        }

        int max = 0;
        for(int i=1;i<=n;i++){
            if(max < dis[i]) max = dis[i];
        }
        for(int i=1;i<=n;i++){
            if(dis[i]==max) answer++;
        }

        return answer;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n=6;
        int[][] vertex= {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};
        System.out.println(solution(n,vertex));
    }

}

import java.util.*;
import java.io.*;

public class p1504 {
    static ArrayList<Node>[] graph;
    static int v1, v2, N, INF=987654;

    public static class Node implements Comparable<Node>{
        int idx;
        int weight;
        public Node(int i, int w){
            idx = i;
            weight = w;
        }

        public int compareTo(Node o){
            return weight - o.weight;
        }
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        for(int i=1;i<=N;i++) graph[i] = new ArrayList<>();

        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        int c1 = dijkstra(1, v1) + dijkstra(v1, v2) + dijkstra(v2, N);  // 1 -> v1 -> v2 -> N
        int c2 = dijkstra(1, v2) +dijkstra(v2, v1) + dijkstra(v1, N);   // 1 -> v2 -> v1 -> N
        if(c2>=INF && c1>=INF) System.out.println(-1);
        else if(c1 < c2) System.out.println(c1);
        else System.out.println(c2);
    }

    public static int dijkstra(int start, int end){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] dis = new int[N+1];
        for(int i=1;i<=N;i++) dis[i] = INF;

        dis[start] = 0;
        for(int i=0;i<graph[start].size();i++){
            Node node = graph[start].get(i);
            dis[node.idx] = node.weight;
            pq.add(node);
        }

        while(!pq.isEmpty()){
            Node node = pq.poll();

            if(node.idx == end) break;
            if(dis[node.idx] < node.weight) continue;

            for(int i=0;i<graph[node.idx].size();i++){
                Node temp = graph[node.idx].get(i);

                if(dis[temp.idx] > node.weight + temp.weight){
                    dis[temp.idx] = node.weight + temp.weight;
                    pq.add(new Node(temp.idx, dis[temp.idx]));
                }
            }
        }

        return dis[end];
    }
}

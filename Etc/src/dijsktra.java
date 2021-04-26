import java.util.*;

public class dijsktra {
    public static class Node implements Comparable<Node>{
        int e;
        int w;
        public Node(int e, int w){
            this.e = e;
            this.w = w;
        }

        @Override
        public int compareTo(Node o){
            return this.w-o.w;
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int V = input.nextInt();
        int E = input.nextInt();
        input.nextLine();
        int K = input.nextInt();
        ArrayList<Node>[] graph = new ArrayList[V+1];

        while(E-->0){
            int s = input.nextInt();
            int e = input.nextInt();
            int w = input.nextInt();
            input.nextLine();
            graph[s].add(new Node(e,w));
        }

        int[] dis = new int[V+1];
        boolean[] visit = new boolean[V+1];

        for(int i=1;i<V+1; i++){
            dis[i] = Integer.MAX_VALUE;
        }

        dis[K] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(K, 0));

        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(visit[cur.e]) continue;
            visit[cur.e] = true;

            for(Node node: graph[cur.e]){
                if(!visit[node.e] && dis[node.e] > dis[cur.e] + node.w){
                    dis[node.e] = dis[cur.e]+node.w;
                    pq.add(new Node(node.e, dis[node.e]));
                }
            }
        }



        //print
        for(int i=0;i<V+1;i++){
            if(dis[i] == Integer.MAX_VALUE)
                System.out.println("INF");
            else System.out.println(dis[i]);
        }
    }
}

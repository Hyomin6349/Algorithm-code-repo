import java.util.*;
import java.io.*;

public class p1197 {

    static ArrayList<Node>[] graph;
    static int V,E;

    public static class Node implements Comparable<Node>{
        int idx;
        int weight;

        public Node(int i, int w){
            idx = i;
            weight = w;
        }

        public int compareTo(Node o){
            return weight-o.weight;
        }
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[V+1];
        for(int i=1;i<=V;i++) graph[i] = new ArrayList<>();
        for(int i=0;i<E;i++){
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[n1].add(new Node(n2, w));
            graph[n2].add(new Node(n1, w));
        }

        System.out.println(prim());
    }

    public static int prim(){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        ArrayList<Integer> in = new ArrayList<>();
        pq.add(new Node(1,0));

        int min_sum = 0;

        while(in.size()<V){
            Node node = pq.poll();
            if(!in.contains(node.idx)){
                in.add(node.idx);
                min_sum += node.weight;

                for(int i=0;i<graph[node.idx].size();i++){
                    Node next = graph[node.idx].get(i);
                    if(!in.contains(next.idx)) pq.add(next);
                }
            }
            else continue;
        }

        return min_sum;
    }

}

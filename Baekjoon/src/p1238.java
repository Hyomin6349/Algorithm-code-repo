import java.util.*;

public class p1238{
    public static class Node implements  Comparable<Node>{
        int dst;
        int weight;

        public Node(int d, int w){
            dst = d;
            weight = w;
        }

        @Override
        public int compareTo(Node o){
            return weight - o.weight;
        }
    }

    public static int[] cost(ArrayList<Node>[] arr, int n,int x){
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(x,0));
        int[] dis = new int[n+1];
        boolean[] check = new boolean[n+1];

        for(int i=1; i<=n;i++){
            dis[i] = 987654321;
            check[i] = false;
        }

        dis[x] = 0;

        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            int cur = curNode.dst;

            if(!check[cur]){
                check[cur] = true;

                for(Node node: arr[cur]){
                    if(!check[node.dst] && dis[node.dst] > node.weight + dis[cur]){
                        dis[node.dst] = node.weight + dis[cur];
                        pq.add(new Node(node.dst, dis[node.dst]));
                    }
                }
            }
        }
        return dis;
    }

    static ArrayList<Node>[] list;
    static ArrayList<Node>[] reverse;

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int m = input.nextInt();
        int x = input.nextInt();
        input.nextLine();

        list = new ArrayList[n+1];
        reverse = new ArrayList[n+1];

        for(int i=1; i<=n;i++){
            list[i] = new ArrayList<>();
            reverse[i] = new ArrayList<>();
        }
        for(int i=0;i<m;i++){
            int s = input.nextInt();
            int e = input.nextInt();
            int w = input.nextInt();

            list[s].add(new Node(e,w));
            reverse[e].add(new Node(s,w));

            input.nextLine();
        }

        int[] dis1 = cost(list, n, x);
        int[] dis2 = cost(reverse, n, x);

        int max = 0;
        for(int i=1;i<=n;i++){
            if(max < dis1[i]+dis2[i]) max = dis1[i] + dis2[i];
        }

        System.out.println(max);
    }
}

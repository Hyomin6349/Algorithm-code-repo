import java.util.*;

//메모리 초과 해결 못함 ㅠㅠ

public class p1916_pq {
    public static class Node implements Comparable<Node>{
        int end;
        int weight;

        public Node(int e, int w){
            end = e;
            weight = w;
        }

        @Override
        public int compareTo(Node o){
            return weight-o.weight; //숫자가 작을 수록 우선순위 높음
        }
    }

    public static int cost(int n, int start, int finish){
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        int[] dis = new int[n+1];

        for(int i=1; i<=n;i++){
            dis[i] = 100000;
        }

        pq.add(new Node(start, 0));
        dis[start] = 0;

        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            int cur = curNode.end;

            //cur 노드와 붙어있는 노드 중 길이가 업데이트 된 노드들을 pq에 추가
            for(Node node: list[cur]){
                if(dis[node.end] > dis[cur] + node.weight){
                    dis[node.end] = dis[cur] + node.weight;
                    pq.add(new Node(node.end, dis[node.end]));  //업데이트된 dis값을 넣음
                }
            }
        }

        return dis[finish];
    }

    static ArrayList<Node>[] list;

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = Integer.valueOf(input.nextLine());
        int m = Integer.valueOf(input.nextLine());

        list = new ArrayList[n+1];
        for(int i=1;i<=n;i++) list[i] = new ArrayList<Node>();

        for(int i=0; i<m; i++){
            int s = input.nextInt();
            int e = input.nextInt();
            int v = input.nextInt();
            list[s].add(new Node(e, v));
            input.nextLine();
        }

        int start = input.nextInt();
        int finish = input.nextInt();

        System.out.println(cost(n, start, finish));
    }
}

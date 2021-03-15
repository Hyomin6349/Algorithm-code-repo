import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int end;
    int weight;

    Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return weight - o.weight;
    }

}

public class p1916_pq {
    static int N, M;
    static ArrayList<ArrayList<Node>> a; // 인접리스트.
    static int[] dist; // 시작점에서 각 정점으로 가는 최단거리.
    static boolean[] check; // 방문 확인.

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        a = new ArrayList<>();
        dist = new int[N + 1];
        check = new boolean[N + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i <= N; i++) {
            a.add(new ArrayList<>());
        }

        // 단방향 인접 리스트 구현.
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            // start에서 end로 가는 weight (가중치)
            a.get(start).add(new Node(end, weight));
        }

        st = new StringTokenizer(br.readLine());
        int startPos = Integer.parseInt(st.nextToken());
        int endPos = Integer.parseInt(st.nextToken());

        bw.write(dijkstra(startPos, endPos) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    // 다익스트라 알고리즘
    public static int dijkstra(int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] check = new boolean[N + 1];
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.end;

            if (!check[cur]) {
                check[cur] = true;

                for (Node node : a.get(cur)) {
                    if (!check[node.end] && dist[node.end] > dist[cur] + node.weight) {
                        dist[node.end] = dist[cur] + node.weight;
                        pq.add(new Node(node.end, dist[node.end]));
                    }
                }
            }
        }
        return dist[end];
    }
}


/*
* import java.util.*;

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

* */
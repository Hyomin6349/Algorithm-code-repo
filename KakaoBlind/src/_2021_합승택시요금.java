import java.util.*;

public class _2021_합승택시요금 {

    static int[][] memo;
    static ArrayList<Edge>[] fareList;
    static int INF = 100001;

    public static class Edge implements Comparable<Edge>{
        int dst, weight;
        public Edge(int d, int w){
            dst = d; weight = w;
        }
        public int compareTo(Edge o){
            return weight-o.weight;
        }
    }

    public static void main(String[] args){
        int n = 6;
        int s = 4, a = 6, b = 2;
        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
        System.out.println(solution(n, s, a, b, fares));
    }

    public static int solution(int n, int s, int a, int b, int[][] fares) {
        memo = new int[n+1][n+1]; //start -> end로의 최소 거리 담는
        fareList = new ArrayList[n+1];
        for(int i=1;i<=n;i++) fareList[i] = new ArrayList<>();

        for(int i=0;i<fares.length; i++){
            int start = fares[i][0];
            int end = fares[i][1];
            int weight = fares[i][2];

            fareList[start].add(new Edge(end, weight));
            fareList[end].add(new Edge(start, weight));
        }

        dij(s, -1, n); //start에서 모든 점으로 최소 거리
        int min = memo[s][a] + memo[s][b]; //각자 따로 가는 경우
        for(int i=1; i<=n ;i++){ //합승 지점
            if(i==s || memo[s][i]==0 || memo[s][i] > min) continue;
            int val = memo[s][i];
            if(memo[i][a]==0) val += dij(i, a, n);
            else val += memo[i][a];
            if(memo[i][b]==0) val += dij(i, b, n);
            else val += memo[i][b];
            if(min>val) min = val;
        }

        return min;
    }

    public static int dij(int start, int end, int n){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] dis = new int[n+1];
        boolean[] visit = new boolean[n+1];
        for(int i=1; i<=n; i++) dis[i] = INF;
        pq.add(new Edge(start, 0));
        dis[start] = 0;

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            if(cur.dst==end) return cur.weight;
            if(visit[cur.dst]) continue;
            visit[cur.dst] = true;
            dis[cur.dst] = cur.weight;
            memo[start][cur.dst] = memo[cur.dst][start] = cur.weight;

            for(int i=0; i<fareList[cur.dst].size(); i++){
                Edge next = fareList[cur.dst].get(i);
                if(!visit[next.dst] && dis[next.dst] > dis[cur.dst] + next.weight){
                    dis[next.dst] = dis[cur.dst] + next.weight;
                    pq.add(new Edge(next.dst, dis[next.dst]));

                    memo[next.dst][cur.dst] = memo[cur.dst][next.dst] = dis[next.dst] - memo[start][cur.dst];
                }
            }
        }

        return INF;
    }
}

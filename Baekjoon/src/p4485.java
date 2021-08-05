import java.util.*;
import java.io.*;

public class p4485 {

    static int N;
    static int[][] map, d={{-1,1,0,0},{0,0,-1,1}};
    static int [][] dist;
    static boolean[][] visit;
    static PriorityQueue<Node> pq;

    public static class Node implements Comparable<Node>{
        int col;
        int row;
        int weight;

        public Node(int c, int r, int w){
            col = c;
            row = r;
            weight = w;
        }

        @Override
        public int compareTo(Node o){
            return weight - o.weight;
        }
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int tc = 0;

        while(true){
            tc++;
            N = Integer.parseInt(br.readLine());
            if(N==0) break;

            map = new int[N][N];
            dist = new int[N][N];
            visit = new boolean[N][N];
            pq = new PriorityQueue<>();

            for(int i=0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    dist[i][j] = 10000;
                }
            }

            dist[0][0] = map[0][0];
            pq.add(new Node(0,0,dist[0][0]));

            while(!pq.isEmpty()){
                Node node = pq.poll();
                int col = node.col;
                int row = node.row;

                if(visit[col][row]) continue;
                if(col == N-1 && row == N-1) break;
                visit[col][row] = true;

                for(int i=0;i<4;i++){
                    int nc = col + d[0][i];
                    int nr = row + d[1][i];

                    if(0<=nc && nc<N && 0<=nr && nr<N){
                        if(dist[nc][nr] > node.weight+ map[nc][nr]){
                            dist[nc][nr] = node.weight + map[nc][nr];
                            pq.add(new Node(nc, nr, dist[nc][nr]));
                        }
                    }
                }

            }


            sb.append("Problem "+tc+": "+dist[N-1][N-1]).append('\n');
        }

        System.out.println(sb);
    }

}

import java.util.*;
import java.io.*;

public class p1944 {

    public static class Node implements Comparable<Node>{
        int row, col;
        int dist;

        public Node(int r, int c, int d){
            row = r; col = c;
            dist = d;
        }

        public int compareTo(Node o){
            return dist - o.dist;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][N];
        include = new boolean[N][N];
        int row = 0, col = 0;
        left = M;

        for(int i=0;i<N;i++){
            String str = br.readLine();
            for(int j=0;j<N;j++){
                char c = str.charAt(j);
                map[i][j] = c;
                if(c=='S'){
                    row = i;
                    col = j;
                }
            }
        }

        boolean find = true;
        int sum = 0;
        while(left>0){
            if(find) findDist(row, col);
            Node node = pq.poll();
            row = node.row;
            col = node.col;

            if(include[row][col]){
                find = false;
                continue;
            }
            include[row][col] = true;
            left--;
            sum += node.dist;
            find = true;
        }

        System.out.println(sum);
    }

    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static int N, M, left;
    static char[][] map;
    static boolean[][] include;
    static int[][] d = {{-1, 1, 0, 0}, {0, 0, -1, 1}};

    public static void findDist(int r, int c){
        Queue<Node> q = new LinkedList<>();
        boolean[][] visit = new boolean[N][N];
        q.add(new Node(r, c, 0));
        visit[r][c] = true;
        int cnt = 0;

        while(!q.isEmpty()){
            Node cur = q.poll();

            for(int i=0;i<4;i++){
                int nr = cur.row + d[0][i];
                int nc = cur.col + d[1][i];

                if(!visit[nr][nc]){
                    if(map[nr][nc]!='1'){
                        q.add(new Node(nr, nc, cur.dist+1));
                        visit[nr][nc] = true;
                    }
                    if(map[nr][nc]=='K' && !include[nr][nc]){
                        pq.add(new Node(nr, nc, cur.dist+1));
                        cnt++;
                        if(cnt==left) return;
                    }
                }
            }
        }

        if(cnt<left){
            System.out.println(-1);
            System.exit(0);
        }
    }
}

import java.util.*;
import java.io.*;

public class p1967 {
    public static class Node{
        int val;
        int weight;
        public Node(int v, int w){
            val = v;
            weight = w;
        }
    }
    static ArrayList<Node>[] tree = new ArrayList[10001];
    static boolean[] visit;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        tree[1] = new ArrayList<>();

        if(N==1){
            System.out.println(0);
            return;
        }

        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            tree[c] = new ArrayList<>();
            tree[p].add(new Node(c, w));
            tree[c].add(new Node(p, w));
        }

        visit = new boolean[10001];
        int max_i = bfs(1).val;

        visit = new boolean[10001];
        int answer  = bfs(max_i).weight;

        System.out.println(answer);
    }

    public static Node bfs(int start){
        int max = 0;
        int idx = 0;
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(start, 0));
        visit[start] = true;

        while(!q.isEmpty()){
            Node node = q.poll();

            for(int i=0; i<tree[node.val].size();i++){
                Node cur = tree[node.val].get(i);

                if(!visit[cur.val]){
                    int w = node.weight + cur.weight;
                    q.add(new Node(cur.val, w));

                    if(max<w){
                        max = w;
                        idx = cur.val;
                    }
                    visit[cur.val] = true;
                }
            }
        }
        return new Node(idx, max);
    }
}

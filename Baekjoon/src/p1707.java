import java.util.*;
import java.io.*;

public class p1707 {
    public static class Node {
        int idx;
        int set;
        public Node(int i, int s) {
            idx = i; set = s;
        }
    }

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        while(T-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());


            ArrayList<Integer>[] graph;
            boolean[] visit;
            Set<Integer> set1 = new HashSet<>();
            Set<Integer> set2 = new HashSet<>();

            graph = new ArrayList[V+1];
            for(int i=1; i<=V; i++) graph[i] = new ArrayList<>();
            for(int i=0;i<E;i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                graph[s].add(e);
                graph[e].add(s);
            }

            visit = new boolean[V+1];
            Queue<Node> q = new LinkedList<>();
            boolean res = false;

            loop: for(int v=1;v<=V;v++) {
                if(!visit[v]) {
                    set1.add(v);
                    q.add(new Node(v, 1));
                    visit[v] = true;
                }

                while (!q.isEmpty()) {
                    Node cur = q.poll();

                    ArrayList<Integer> list = graph[cur.idx];

                    for (int i = 0; i < list.size(); i++) {
                        int next = list.get(i);
                        if (!visit[next]) {
                            visit[next] = true;
                            if (cur.set == 1) {
                                set2.add(next);
                                q.add(new Node(next, 2));
                            } else {
                                set1.add(next);
                                q.add(new Node(next, 1));
                            }
                        } else {
                            if ((cur.set == 1 && !set2.contains(next)) || (cur.set == 2 && !set1.contains(next))) {
                                sb.append("NO\n");
                                res = true;
                                break loop;
                            }
                        }
                    }
                }

            }
            if(!res) sb.append("YES\n");
        }

        System.out.println(sb);

    }

}

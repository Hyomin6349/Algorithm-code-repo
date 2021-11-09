import java.util.*;
import java.io.*;

public class p2213 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        W = new int[N+1];
        visit = new boolean[N+1];
        memo = new int[N+1][2]; //i 번째 노드를 선택한 경우와 선택하지 않은 경우
        tree = new ArrayList[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            tree[i] = new ArrayList<>();
            W[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=1;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        dfs(1);

        visit = new boolean[N+1];
        if(memo[1][0] > memo[1][1]){
            System.out.println(memo[1][0]);
            trace(1, 0);
        } else{
            System.out.println(memo[1][1]);
            trace(1, 1);
        }

        Collections.sort(res);
        for(int num : res ) {
            System.out.print(num+" ");
        }

    }

    static int N;
    static int[] W;
    static boolean[] visit;
    static int[][] memo;
    static ArrayList<Integer>[] tree;
    static ArrayList<Integer> res = new ArrayList<>();

    public static void dfs(int cur){
        int child_size = tree[cur].size();

        memo[cur][0] = 0;
        memo[cur][1] = W[cur];
        visit[cur] = true;

        for(int i=0;i<child_size;i++){
            int next = tree[cur].get(i);
            if(!visit[next]){
                dfs(next);

                memo[cur][0] += Math.max(memo[next][0], memo[next][1]);
                memo[cur][1] += memo[next][0];
            }
        }
    }

    public static void trace(int cur, int inc){
        visit[cur] = true;

        if(inc==1){
            res.add(cur);
            for(int next:tree[cur]){
                if(!visit[next]) trace(next, 0);
            }
        } else {
            for(int next:tree[cur]){
                if(!visit[next]){
                    if(memo[next][1] > memo[next][0]){
                        trace(next, 1);
                    } else trace(next, 0);
                }
            }
        }
    }
}

import java.util.*;
import java.io.*;

public class p11725 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] tree = new ArrayList[N+1];
        for(int i=1;i<=N;i++) tree[i] = new ArrayList<>();

        for(int i=1;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        boolean[] visit = new boolean[N+1];
        int[] memo = new int[N+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        visit[1] = true;

        while(!q.isEmpty()){
            int idx = q.poll();
            int size = tree[idx].size();

            for(int i=0;i<size;i++){
                int val = tree[idx].get(i);
                if(!visit[val]){
                    memo[val] = idx;
                    visit[val] = true;
                    q.add(val);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=2;i<=N;i++){
            sb.append(memo[i]).append('\n');
        }

        System.out.println(sb);
    }
}

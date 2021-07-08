import java.util.*;
import java.io.*;

public class p1005 {

    static int[] delay, memo;
    static ArrayList<ArrayList<Integer>> nodes;

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());

        while(tc-->0){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            nodes = new ArrayList<>();
            delay = new int[n+1];
            memo = new int[n+1];
            Arrays.fill(memo, -1);

            st = new StringTokenizer(br.readLine());
            for(int i=1;i<=n;i++){
                delay[i] = Integer.parseInt(st.nextToken());
                nodes.add(new ArrayList<>());
            }
            nodes.add(new ArrayList<>());

            while(k-->0){
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());

                nodes.get(e).add(s);
            }

            int dst = Integer.parseInt(br.readLine());
            sb.append(getTime(dst)).append('\n');
        }

        System.out.println(sb);
    }

    public static int getTime(int idx){
        if(memo[idx]!=-1) return memo[idx];
        if(nodes.get(idx).size()==0) return delay[idx];

        int max = 0;
        for(int income: nodes.get(idx)){
            max = Math.max(max, getTime(income)+delay[idx]);
        }
        memo[idx] = max;
        return max;
    }
}

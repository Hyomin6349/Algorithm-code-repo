import java.util.*;
import java.io.*;

public class p2056 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        tasks = new int[N+1];
        graph = new ArrayList[N+1];
        memo = new int[N+1];

        for(int i=1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            tasks[i] = Integer.parseInt(st.nextToken());
            graph[i] = new ArrayList<>();

            int preNum = Integer.parseInt(st.nextToken());
            while(preNum-->0){
                int pre = Integer.parseInt(st.nextToken());
                graph[i].add(pre);
            }
        }

        int answer = 0;
        for(int i=N;i>0;i--){
            answer = Math.max(answer, getTime(i));
        }
        System.out.println(answer);
    }

    static int[] memo;
    static ArrayList<Integer>[] graph;
    static int[] tasks;

    public static int getTime(int idx){
        if(memo[idx]!=0) return memo[idx];

        int time = tasks[idx];

        for(int i=0; i<graph[idx].size();i++){
            time = Math.max(time, tasks[idx]+getTime(graph[idx].get(i)));
        }

        memo[idx] = time;
        return time;
    }
}

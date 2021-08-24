import java.util.*;

public class p14226 {

    static int S, min = Integer.MAX_VALUE;
    static boolean[][] visit = new boolean[2002][2002];

    public static class State{
        int monitor, copy, time;
        public State(int m, int c, int t){
            monitor = m;
            copy = c;
            time = t;
        }
    }

    public static  void main(String[] args){
        Scanner sc = new Scanner(System.in);
        S  = sc.nextInt();
        bfs();
    }

    public static void bfs(){ //가장 최소 시간 찾기
        Queue<State> q = new LinkedList<>();
        q.add(new State(1, 0, 0));

        while(!q.isEmpty()){
            State cur = q.poll();
            if(visit[cur.monitor][cur.copy]) continue;
            visit[cur.monitor][cur.copy] = true;
            if(cur.monitor == S) min = Math.min(min, cur.time);

            if(cur.monitor < S){
                if(!visit[cur.monitor][cur.monitor]){
                    q.add(new State(cur.monitor, cur.monitor, cur.time+1));
                }
                if(cur.copy!=0 && !visit[cur.monitor+cur.copy][cur.copy]) {
                    q.add(new State(cur.monitor + cur.copy, cur.copy, cur.time + 1));
                }
                if(cur.monitor>1 && !visit[cur.monitor-1][cur.copy]){
                    q.add(new State(cur.monitor-1, cur.copy, cur.time+1));
                }
            }
            else if(cur.monitor>1 && !visit[cur.monitor-1][cur.copy]) {
                q.add(new State(cur.monitor - 1, cur.copy, cur.time + 1));
            }
        }

        System.out.println(min);
    }
}

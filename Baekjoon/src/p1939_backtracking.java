import java.util.*;

public class p1939_backtracking {
    public static class Bridge{
        int end;
        int weight;
        public Bridge(int e, int w){
            this.end = e;
            this.weight= w;
        }
    }

    public static void dfs(int cur){
        if(cur == end){
            int val =stack.pop();
            if(answer < val) answer = val;
            set.remove(cur);
            return;
        }

        for(Bridge bridge : bridges[cur]){
            if(bridge.weight > answer && set.add(bridge.end)){
                int val = stack.peek();
                if(val > bridge.weight) val = bridge.weight;
                stack.add(val);
                dfs(bridge.end);
            }
        }
        set.remove(cur);
        stack.pop();
    }

    static ArrayList<Bridge> bridges[];
    static HashSet<Integer> set = new HashSet<>();
    static Stack<Integer> stack = new Stack<>();
    static int end;
    static long answer=0;

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        int m = input.nextInt();

        bridges = new ArrayList[n+1];
        for(int i=1; i<=n;i++) bridges[i] = new ArrayList<>();

        while(m-->0){
            int s = input.nextInt();
            int e = input.nextInt();
            int w = input.nextInt();
            input.nextLine();
            bridges[s].add(new Bridge(e, w));
            bridges[e].add(new Bridge(s, w));
        }

        int start = input.nextInt();
        end = input.nextInt();
        set.add(start);
        stack.push(1000000001);
        dfs(start);
        System.out.println(answer);
    }
}

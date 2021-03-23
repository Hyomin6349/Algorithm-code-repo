import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class p1939_binarySearch {
    public static class Bridge{
        int end;
        int weight;
        public Bridge(int e, int w){
            this.end = e;
            this.weight= w;
        }
    }

    static Queue<Integer> queue = new LinkedList<>();
    static boolean visit[];

    public static boolean bfs(int mid){
        queue.clear();
        queue.add(start);
        for(int i=1;i<=n;i++) visit[i] = false;
        visit[start] = true;

        while(!queue.isEmpty()){
            int cur = queue.poll();
            if(cur == end) return true;

            for(Bridge b: bridges[cur]){
                if(!visit[b.end] && mid <= b.weight){
                    queue.add(b.end);
                    visit[b.end] = true;
                }
            }
        }

        return false;
    }

    static ArrayList<Bridge> bridges[];
    static int n,start, end;

    private static int stoi(String s) {
        return Integer.parseInt(s);
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = stoi(st.nextToken());
        int m = stoi(st.nextToken());

        bridges = new ArrayList[n+1];
        visit = new boolean[n+1];
        for(int i=1; i<=n;i++) bridges[i] = new ArrayList<>();

        int min = 1, max = 0;

        while(m-->0){
            st = new StringTokenizer(br.readLine());
            int s = stoi(st.nextToken());
            int e = stoi(st.nextToken());
            int w = stoi(st.nextToken());

            max = w > max ? w: max;

            bridges[s].add(new Bridge(e, w));
            bridges[e].add(new Bridge(s, w));
        }
        st = new StringTokenizer(br.readLine());
        start = stoi(st.nextToken());
        end = stoi(st.nextToken());
        int answer = 0;

        while(min <= max){
            int mid = (min + max)/2;

            if(bfs(mid)){
                answer = mid;
                min = mid+1;
            }
            else max = mid-1;
        }

        System.out.println(answer);
    }
}

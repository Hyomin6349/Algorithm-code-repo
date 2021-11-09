import java.util.*;
import java.io.*;

public class p12100 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, map);
        System.out.println(answer);
    }

    static int N, answer = 0;
    static int[][] d = {{-1, 1, 0, 0}, {0, 0, -1, 1}};

    public static void dfs(int cnt, int[][] map){
        if(cnt==5){
            int val = getMax(map);
            answer = Math.max(answer ,val);
            return;
        }

        for(int i=0;i<4;i++){
            int[][] newMap = move(map);
            dfs(cnt+1, newMap);
            map = rotate(map);
        }
    }

    public static int[][] rotate(int[][] map){
        int[][] newMap = new int[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                newMap[i][j] = map[j][N-1-i];
            }
        }
        return newMap;
    }

    public static int[][] move(int[][] map){
        int[][] newMap = new int[N][N];
        for(int i=0;i<N;i++){
            boolean flag = false;
            Stack<Integer> stack = new Stack<>();
            int j=0;
            while(j<N && map[i][j]==0) j++;
            if(j<N) stack.push(map[i][j++]);

            for(;j<N;j++){
                if(map[i][j]==0) continue;
                boolean op = false;
                int pre = stack.peek();
                if(pre!=map[i][j] || (pre==map[i][j] && flag)){
                    stack.add(map[i][j]);
                    flag = false;
                    op = true;
                }
                if(!op && pre==map[i][j] && !flag){
                    flag = true;
                    stack.pop();
                    stack.push(map[i][j]*2);
                }
            }

            int idx = stack.size();
            while(!stack.isEmpty()){
                newMap[i][--idx] = stack.pop();
            }
        }

        return newMap;
    }

    public static int getMax(int[][] map){
        int val = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                val = Math.max(map[i][j], val);
            }
        }
        return val;
    }
}

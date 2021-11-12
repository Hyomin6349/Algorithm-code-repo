import java.util.*;

public class p1941 {
    public static class Pos{
        int row, col;
        public Pos(int r, int c){
            row = r; col = c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<5;i++){
            String str = sc.nextLine();
            for(int j=0;j<5;j++){
                char c = str.charAt(j);
                if(c=='S') sList.add(i*5+j);
                else yList.add(i*5+j);
            }
        }

        if(sList.size()<4){
            System.out.println(0);
            System.exit(0);
        }

        for(int i=4;i<=Math.min(sList.size(), 7); i++){
            sComb(new int[7], 0, 0,i);
        }

        System.out.println(answer);
    }

    static ArrayList<Integer> sList = new ArrayList<>();
    static ArrayList<Integer> yList = new ArrayList<>();
    static int[][] d = {{-1, 1, 0, 0}, {0, 0, -1, 1}};
    static int answer = 0;

    public static void sComb(int[] select, int cnt, int start, int num){
        if(cnt==num){
            yComb(select, cnt, 0);
            return;
        }

        for(int i=start; i<sList.size();i++){
            select[cnt] = sList.get(i);
            sComb(select, cnt+1, i+1, num);
        }
    }

    public static void yComb(int[] select, int cnt, int start){
        if(cnt==7){
            if(check(select)) answer++;
            return;
        }

        for(int i=start; i<yList.size();i++){
            select[cnt] = yList.get(i);
            yComb(select, cnt+1, i+1);
        }
    }

    public static boolean check(int[] select){
        boolean[][] map = new boolean[5][5];
        for(int i=0;i<select.length;i++){
            int idx = select[i];
            int row = idx/5;
            int col = idx%5;
            map[row][col] = true;
        }

        int cnt = bfs(select[0], map);
        if(cnt==7) return true;
        else return false;
    }

    public static int bfs(int idx, boolean[][] map){
        int cnt = 1;

        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(idx/5, idx%5));
        boolean[][] visit = new boolean[5][5];
        visit[idx/5][idx%5] = true;

        while(!q.isEmpty()){
            Pos cur = q.poll();

            for(int i=0;i<4;i++){
                int nr = cur.row + d[0][i];
                int nc = cur.col + d[1][i];
                if(0<=nr && nr<5 && 0<=nc && nc<5 && !visit[nr][nc] && map[nr][nc]){
                    cnt ++;
                    visit[nr][nc] = true;
                    q.add(new Pos(nr, nc));
                }
            }
        }

        return cnt;
    }
}

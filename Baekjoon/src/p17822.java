import java.util.*;
import java.io.*;

public class p17822 {
    static int[][] board;
    static HashSet<Pos> set;
    static int sum, num, n, m, x[], d[], k[];

    public static class Pos{
        int r;
        int c;
        public Pos(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    //x 배수의 원판을 d 방향으로 k번 회전
    //d=0: 시계 방향, d=1: 반시계 방향
    public static void rotate(int t){
        for(int i=0;i<n;i++){
            if((i+1)%x[t]==0){
                int[] temp = board[i].clone();
                for (int j = 0; j < m; j++) {
                    if(d[t] == 0) board[i][(j+k[t])%m] = temp[j];
                    if(d[t] == 1) board[i][(m+j-k[t])%m] = temp[j];
                }
            }
        }
    }

    public static void seek(int r, int c){
        if(board[r][c]!=0) {
            sum += board[r][c];
            num ++;

            if (r < n - 1 && board[r][c] == board[r + 1][c]) {
                set.add(new Pos(r, c));
            }
            if (r > 0 && board[r][c] == board[(n + r - 1) % n][c]) set.add(new Pos(r, c));
            if (board[r][c] == board[r][(c + 1) % m] || board[r][c] == board[r][(m + c - 1) % m])
                set.add(new Pos(r, c));
        }

        if(c<m-1) seek(r,c+1);
        else if(r<n-1) seek(r+1, 0);
    }

    public static void remove(){
        Iterator it = set.iterator();
        while(it.hasNext()){
            Pos pos = (Pos)it.next();
            board[pos.r][pos.c] = 0;
        }
    }

    public static void renewal(){
        if(num == 0) return;
        float avg = (float)sum/num;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == 0) continue;
                if(board[i][j] > avg) board[i][j]--;
                else if(board[i][j] < avg) board[i][j]++;
            }
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        board = new int[n][m];
        x = new int[t];
        d = new int[t];
        k = new int[t];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<m;j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<t;i++){
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            d[i] = Integer.parseInt(st.nextToken());
            k[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0;i<t;i++){
            sum = 0;
            num = 0;
            set = new HashSet<>();
            rotate(i);
            seek(0,0);
            if(set.isEmpty()) renewal();
            else remove();
        }

        int answer=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                answer += board[i][j];
            }
        }

        System.out.println(answer);
    }
}

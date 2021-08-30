import java.util.*;

public class _2021_카드짝맞추기 {

    public static class Pos{
        int r, c;
        public Pos(int r, int c){
            this.r = r; this.c = c;
        }
    }

    static int[][] Board;
    static Pos[][] cards = new Pos[7][2];
    static boolean[] visit = new boolean[7];
    static boolean[] exist = new boolean[7];
    static int[] select = new int[7];
    static int[] order = new int[7];
    static int min = Integer.MAX_VALUE;
    static int cnt = 0;

    public static int solution(int[][] board, int r, int c) {
        Board = board;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(board[i][j]!=0){
                    int card = board[i][j];
                    if(cards[card][0]==null){
                        exist[card] = true;
                        cards[card][0] = new Pos(i, j);
                        cnt++;
                    }
                    else cards[card][1] = new Pos(i,j);
                }
            }
        }

        perm(0, r, c);

        return min;
    }

    public static void perm(int cc, int r, int c){
        if(cc==cnt){
            getOrder(1, r, c);
            return;
        }

        for(int i=1; i<7; i++){
            if(exist[i] && !visit[i]){
                visit[i] = true;
                select[cc] = i;
                perm(cc+1, r, c);
                visit[i] = false;
            }
        }
    }

    public static void getOrder(int cc, int r, int c){
        if(cc==7){
            getAnswer(r, c);
            return;
        }


        if(exist[cc]){
            order[cc] = 1;
            getOrder(cc+1, r, c);
        }
        order[cc] = 0;
        getOrder(cc+1, r, c);
    }
    // select, order
    static boolean[] copy_exist;
    public static void getAnswer(int r, int c){
        copy_exist = exist.clone();
        int move = 0;
        loop : for(int i=0; i<cnt; i++){
            int card = select[i]; //삭제할 카드

            for(int j=0;j<2; j++){
                int dr = cards[card][(order[card]+j)%2].r;
                int dc = cards[card][(order[card]+j)%2].c;
                int val = Math.min(moveTo(r, c, dr, dc), moveTo2(r,c, dr, dc));
                move += val;
                r = dr; c = dc;

                if(move > min) break loop;
            }
            copy_exist[card] = false;
        }
        if(min > move) min = move;
    }

    public static int moveTo(int r, int c, int dr, int dc){
        int mr = Math.abs(r-dr);
        if(r>dr){
            int temp = r-1;
            while(temp>0){
                if(Board[temp][c]!=0 && copy_exist[Board[temp][c]]) break;
                temp--;
            }
            mr = Math.min(mr, Math.abs(temp-dr)+1);
        }
        else if(r<dr){
            int temp = r+1;
            while(temp<3){
                if(Board[temp][c]!=0 && copy_exist[Board[temp][c]]) break;
                temp++;
            }
            mr = Math.min(mr, Math.abs(temp-dr)+1);
        }

         int mc = Math.abs(c-dc);
        if(c>dc){
            int temp = c-1;
            while(temp>0){
                if(Board[dr][temp]!=0 && copy_exist[Board[dr][temp]]) break;
                temp--;
            }
            mc = Math.min(mc, Math.abs(temp-dc)+1);
        }
        else if(c<dc){
            int temp = c+1;
            while(temp<3){
                if(Board[dr][temp]!=0 && copy_exist[Board[dr][temp]]) break;
                temp++;
            }
            mc = Math.min(mc, Math.abs(temp-dc)+1);
        }

        return mr+mc+1;
    }

    public static int moveTo2(int r, int c, int dr, int dc){
        int mc = Math.abs(c-dc);
        if(c>dc){
            int temp = c-1;
            while(temp>0){
                if(Board[r][temp]!=0 && copy_exist[Board[r][temp]]) break;
                temp--;
            }
            mc = Math.min(mc, Math.abs(temp-dc)+1);
        }
        else if(c<dc){
            int temp = c+1;
            while(temp<3){
                if(Board[r][temp]!=0 && copy_exist[Board[r][temp]]) break;
                temp++;
            }
            mc = Math.min(mc, Math.abs(temp-dc)+1);
        }

        int mr = Math.abs(r-dr);
        if(r>dr){
            int temp = r-1;
            while(temp>0){
                if(Board[temp][dc]!=0 && copy_exist[Board[temp][dc]]) break;
                temp--;
            }
            mr = Math.min(mr, Math.abs(temp-dr)+1);
        }
        else if(r<dr){
            int temp = r+1;
            while(temp<3){
                if(Board[temp][dc]!=0 && copy_exist[Board[temp][dc]]) break;
                temp++;
            }
            mr = Math.min(mr, Math.abs(temp-dr)+1);
        }

        return mr+mc+1;
    }

    public static void main(String[] args) {
        int[][] board = {{1,0,0,3},{2,0,0,0},{0,0,0,2},{3,0,1,0}};
        System.out.println(solution(board, 1, 0));
    }
}

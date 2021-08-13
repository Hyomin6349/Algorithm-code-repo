import java.util.*;
import java.io.*;

public class p17135 {

    static int N, M, D, max = 0;
    static Pos[] archers = new Pos[3];
    static ArrayList<Pos> save = new ArrayList<>();

    public static class Pos{
        int col, row;
        public Pos(int c, int r) {
            col = c; row = r;
        }
    }

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++) {
                if(st.nextToken().equals("1")) save.add(new Pos(i, j));
            }
        }

        comb(0, 0);
        System.out.println(max);
    }

    public static void comb(int cnt, int start) {
        if(cnt == 3) {
            int removeCnt = gameStart();
            if(max < removeCnt) max = removeCnt;
            return;
        }

        for(int i=start;i<M;i++) {
            int col = N;
            int row = i;
            archers[cnt] = new Pos(col, row);
            comb(cnt+1, i+1);
        }
    }

    public static int gameStart() {
        ArrayList<Pos> enemies = new ArrayList<>();
        for(int i=0;i<save.size();i++) enemies.add(new Pos(save.get(i).col, save.get(i).row));
        int size = save.size();
        boolean[] remove = new boolean[size];
        int num = size;
        int removeCnt = 0;

        while(num > 0) {
            int[] select = new int[3];

            for(int i=0;i<3;i++) { //궁수별 공격할 적 선택
                Pos archer = archers[i];
                int minDis = D;
                int minIdx = -1;

                for(int j=0;j<size;j++) {
                    if(!remove[j]) {
                        Pos enemy = enemies.get(j);
                        int dis = Math.abs(archer.col-enemy.col) + Math.abs(archer.row-enemy.row);
                        if(minDis > dis || (minDis==dis && minIdx==-1)) {
                            minDis = dis;
                            minIdx = j;
                        }
                        else if(minDis==dis && enemies.get(minIdx).row > enemy.row) {
                            minDis = dis;
                            minIdx = j;
                        }
                    }
                }

                select[i] = minIdx;
            }

            for(int i=0;i<3;i++) {
                int val = select[i];
                if(val!=-1 && !remove[val]) {
                    remove[val] = true;
                    removeCnt++;
                    num--;
                }
            }


            for(int i=0;i<size;i++) { //적 아래로 이동
                if(!remove[i]) {
                    Pos enemy = enemies.get(i);
                    enemy.col ++;
                    if(enemy.col >= N) {
                        remove[i] = true;
                        num--;
                    }
                    else enemies.set(i, enemy);
                }
            }
        }

        return removeCnt;
    }
}

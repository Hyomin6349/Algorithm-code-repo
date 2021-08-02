import java.util.*;

public class p14502 {

    static int N, M, answer=0;
    static int[][] map;
    static Queue<Pos> q = new LinkedList<>();

    public static class Pos{
        int col;
        int row;

        public Pos(int c, int r){
            col = c;
            row = r;
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        M = input.nextInt();
        map = new int[N][M];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                int val = input.nextInt();
                map[i][j] = val;
                if(val==2) q.add(new Pos(i,j));
            }
        }

        comb(0,0);

        System.out.println(answer);
    }

    //벽 3개 combination으로 구하기
    public static void comb(int n, int start){
        if(n==3){
            //새로운 배열 만들기
            int[][] temp = new int[N][M];
            for(int i=0;i<N;i++) temp[i] = map[i].clone();
            expand(temp);
            return;
        }

        for(int i=start;i<N*M;i++){
            int col = i/M;
            int row = i%M;
            if(map[col][row]==0){
                map[col][row] = 1;
                comb(n+1, start+1);
                map[col][row] = 0;
            }
        }
    }


    //바이러스 퍼짐
    public static void expand(int[][] temp){
        Queue<Pos> que = new LinkedList<>();
        Iterator<Pos> it = q.iterator();
        while(it.hasNext()) que.add(it.next());

        int[][] d = {{-1,1,0,0},{0,0,-1,1}};

        while(!que.isEmpty()){
            Pos pos = que.poll();

            for(int i=0;i<4;i++){
                int nc = pos.col + d[0][i];
                int nr = pos.row + d[1][i];

                if(0<=nc && nc<N && 0<=nr && nr<M){
                    if(temp[nc][nr]==0){
                        temp[nc][nr] = 2;
                        que.add(new Pos(nc, nr));
                    }
                }
            }
        }

        int val = countSafe(temp);
        if(answer < val) answer = val;
    }

    //안전구역 세기
    public static int countSafe(int[][] temp){
        int num = 0;
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(temp[i][j]==0) num++;
            }
        }
        return num;
    }
}

import java.util.*;

public class p4179 {

    static char[][] map;
    static Queue<Point> jihun = new LinkedList<>();
    static Queue<Point> fire = new LinkedList<>();
    static int[][] d = {{-1, 1, 0, 0}, {0,0,-1,1}}; //상하좌우
    static boolean[][] check;   //지훈이의 발자취

    public static class Point{
        int col;
        int row;

        public Point(int c, int r){
            col = c;
            row = r;
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int R = input.nextInt();    //행
        int C = input.nextInt();    //열
        input.nextLine();
        map = new char[R][C];
        check = new boolean[R][C];

        for(int i=0;i<R;i++){
            String str = input.nextLine();
            for(int j=0;j<C;j++){
                char c = str.charAt(j);
                if(c=='J'){
                    if(i==0 || i==R-1 || j==0 || j==C-1){
                        System.out.println(1);
                        System.exit(0);
                    }

                    check[i][j] = true;
                    jihun.add(new Point(i,j));
                    c = '.';
                }
                if(c=='F') fire.add(new Point(i,j));

                map[i][j] = c;
            }
        }

        int time = 0;
        while(!jihun.isEmpty()){
            time++;

            //불확장
            int f_num = fire.size();
            while(f_num-->0){
                Point p = fire.poll();

                for(int i=0;i<4;i++){
                    int dc = p.col + d[0][i];
                    int dr = p.row + d[1][i];

                    if(0<=dc && dc<R && 0<=dr && dr<C){
                        if(map[dc][dr] == '.'){
                            fire.add(new Point(dc, dr));
                            map[dc][dr] = 'F';
                        }
                    }
                }
            }

            //지훈이동
            int j_num = jihun.size();
            while(j_num-->0){
                Point p = jihun.poll();

                for(int i=0;i<4;i++){
                    int dc = p.col + d[0][i];
                    int dr = p.row + d[1][i];

                    if(0<=dc && dc<R && 0<=dr && dr<C){
                        if(map[dc][dr] == '.' && !check[dc][dr]){
                            //is탈출구?
                            if(dc==0 || dc==R-1 || dr==0 || dr==C-1){
                                System.out.println(time+1);
                                System.exit(0);
                            }
                            check[dc][dr] = true;
                            jihun.add(new Point(dc, dr));
                        }
                    }
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }

}

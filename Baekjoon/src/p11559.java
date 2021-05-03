import java.util.*;

public class p11559 {

    static char[][] field;
    static boolean[][] visit;
    static Queue<Point> block = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static class Point{
        int row;
        int col;

        public Point(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        field = new char [12][6];
        visit = new boolean[12][6];

        for(int i=0;i<12;i++){
            String line = input.nextLine();
            int idx=0;
            while(idx<6){
                field[i][idx] = line.charAt(idx++);
            }
        }

        int answer =0;
        while(true){
            setVisit();
            boolean finish = true;
            for(int i=0;i<12;i++){
                for(int j=0;j<6;j++){
                    if(!visit[i][j]){
                        block.clear();
                        bfs(i,j, field[i][j]);
                        if(block.size()>=4){
                            bomb();
                            finish = false;
                        }
                    }
                }
            }

            if(finish) break;
            down();
            answer ++;
        }

        System.out.println(answer);
    }


    public static void setVisit(){
        for(int i=0;i<12;i++){
            for(int j=0;j<6;j++){
                if(field[i][j] == '.') visit[i][j] = true;
                else visit[i][j] = false;
            }
        }
    }

    public static void bfs(int row, int col, char c){
        if(field[row][col] != c) return;

        block.add(new Point(row, col));
        visit[row][col] = true;

        for(int i=0;i<4;i++){
            int ny = row + dy[i];
            int nx = col + dx[i];

            if(0<= ny  && ny < 12 && 0<= nx && nx< 6){
                if(!visit[ny][nx]) bfs(ny, nx, c);
            }
        }
    }

    public static void bomb(){
        while(!block.isEmpty()){
            Point p = block.poll();
            field[p.row][p.col] = '.';
        }
    }

    public static void down(){
        for(int j=0;j<6;j++){
            int ground = 11;
            for(int i=11;i>=0;i--){
                if(field[i][j] != '.'){
                    char temp = field[i][j];
                    field[i][j]= '.';
                    field[ground--][j] = temp;
                }
            }
        }
    }

}

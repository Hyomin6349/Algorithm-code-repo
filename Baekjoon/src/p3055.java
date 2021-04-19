import java.util.*;

public class p3055 {

    static int row, column, answer = 0;
    static char map[][];
    static int[] dx = { -1, 0, 1, 0 };
    static int[] dy = { 0, -1, 0, 1 };
    static Queue<Point> water = new LinkedList<>();
    static Queue<Point> hog = new LinkedList<>();

    public static class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        row = input.nextInt();
        column = input.nextInt();
        map = new char[row][column];
        input.nextLine();

        for(int i=0; i<row; i++){
            char[] temp = input.nextLine().toCharArray();
            for(int j=0;j<column; j++){
                map[i][j] = temp[j];
                if(temp[j] == '*') water.add(new Point(i,j));
                if(temp[j] == 'S') hog.add(new Point(i,j));
            }
        }

        while(true){
            answer++;
            if(hog.size() == 0){
                System.out.println("KAKTUS");
                return;
            }
            waterExpand();
            if(hogMove()){
                System.out.println(answer);
                return;
            }
        }
    }

    public static void waterExpand(){
        int size = water.size();

        for(int i=0 ; i<size; i++){
            Point p = water.poll();

            for (int j = 0; j < 4; j++) {
                int nx = dx[j] + p.x;
                int ny = dy[j] + p.y;

                if (0 <= nx && nx < row && 0 <= ny && ny < column) {
                    if (map[nx][ny] == '.') {
                        map[nx][ny] = '*';
                        water.add(new Point(nx, ny));
                    }
                }
            }
        }
    }

    public static boolean hogMove(){
        int size = hog.size();

        for(int i=0; i<size; i++){
            Point p = hog.poll();

            for (int j = 0; j < 4; j++) {
                int nx = dx[j] + p.x;
                int ny = dy[j] + p.y;

                if (0 <= nx && nx < row && 0 <= ny && ny < column) {
                    if (map[nx][ny] == 'D') {
                        hog.add(new Point(nx, ny));
                        return true;
                    }
                    if (map[nx][ny] == '.'){
                        map[nx][ny] = 'S';
                        hog.add(new Point(nx, ny));
                    }
                }
            }
        }
        return false;
    }
}

import java.util.*;

public class p3055 {

    static int row, column, move=0;
    static char map[][];
    static boolean finish = true;

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        row = input.nextInt();
        column = input.nextInt();
        map = new char[row][column];
        input.nextLine();

        for(int i=0; i<row; i++){
            String temp = input.nextLine();
            map[i] = temp.toCharArray();
        }

        int hog_r=0, hog_c=0;
        for(int i=0; i<row; i++){
            for(int j=0;j<column;j++){
                if(map[i][j] == 'S'){
                    hog_r = i;
                    hog_c = j;
                }
            }
        }

        solution(hog_r, hog_c);
    }

    public static void solution(int r, int c){
        if(finish) return;
        move++;
        waterExpand();

    }

    public static void waterExpand(){
        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++){
                if(map[i][j] == '*'){
                    if(i-1>=0 && map[i-1][j]=='.') map[i-1][j] = '*';
                    if(i+1<row && map[i+1][j]=='.') map[i+1][j] = '*';
                    if(j-1>=0 && map[i][j-1]=='.') map[i][j-1] = '*';
                    if(j+1<column && map[i][j+1]=='.') map[i][j+1] = '*';
                }
            }
        }
    }


}

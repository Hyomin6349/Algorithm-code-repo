import java.util.*;

public class p2239 {

    static int[][] puzzle = new int[9][9];

    public static void main(String args[]){
        Scanner input = new Scanner(System.in);

        for(int i=0;i<9;i++){
            String line = input.nextLine();
            for(int j=0;j<9;j++){
                puzzle[i][j] = line.charAt(j)-'0';
            }
        }

        solve(0,0);
        print();
    }

    public static void solve(int i, int j){
        if(puzzle[i][j]==0){
            for(int k=1;k<=9;k++){
                if(isPossible(k, i, j)){
                    int tmp = puzzle[i][j];
                    puzzle[i][j] = k;
                    next(i,j);
                    puzzle[i][j] = tmp;
                }
            }
        }
        else next(i,j);
    }

    public static void next(int i, int j){
        if(i==8 && j==8) {
            print();
            System.exit(0); //안 끝내면 오답..
        }
        if(j==8) solve(i+1, 0);
        else solve(i,j+1);
    }

    public static boolean isPossible(int k, int i, int j){
        boolean pos = true;
        for(int n=0;n<9;n++){   //행,열 검사
            if(puzzle[n][j]==k || puzzle[i][n]==k){
                pos=false;
                break;
            }
        }
        int mod1 = i%3;
        int mod2 = j%3;
        for(int m=i-mod1; m<i-mod1+3;m++){  //3x3 box
            for(int n=j-mod2; n<j-mod2+3;n++){
                if(puzzle[m][n] == k){
                    pos=false;
                    break;
                }
            }
        }

        return pos;
    }

    public static void print(){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                sb.append(puzzle[i][j]);
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }
}

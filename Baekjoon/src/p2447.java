import java.util.*;

public class p2447 {
    static char[][] paper;

    //공백 그리는 함수
    public static void blank(int n, int x, int y){
        for(int i = x; i < x+n; i++){
            for(int j=y; j<y+n; j++){
                paper[i][j] = ' ';
            }
        }
    }

    //별을 그리는 함수
    public static void draw(int n, int x, int y){
        if(n == 1) {
            paper[x][y]='*';
        }
        else{
            int size = n/3;
            int count = 0;
            for(int i=x;i<x+n; i+=size){
                for(int j=y; j<y+n; j+=size){
                    count++;
                    if(count ==5)
                        blank(size, i, j);
                    else draw(size, i, j);
                }
            }
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = input.nextInt();
        paper = new char[n+1][n+1];
        draw(n, 0,0);

        for(int i=0; i<n;i++){
            for(int j=0; j<n; j++){
                sb.append(paper[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}

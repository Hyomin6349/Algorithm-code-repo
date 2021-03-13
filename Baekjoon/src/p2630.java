import java.util.*;

public class p2630 {
    static int[][] paper;
    static int white=0;
    static int blue=0;

    public static void devide(int size, int x, int y){
        if(size == 1) {
            if(paper[x][y]==0) white++;
            else blue++;
            return;
        }
        //한 색으로 이루어진 네모
        int count = 0;
        for(int i=x; i<x+size;i++){
            for(int j=y; j<y+size;j++){
                if(paper[i][j] == 0) count++;
            }
        }
        if(count == size*size){
            white++;
            return;
        }
        if(count == 0){
            blue++;
            return;
        }
        devide(size/2, x, y);
        devide(size/2, x, y+size/2);
        devide(size/2, x+size/2, y);
        devide(size/2, x+size/2, y+size/2);
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = Integer.valueOf(input.nextLine());
        paper = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                paper[i][j] = input.nextInt();
            }
            input.nextLine();
        }
        devide(n, 0, 0);
        System.out.println(white);
        System.out.println(blue);
    }
}

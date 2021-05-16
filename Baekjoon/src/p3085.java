import java.util.*;
import java.io.*;

public class p3085 {
    static char[][] board;
    public static void swap(int i1, int j1, int i2, int j2){
        char temp = board[i1][j1];
        board[i1][j1] = board[i2][j2];
        board[i2][j2] = temp;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        board = new char[n][n];
        for(int i=0;i<n;i++){
            String line = br.readLine();
            board[i] = line.toCharArray();
        }
        int answer = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(j<n-1){
                    swap(i,j,i,j+1);
                    int can = calculate(board);
                    if(answer < can) answer = can;
                    swap(i,j,i,j+1);
                }
                if(i<n-1){
                    swap(i,j,i+1,j);
                    int can = calculate(board);
                    if(answer < can) answer = can;
                    swap(i,j,i+1,j);
                }
            }
        }
        System.out.println(answer);
    }

    public static int calculate(char[][] b){
        int max = 0;
        boolean[][] check = new boolean[b.length][b.length];
        for(int i=0;i<b.length;i++){
            int temp1 = 1, temp2=1;
            for(int j=0;j<b.length-1;j++){
                if(b[i][j] == b[i][j+1]) temp1++;
                else{
                    temp1 = 1;
                }

                if(max<temp1) max = temp1;
                if(b[j][i] == b[j+1][i]) temp2++;
                else{
                    temp2 = 1;
                }
                if(max<temp2) max = temp2;
            }
        }
        return max;
    }
}

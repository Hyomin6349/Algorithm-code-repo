import java.util.*;
import java.io.*;

public class p1780 {

    static int answer[] = new int[3];
    static int[][] map;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(st.nextToken())+1;
            }
        }

        devide(n,0,0);
        for(int i=0;i<3;i++) System.out.println(answer[i]);
    }

    public static void devide(int size, int row, int col){
        if(size==1){
            answer[map[row][col]]++;
            return;
        }

        int temp[] = new int[3];
        for(int i=row;i<row+size;i++){
            for(int j=col;j<col+size;j++){
                temp[map[i][j]]++;
            }
        }

        for(int i=0;i<3;i++){
            if(temp[i] == size*size){
                answer[i]++;
                return;
            }
        }

        devide(size/3, row, col);
        devide(size/3, row, col+size/3);
        devide(size/3, row, col+size/3*2);
        devide(size/3, row+size/3, col);
        devide(size/3, row+size/3, col+size/3);
        devide(size/3, row+size/3, col+size/3*2);
        devide(size/3, row+size/3*2, col);
        devide(size/3, row+size/3*2, col+size/3);
        devide(size/3, row+size/3*2, col+size/3*2);
    }
}

import java.util.*;

public class p1992 {
    static char[][] video;

    public static String zip(int size, int x, int y){
        //기저 사례
        if(size == 1) return String.valueOf(video[x][y]);
        //한 색으로 이루어진 네모
        int count = 0;
        for(int i=x; i<x+size;i++){
            for(int j=y; j<y+size;j++){
                if(video[i][j] == '0') count++;
            }
        }
        if(count == size*size || count ==0) return String.valueOf(video[x][y]);
        String upperLeft = zip(size/2, x, y);
        String upperRight = zip(size/2, x, y+size/2);
        String bottomLeft = zip(size/2, x+size/2, y);
        String bottomRight = zip(size/2, x+size/2, y+size/2);
        return "("+upperLeft+upperRight+bottomLeft+bottomRight+")";
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int n= Integer.valueOf(input.nextLine());
        video = new char[n][n];
        for(int i=0; i<n;i++){
            String line = input.nextLine();
            for(int j=0;j<n;j++){
                video[i][j] = line.charAt(j);
            }
        }
        System.out.println(zip(n,0,0));
    }
}

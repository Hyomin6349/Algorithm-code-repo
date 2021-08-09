import java.util.*;

public class p2571 {

    static boolean[][] map = new boolean[101][101];
    static int[][] pos;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        pos = new int[N][2];
        for(int i=0;i<N;i++){
            int X = sc.nextInt();
            int Y = sc.nextInt();
            pos[i][0] = X;
            pos[i][1] = Y;

            for(int x=X;x<X+10;x++){
                for(int y=Y;y<Y+10;y++){
                    map[x][y] = true;
                }
            }
        }

        int max = 100;
        for(int i=0;i<N;i++){
            int ret = Math.max (h(i), w(i));
            if (max < ret) max = ret;
        }

        System.out.println(max);
    }
    public static int h(int i){
        int x = pos[i][0], y = pos[i][1];
        int low = y, high = y;
        while(low>0 && map[x][low]) low--;
        while(high<=100 && map[x][high]) high++;
        int height = high - low - 1;
        int min = 0;

        loop:for(int j=x+1;j<=100;j++){
            for(int k=low+1; k<high; k++){
                if(!map[j][k]){
                    min = j;
                    break loop;
                }
            }
        }
        return height*(min-x);
    }

    public static int w(int i){
        int x = pos[i][0], y = pos[i][1];
        int low = x, high = x;
        while(low>0 && map[low][y]) low--;
        while(high<=100 && map[high][y]) high++;
        int weight = high - low - 1;

        int min = 0;
        loop:for(int j=y+1;j<=100;j++){
            for(int k=low+1; k<high; k++){
                if(!map[k][j]){
                    min = j;
                    break loop;
                }
            }
        }
        return weight*(min-y);
    }

}

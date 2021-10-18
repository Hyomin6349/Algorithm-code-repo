import java.util.*;

public class p17136 {
    static int min = 100;
    static int[][] map = new int[10][10];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        map = new int[10][10];
        for(int i=0;i<10;i++){
            for(int j=0;j<10;j++){
                map[i][j] = sc.nextInt();
            }
        }

        solve(0, new int[6]);
        System.out.println(min==100? -1:min);
    }

    public static void solve(int idx, int[] cnt){
        if(idx==100){
            int sum = 0;
            for(int i=1;i<6;i++) sum += cnt[i];
            if(min > sum) min = sum;
            return;
        }

        int r = idx/10;
        int c = idx%10;
        if(map[r][c]==0) solve(idx+1, cnt);
        else{
            for(int i=5; i>0;i--){
                if(isPossible(r, c, i) && cnt[i]+1 <= 5) {
                    make(r, c, i);
                    cnt[i]++;
                    solve(idx+1, cnt);

                    cnt[i]--;
                    back(r, c, i);
                }
            }
        }

    }

    public static boolean isPossible(int r, int c, int size){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if((r+i>=10 || c+j>=10) || map[r + i][c + j] == 0)
                    return false;
            }
        }
        return true;
    }

    public static void make(int r, int c, int size){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                map[r+i][c+j] = 0;
            }
        }
        map[r][c] = size;
    }

    public static void back(int r, int c, int size){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                map[r+i][c+j] = 1;
            }
        }
    }
}

import java.util.*;

public class p2775 {

    static int[][] room = new int[15][15];
    static boolean[][] memo = new boolean[15][15];

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int tc = input.nextInt();

        for(int i=1; i<=14; i++){
            room[0][i] = i;
            memo[0][i] = true;
        }

        while(tc-->0){
            int k = input.nextInt();
            int n = input.nextInt();
            if(memo[k][n]) System.out.println(room[k][n]);
            else System.out.println(find(k,n));
        }
    }

    public static int find(int k, int n){
        if(memo[k][n]) return room[k][n];

        int value = 0;
        for(int i=1; i<=n; i++){
            value += find(k-1, i);
        }

        room[k][n] = value;
        memo[k][n] = true;
        return room[k][n];
    }
}

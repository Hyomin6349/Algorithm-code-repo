import java.util.*;

public class p1520 {
    //이해잘안감 ㅠㅠ 어떻게 답나오는겨..
    static int M,N;
    static int[][] map, memo, d={{-1,1,0,0},{0,0,-1,1}};

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        M = input.nextInt();
        N = input.nextInt();
        map = new int[M][N];
        memo = new int[M][N];

        input.nextLine();
        for(int i=0;i<M;i++){
            for(int j=0;j<N;j++){
                map[i][j] = input.nextInt();
                memo[i][j] = -1;
            }
        }

        System.out.println(dfs(M-1,N-1));
    }

    public static int dfs(int col, int row){
        System.out.println(col+" "+row);
        if(col==0 && row==0) return 1;

        if(memo[col][row]==-1){
            memo[col][row] = 0;

            for(int i=0;i<4;i++){
                int dc = col + d[0][i];
                int dr = row + d[1][i];

                if(0<=dc && dc<M && 0<=dr && dr<N){
                    if(map[col][row] < map[dc][dr]) memo[col][row] += dfs(dc, dr);
                }
            }
        }

        return memo[col][row];
    }
}

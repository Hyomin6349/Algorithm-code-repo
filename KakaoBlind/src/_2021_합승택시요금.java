import java.util.*;

// 플로이드 와샬
public class _2021_합승택시요금 {

    public static void main(String[] args){
        int n = 6;
        int s = 4, a = 6, b = 2;
        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
        System.out.println(solution(n, s, a, b, fares));
    }

    public static int solution(int n, int s, int a, int b, int[][] fares) {
        int INF = 10000001;
        int memo[][] = new int[n+1][n+1];
        for(int i=1;i<=n;i++) Arrays.fill(memo[i],INF);
        for(int i=1;i<=n;i++){
            memo[i][i] = 0;
        }
        for(int[] fare: fares){
            memo[fare[0]][fare[1]] = fare[2];
            memo[fare[1]][fare[0]] = fare[2];
        }



        for(int k=1; k<=n;k++){
            for(int i=1;i<n;i++){
                for(int j=i+1;j<=n;j++){
                    memo[i][j] = Math.min(memo[i][j], memo[i][k]+memo[k][j]);
                    memo[j][i] = memo[i][j];
                }
            }
        }

        int answer = INF;

        for(int i=1;i<=n;i++){
            answer = Math.min(answer, memo[s][i]+memo[i][a]+memo[i][b]);
        }

        return answer;
    }
}

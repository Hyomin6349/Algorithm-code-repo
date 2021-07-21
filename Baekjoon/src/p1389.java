import java.util.*;

public class p1389 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int M = input.nextInt();

        int[][] map = new int[N+1][N+1];
        for(int i=1;i<=N;i++) Arrays.fill(map[i], 1000);
        while(M-->0){
            int a = input.nextInt();
            int b = input.nextInt();
            map[a][b] = map[b][a] = 1;
        }

        for(int k=1;k<=N;k++){
            for(int i=1;i<=N;i++){
                for(int j=1;j<=N;j++){
                    int temp = map[i][k] + map[k][j];
                    if(temp < map[i][j]){
                        map[i][j] = map[j][i] = temp;
                    }
                }
            }
        }

        int answer = 0;
        int min = 1000;
        for(int i=1;i<=N;i++){
            int local = 0;
            for(int j=1;j<=N;j++){
                if(i==j) continue;
                local += map[i][j];
            }
            if(min > local){
                min = local;
                answer = i;
            }
        }

        System.out.println(answer);
    }
}

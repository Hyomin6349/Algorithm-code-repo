import java.util.*;

public class p1976 {

    static int N,M;
    static int[][] map;

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        N = Integer.parseInt(input.nextLine());
        M = Integer.parseInt(input.nextLine());
        map = new int[N][N];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(input.nextLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(i==j) map[i][j] = 1;
            }
        }

        int[] path = new int[M];
        for(int i=0;i<M;i++) path[i] = input.nextInt()-1;

        for(int k=0;k<N;k++){   //거쳐가는 노드
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(map[i][k] == 1 && map[k][j] == 1){
                        map[i][j] = 1;
                    }
                }
            }
        }

        String answer = "YES";

        for(int i=0;i<M-1;i++){
             int start = path[i];
             int finish = path[i+1];
             if(map[start][finish]==0){
                answer = "NO";
                break;
            }
        }

        System.out.println(answer);

    }

}

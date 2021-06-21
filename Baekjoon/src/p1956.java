import java.util.*;

public class p1956 {

    static int INF = 987654321;
    static int answer = INF;

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int V = input.nextInt();
        int E = input.nextInt();
        input.nextLine();
        int[][] arr = new int[V + 1][V + 1];

        //초기화
       for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i != j) {
                    arr[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < E; i++) {
            StringTokenizer st = new StringTokenizer(input.nextLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[a][b] = c;
        }

        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    if (i == j) {
                        continue;
                    }
                    if (arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        for (int i = 1; i <= V; i++) {
            for (int j = 1; j <= V; j++) {
                if (i == j) {
                    continue;
                }

                // 자기 자신을 제외한 두 정점이
                // 서로에게 가는 경로가 있다면, 사이클이 존재한다는 뜻.
                if (arr[i][j] != INF && arr[j][i] != INF) {
                    answer = Math.min(answer, arr[i][j] + arr[j][i]);
                }
            }
        }

        if(answer == INF) System.out.println(-1);
        else System.out.print(answer);
    }

}

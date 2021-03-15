import java.util.*;

public class p1916 {
    public static int cost(int n, int m, int[][] weight, int start, int finish){
        int[] dis= new int[n+1]; //출발 정류장에서 각 정류장까지의 최소 비용을 담은 배열
        boolean[] include = new boolean[n+1]; //스패닝 트리에 포함된 정류장인지 판별
        //초기화
        int select = start;
        for(int i=1; i<=n; i++) {
            dis[i] = 100000;
            include[i] = false;
        }
        dis[start] = 0;
        include[start] = true;

        int k =0;

        while(true){
            if(select == finish) break;
            //새로 선택된 도시에 대해 dis 배열 업데이트
            //(수정) 모든 버스에 대한 반복문에서 도시에 대한 반복문으로 변경
            //버스의 출발지가 select일때 update => select에 대한 모든 city에 대해 update
            for(int i=1; i<=n;i++){
               if(!include[i] && dis[select]+weight[select][i] < dis[i]){
                   dis[i] = dis[select]+weight[select][i];
               }
            }
            //dis 배열에서 추가할 도시 선택, 이미 선택된 도시는 포함할 수 없음
            int min = 100000;
            for(int i=1; i<=n; i++){
                if(!include[i] && dis[i] < min){
                    min = dis[i];
                    select = i;
                }
            }
            include[select] = true;
        }
        return dis[finish];
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = Integer.valueOf(input.nextLine());
        int m = Integer.valueOf(input.nextLine());
        int[][] weight = new int[n+1][n+1]; //(수정) 메모리 초과로 Edge 배열에서 이차원 배열로 변경
        boolean[][] check = new boolean[n+1][n+1]; //(수정) 같은 노선 버스 체크

        //초기화
        for(int i=1; i<=n;i++){
            for(int j=1; j<=n; j++){
                weight[i][j] = 100000;
                check[i][j] = false;
            }
        }

        for(int i=0; i<m; i++){
            int s = input.nextInt();
            int e = input.nextInt();
            int v = input.nextInt();
            if(!check[s][e]){
                check[s][e] = true;
                weight[s][e] = v;
            }
            else{
                weight[s][e] = v < weight[s][e] ? v:weight[s][e];
            }
            input.nextLine();
        }

        int start = input.nextInt();
        int finish = input.nextInt();

        System.out.println(cost(n, m, weight,start, finish));
    }
}

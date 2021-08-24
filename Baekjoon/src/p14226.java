import java.util.*;

public class p14226 {
    static int S;

    public static  void main(String[] args){
        Scanner sc = new Scanner(System.in);
        S  = sc.nextInt();
        int INF = 987654321;

        int[][] memo = new int[1001][1001];
        for(int i=1;i<=1000;i++){
            for(int j=0;j<=1000;j++) memo[i][j] = INF;
        }

        memo[1][0] = 0;
        memo[1][1] = 1;

        for(int i=2; i<=1000;i++){ //i: i개의 이모티콘을 작성할 최소 수
            int min = INF;
            int copy = -1;
            for(int j=1; j<i;j++){ //j: 화면에 작성된 이모티콘 수
                for(int k=0;k<j;k++){ //k: 클립보드에 저장된 이모티쿈 수
                    if(j+k==i && memo[i][k]>memo[j][k]+1){
                        memo[i][k] = memo[j][k]+1; //붙여넣기 한번
                    }
                    if(j+j==i && memo[i][j]>memo[j][k]+2){
                        memo[i][j] = memo[j][k]+2; //j 복사 붙여넣기
                    }
                    if(min>memo[i][k]){
                        min = memo[i][k]; //i개의 이모티콘을 만드는 경우의 수 중 최소 수
                        copy = k;
                    }
                }
            }
            memo[i][i] = min+1;
            if(copy!=-1 && memo[i-1][copy] > min) memo[i-1][copy] = min;
        }

//        int min = INF;
//        for(int i=0;i<=1000;i++){
//            if(min>memo[S][i]) min = memo[S][i];
//        }
//        System.out.println(min);

        for(int i=1;i<=20;i++){
            for(int j=0; j<i; j++){
                System.out.print(memo[i][j]+" ");
            }
            System.out.println();
        }
    }

}


public class dynamic3 {
    static int solution(int m, int n, int[][] puddles) {

        int[][] map=new int[m][n];

        for(int i=1;i<m;i++) map[i][0]=1;
        for(int j=1;j<n;j++) map[0][j]=1;

        //물에 잠긴 곳은 -1
        for(int k=0;k<puddles.length;k++) {
            int i=puddles[k][0]-1;
            int j=puddles[k][1]-1;
            map[i][j]=-1;
            if(i==0) {
                for(int x=j;x<n;x++) map[0][x]=0;
            }
            if(j==0) {
                for(int x=i;x<m;x++) map[x][0]=0;
            }
        }

        for(int i=1;i<m;i++) {
            for(int j=1;j<n;j++) {
                if(map[i][j]==-1) {
                    map[i][j]=0;
                    continue;
                }
                map[i][j]=map[i-1][j]+map[i][j-1]%1000000007;
            }
        }

        return map[m-1][n-1];
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int m=4;
        int n=3;
        int[][] puddles= {{2,2},{3,1}};
        System.out.println(solution(m,n,puddles));
    }

}
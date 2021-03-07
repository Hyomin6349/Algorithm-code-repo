import java.util.*;
class epper15_09 {
    //solution 함수를 완성하세요.
    public static int solution(int[] n,int[][] r,int goal){
        int answer=0;
        int time[] = new int[n.length];
        time[0] = n[0];

        for(int i=1;i<n.length;i++){
            if(i==goal) break;
            int max = n[i];
            for(int j=0; j<r.length; j++){
                if(r[j][1]-1 == i){
                    int k = r[j][0]-1;
                    max = max < n[i]+time[k] ? n[i]+time[k] : max;
                }
            }
            time[i] = max;
        }

        answer = time[goal-1];

        return answer;

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        int R=sc.nextInt();
        int[] n = new int[N];
        int [][] r=  new int[R][R];

        for(int i=0;i<N;i++) {
            n[i]=sc.nextInt();
        }
        for(int k=0;k<R;k++) {
            for(int j=0;j<2;j++) {
                r[k][j]=sc.nextInt();
            }
        }

        int goal=sc.nextInt();
        int k=solution(n,r,goal);
        System.out.println(k);

    }
}
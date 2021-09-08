import java.util.*;

public class _2019_실패율 {

    public static void main(String[] args) {
        int n = 5;
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        int[] answer = solution(n, stages);
        for(int i:answer){
            System.out.println(i);
        }
    }

    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] map = new int[N+2];   //성공한 사람 수
        int[] failStage = new int[N+2]; //도달했지만 클리어하지 못한 사람 수
        Rate[] failRate = new Rate[N+1];

        for(int i: stages){
            for(int j=1; j<=i; j++) map[j]++;
            failStage[i]++;
        }

        failRate[0] = new Rate(-1, 0);
        for(int i=1;i<=N;i++){
            if(map[i]==0) failRate[i] = new Rate(0, i);
            else failRate[i] = new Rate((double) failStage[i] / (double)map[i], i);
        }

        Arrays.sort(failRate);
        for(int i=0;i<N;i++){
            answer[i] = failRate[i].idx;
        }

        return answer;
    }

    public static class Rate implements Comparable<Rate>{
        double failRate;
        int idx;
        public Rate(double f, int i){
            failRate = f;
            idx = i;
        }
        public int compareTo(Rate o){
            if(o.failRate-failRate<0) return -1;
            else if(o.failRate==failRate) return idx - o.idx;
            else return 1;
        }
    }
}

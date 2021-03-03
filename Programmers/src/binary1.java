import java.util.*;

public class binary1 {
    static long solution(int n, int[] times) {
        long answer = 0;

        Arrays.sort(times);
        long left=0;
        long right=(long)times[times.length-1]*n;

        while(left <= right) {
            long mid=(left+right)/2;
            long count=0; //x시간동안 입국 가능한 사람 수
            for(int i=0;i<times.length;i++) {
                count += (long)mid/times[i];
            }
            if(count>=n) {
                right=mid-1;
                answer=mid;
            }
            else {
                left=mid+1;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n=6;
        int[] times= {7,10};
        System.out.println(solution(n,times));
    }

}

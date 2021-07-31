import java.util.*;

public class p1052 {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int K = input.nextInt();
        int[] bottle = new int[33];
        bottle[0] = N;

        if(N<=K){
            System.out.println(0);
            System.exit(0);
        }

        int cnt = N;
        int answer = 0;

        loop: while(true){
            for(int i=0;i<32;i++){
                bottle[i+1] += bottle[i]/2;
                cnt -= bottle[i]/2;
                bottle[i] %= 2;
                if(cnt<=K) break loop;
            }
            answer++;
            bottle[0]++;
            cnt++;
        }

        System.out.println(answer);
    }
}

import java.util.*;

public class p14501 {

    static int N, answer = 0;
    static int[] T,P;

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        N = Integer.parseInt(input.nextLine());
        T = new int[N+1];
        P = new int[N+1];

        for(int i=1;i<=N;i++){
            StringTokenizer st = new StringTokenizer(input.nextLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        find(1, 0);
        System.out.println(answer);

    }

    public static void find(int day, int sum){
        if(day==N+1){
            if(answer < sum) answer = sum;
            return;
        }
        if(day>N+1) return;

        find(day+1, sum);
        find(day+T[day], sum+P[day]);
    }
}

import java.util.*;

public class p1182 {
    static int N,S,answer=0;
    static int[] arr;
    static Set<Integer> list = new HashSet<>();

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        S = input.nextInt();
        arr = new int[N];

        for(int i=0;i<N;i++) arr[i] = input.nextInt();

        dfs(0,0);
        if(S==0)System.out.println(--answer);
        else System.out.println(answer);
    }

    public static void dfs(int idx, int sum){
        if(idx==N){
            if(sum==S){
                answer ++;
            }
            return;
        }

        dfs(idx+1, sum);
        dfs(idx+1, sum+arr[idx]);

    }
}

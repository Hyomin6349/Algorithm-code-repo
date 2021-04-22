import java.util.*;

public class p9663 {

    static int N, ans=0;
    static int[] select;

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        select = new int[N];
        put(0);
        System.out.println(ans);

    }

    public static void put(int row){
        if(row == N){
            ans++;
            return;
        }

        for(int i=0; i<N;i++){
            select[row] = i;
            if(isPossible(row)){
                put(row+1);
            }
        }

    }

    public static boolean isPossible(int cur){
        boolean possible = true;

        for(int i=0;i<cur;i++){
            if(select[i] == select[cur] || Math.abs(select[i]-select[cur])==Math.abs(i-cur))
                possible=false;
        }

        return possible;
    }
}

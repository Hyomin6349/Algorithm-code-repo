import java.util.*;

public class p15649 {

    static int[] selected;
    static boolean[] visit;
    static int N,M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        N = input.nextInt();
        M = input.nextInt();
        visit = new boolean[N+1];
        selected = new int[M];

        perm(0);
        System.out.println(sb);
    }

    public static void perm(int select){
        if(select == M){
            for(int i=0;i<M;i++){
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for(int i = 1;i<=N;i++){
            if(!visit[i]){
                visit[i] = true;
                selected[select] = i;
                perm(select+1);
                visit[i] = false;
            }
        }
    }
}

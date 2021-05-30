import java.util.*;

public class p15651 {

    static int[] selected;
    static int N,M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        N = input.nextInt();
        M = input.nextInt();
        selected = new int[M];

        perm(0);
        System.out.println(sb);
    }

    public static void perm(int select){
        if(select == M){
            for(int val : selected){
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }
        for(int i=1; i<=N; i++){
            selected[select] = i;
            perm(select+1);
        }
    }
}

import java.util.*;

public class p15650 {

    static int[] selected;
    static int N,M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        N = input.nextInt();
        M = input.nextInt();
        selected = new int[M];

        perm(1,0);
        System.out.println(sb);
    }

    public static void perm(int start ,int select){
        if(select == M){
            for(int val : selected){
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }
        for(int i=start; i<=N; i++){
            selected[select] = i;
            perm(i+1, select+1);
        }
    }
}

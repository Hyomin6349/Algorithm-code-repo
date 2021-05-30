import java.util.*;

public class p15654 {

    static boolean[] visit;
    static int[] selected, arr;
    static int N,M;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        N = input.nextInt();
        M = input.nextInt();
        input.nextLine();
        selected = new int[M];
        visit = new boolean[N+1];
        arr = new int[N+1];
        StringTokenizer st = new StringTokenizer(input.nextLine());
        int idx = 1;
        while(st.hasMoreTokens()) arr[idx++] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

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
            if(!visit[i]){
                visit[i] = true;
                selected[select] = arr[i];
                perm( select+1);
                visit[i] = false;
            }
        }
    }
}

import java.util.*;

public class sm4 {
    public static int get(int idx){
        int answer = 1;
        for(int i=0; i<step.length;i++) visit[i] = false;
        int cur = idx;
        while(!visit[cur]){
            visit[cur] = true;
            answer++;
            cur += step[cur];
        }
        return answer;
    }

    public static int max(int a, int b){
        if(a>b) return a;
        return b;
    }

    static int step[];
    static boolean visit[];

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int n = Integer.parseInt(input.nextLine());
        step = new int[n];
        visit = new boolean[n];

        for(int i=0;i<n;i++) step[i] = input.nextInt();
        int first = get(0);
        int second = get(1);
        int third = get(2);

        System.out.println(max(first, max(second, third)));
    }
}

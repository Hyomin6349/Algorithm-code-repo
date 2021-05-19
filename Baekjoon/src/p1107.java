import java.util.*;

public class p1107 {
    static boolean[] broken;
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int goal = Integer.parseInt(input.nextLine());
        int n = Integer.parseInt(input.nextLine());
        broken = new boolean[10];

        for(int i=0;i<n;i++){
            broken[input.nextInt()] = true;
        }

        int answer = Math.abs(goal-100);

        for(int i=0;i<=1000000;i++){
            int len = possible(i);
            if(len > 0){
                int count = len + Math.abs(i-goal);
                if(answer > count) answer = count;
            }
        }

        System.out.println(answer);
    }

    public static int possible(int c){
        int len = 0;
        if(c==0){
            if(broken[0]) return 0;
            else return 1;
        }
        while(c>0){
            if(broken[c%10]) return 0;
            len += 1;
            c/=10;
        }
        return len;
    }
}

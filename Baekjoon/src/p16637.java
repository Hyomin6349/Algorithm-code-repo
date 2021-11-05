import java.util.*;

public class p16637 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        str = sc.nextLine().toCharArray();
        op = N/2;

        choice(0, str[0]-'0');
        System.out.println(ans);
    }

    static int N, op;
    static char[] str;
    static int ans = Integer.MIN_VALUE;

    public static void choice(int idx, int val){
//        System.out.println(idx+" "+val);
        boolean leftOne = false;
        if(idx>=N-1){
            if(val > ans) ans = val;
            return;
        }
        if(idx>=N-3) leftOne = true;

        //선택안한경우
        int res1 = calc(val, str[idx+2]-'0', str[idx+1]);
        choice(idx+2, res1);
        //선택한 경우
        if(!leftOne){
            int temp = calc(str[idx+2]-'0', str[idx+4]-'0', str[idx+3]);
            int res2 = calc(val, temp, str[idx+1]);
            choice(idx+2*2, res2);
        }
    }

    public static int calc(int n1, int n2, char op){
        switch(op){
            case '+':
                return n1+n2;
            case '-':
                return n1-n2;
            case '*':
                return n1*n2;
            default: return 0;
        }
    }
}

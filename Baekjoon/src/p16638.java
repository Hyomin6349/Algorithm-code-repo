import java.util.*;

public class p16638 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        exp = sc.nextLine().toCharArray();
        op = N/2;

        if(N==1) System.out.println(exp[0]);
        else{
            solve(0, "");
            System.out.println(ans);
        }
    }

    static int N, op, ans = Integer.MIN_VALUE;
    static char[] exp;

    public static void solve(int n, String str){
        if(n>=op){
            char c = str.charAt(str.length()-1);
            if(c!=')') str += exp[N-1];

            int val = calc(str.toCharArray());
            if(ans < val) ans = val;

            return;
        }


        //선택 안한 경우
        StringBuilder tmp1 = new StringBuilder(str);
        tmp1.append(exp[2*n]).append(exp[2*n+1]);
        solve(n+1, tmp1.toString());

        //선택한 경우
        StringBuilder tmp2 = new StringBuilder(str);
        tmp2.append('(');
        tmp2.append(exp[2*n]).append(exp[2*n+1]).append(exp[2*n+2]);
        tmp2.append(')');
        if(n+1<op) tmp2.append(exp[2*n+3]);
        solve(n+2, tmp2.toString());
    }

    public static int calc(char[] str){
        Stack<Character> op = new Stack<>();
        Stack<Integer> num = new Stack<>();

        loop : for(int i=0;i<str.length;i++){

            if('0'<= str[i] && str[i]<='9'){
                num.push(str[i]-'0');
            }
            else {
                if(str[i]=='(') op.push(str[i]);
                else if(str[i]==')'){
                    while(op.peek()!='('){
                        int n1 = num.pop();
                        int n2 = num.pop();
                        num.push(calc(n2, n1, op.pop()));
                    }
                    op.pop();
                } else {
                    boolean in = false;

                    while (!in) {
                        if(op.size()==0){
                            op.push(str[i]);
                            continue loop;
                        }
                        char c = op.peek();
                        if (c == '(' || (c != '*' && str[i] == '*')){
                            op.push(str[i]);
                            in = true;
                        }
                        else {
                            int n1 = num.pop();
                            int n2 = num.pop();
                            num.push(calc(n2, n1, op.pop()));
                        }
                    }
                }
            }
        }

        while(op.size()>0){
            int n1 = num.pop();
            int n2 = num.pop();
            num.push(calc(n2, n1, op.pop()));
        }

        return num.pop();
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

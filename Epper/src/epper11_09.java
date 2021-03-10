import java.util.*;
class epper11_09 {
    static int n;
    static int answer =0;
    public static void solution(int open, int close){
        if(open < close || open >n || close>n) return;
        else if(open==close && open==n) answer++;
        else{
            solution(open+1, close);
            solution(open, close+1);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        solution(0,0);
        System.out.println(answer);
    }
}
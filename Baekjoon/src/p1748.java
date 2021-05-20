import java.util.*;
public class p1748 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        long answer = 0;
        int mul = 1;

        while(n>=Math.pow(10,mul)){
            answer += 9*Math.pow(10, mul-1)*mul;
            mul++;
        }
        answer += (n-Math.pow(10, mul-1)+1) * mul;


        System.out.println(answer);
    }
}

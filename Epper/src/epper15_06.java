import java.io.*;
import java.util.*;


public class epper15_06 {
    public static int solution(int m, String input) {
        int answer = 0;

        Stack<Integer> stack = new Stack<Integer>();

        for(int i=0 ; i<input.length() ; i++){
            if(input.charAt(i)==' '){
                continue;
            }
            else if(input.charAt(i) == '+'){
                int a = stack.pop();
                int b =  stack.pop();
                int result = a+b;
                stack.push(result);
            }
            else if(input.charAt(i) == '-'){
                int a =  stack.pop();
                int b =  stack.pop();
                int result = b-a;
                stack.push(result);
            }
            else if(input.charAt(i) == '*'){
                int a = stack.pop();
                int b = stack.pop();
                int result = a*b;
                stack.push(result);
            }
            else if(input.charAt(i) == '/'){
                int a =  stack.pop();
                int b =  stack.pop();
                int result = b/a;
                stack.push(result);
            }
            else{
                int x = input.charAt(i) - '0';

                stack.push(x);
            }
        }

        answer = stack.pop();

        return answer;
    }

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        String s = input.nextLine();
        int m = Integer.parseInt(s);
        String str = input.nextLine();
        int result;

        result=solution(m, str);
        System.out.println(result);


    }
}
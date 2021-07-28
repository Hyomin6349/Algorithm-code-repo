import java.util.*;

public class p4889 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int tc = 0;
        String str = "";

        next : while(!(str=input.nextLine()).matches("[-]+")){
            tc++;
            Stack<Character> stack = new Stack<>();
            int open=0, close=0;
            char[] chars = str.toCharArray();

            for(int i=0;i<chars.length;i++){
                if(chars[i] == '{'){
                    stack.push('{');
                    open++;
                }
                else {
                    if(stack.size()>0 && stack.peek()=='{'){
                        stack.pop();
                        open--;
                    }
                    else{
                        stack.push('}');
                        close++;
                    }
                }
            }
            sb.append(tc+". ").append((open/2+open%2) + (close/2+close%2)).append("\n");
        }

        System.out.println(sb);
    }
}

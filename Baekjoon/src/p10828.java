import java.util.*;

public class p10828{
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int stack[] = new int[10000];
        int top = 0;

        int n = input.nextInt();

        for(int i=0;i<n;i++){
            String command = input.next();
            if(command.equals("push")){
                int val = input.nextInt();
                stack[top++]=val;
            }
            else if(command.equals("pop")){
                if(top==0) sb.append(-1).append('\n');
                else {
                    int val = stack[--top];
                    sb.append(val).append('\n');
                }
            }
            else if(command.equals("size")){
                sb.append(top).append('\n');
            }
            else if(command.equals("empty")){
                if(top==0) sb.append(1).append('\n');
                else sb.append(0).append('\n');;
            }
            else if(command.equals("top")){
                if(top==0) sb.append(-1).append('\n');
                else sb.append(stack[top-1]).append('\n');
            }
        }

        System.out.println(sb);
    }
}

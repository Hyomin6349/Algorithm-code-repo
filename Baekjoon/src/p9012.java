import java.util.*;

public class p9012 {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = Integer.valueOf(input.nextLine());
        for(int i=0;i<n;i++){
            int top=0;
            String vps = input.nextLine();
            for(int j=0;j<vps.length();j++){
                if(vps.charAt(j)=='(') top++;
                else top--;
                if(top<0){
                    sb.append("NO").append('\n');
                    break;
                }
            }
            if(top == 0) sb.append("YES").append('\n');
            else if(top>0)sb.append("NO").append('\n');
        }
        System.out.println(sb);
    }
}

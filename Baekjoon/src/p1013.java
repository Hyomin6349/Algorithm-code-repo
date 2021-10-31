import java.util.regex.*;
import java.io.*;

public class p1013 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        String pattern = "(100+1+|01)+";
        StringBuilder sb = new StringBuilder();

        while(T-->0){
            String str = br.readLine();
            if(str.matches(pattern)) sb.append("YES").append('\n');
            else sb.append("NO").append('\n');
        }

        System.out.print(sb.toString());
    }
}

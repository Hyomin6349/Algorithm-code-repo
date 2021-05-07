import java.util.*;

public class p2661 {

    static int n;
    static boolean stop = false;

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        n = input.nextInt();

        dfs(1, "1");

    }

    public static void dfs(int count, String s){
        if(stop) return;
        if(count == n){
            stop=true;
            System.out.println(s);
            return;
        }

        for(int i=1;i<=3;i++){
            if(satisfy(s+i)){
                dfs(count+1, s+i);
            }
        }
    }

    public static boolean satisfy(String s){
        int len = s.length();
        int loop = len/2;
        int start = len-1;
        int end = len;

        for(int i=1;i<=loop;i++){
            if(s.substring(start-i, end-i).equals(s.substring(start, end))){
                return false;
            }
            start -= 1;
        }
        return true;
    }
}

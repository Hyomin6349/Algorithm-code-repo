
import java.util.*;

public class day210704  {
    public static int solution(String s, String t) {
        int result = 0;
        int idx = s.indexOf(t);

        while(idx!=-1){
            System.out.println(s);
            result++;
            String temp = "";
            for(int i=0;i<idx;i++){
                temp += s.charAt(i);
            }
            for(int i=idx+t.length();i<s.length();i++){
                temp += s.charAt(i);
            }

            s = temp;
            idx = s.indexOf(t);
        }

        return result;
    }

    public static void main(String[] args){
        String s = "aaaaabbbbb";
        String t = "ab";
        System.out.println(solution(s,t));
    }
}
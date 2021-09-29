import java.util.*;

public class p1701 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        int answer = 0;
        for(int i=0; i<str.length(); i++){
            String sub = str.substring(i);
            int max = 0;
            int pi[] = new int[sub.length()]; //부분 문자열

            for(int j=1, k=0; j<sub.length();j++){ //j: 접미사 인덱스, k:접두사 인덱스
                while(k>0 && sub.charAt(j) != sub.charAt(k)) k = pi[k-1];
                if(sub.charAt(j) == sub.charAt(k)) max = Math.max(max, pi[j] = ++k);
            }

            answer = Math.max(answer, max);
        }

        System.out.println(answer);
    }
}

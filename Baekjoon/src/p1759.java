import java.util.*;

public class p1759 {

    static int L, C;
    static char[] letters;
    static boolean[] visit;

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        L = input.nextInt();
        C = input.nextInt();
        letters = new char[C];
        visit = new boolean[C];

        input.nextLine();
        StringTokenizer st = new StringTokenizer(input.nextLine());
        int i=0;
        while(st.hasMoreTokens()) letters[i++] = st.nextToken().charAt(0);

        Arrays.sort(letters);

        select(0,0);
    }


    public static void select(int start, int r){
        if(r == L){
            String answer = "";
            for(int i=0; i<C; i++){
                if(visit[i]) answer += letters[i];
            }
            if(check(answer)) System.out.println(answer);
            return;
        }

        for(int i=start;i<C;i++){
            visit[i] = true;    //i를 포함한 경우 먼저 살피기
            select(i+1, r+1);
            visit[i] = false;
        }
    }

    public static boolean check(String word){
        String vowel = "aeiou";
        int c1 =0, c2=0;
        for(int i=0;i<word.length();i++){
            if(vowel.contains(String.valueOf(word.charAt(i)))) c1++;
            else c2 ++;
        }
        if(c1>0 && c2 >1) return true;
        else return false;
    }
}

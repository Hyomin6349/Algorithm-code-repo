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

    static Stack<Character> stack = new Stack<>();

    public static void select(int start, int count){
        if(count == L){
            String answer = "";
            for(char c:stack) answer += c;
            System.out.println(answer);
            return;
        }

        for(int i=start;i<C;i++){
            stack.push(letters[i]);
            select(start+1, count+1);
            stack.pop();
        }
    }
}

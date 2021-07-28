import java.util.*;

public class p1920 {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        StringTokenizer st;
        int N = Integer.parseInt(input.nextLine());
        Set<String> set = new HashSet<>();

        for(String s : input.nextLine().split(" ")){
            set.add(s);
        }

        int M = Integer.parseInt(input.nextLine());
        st = new StringTokenizer(input.nextLine());
        StringBuilder sb = new StringBuilder();

        while(st.hasMoreTokens()){
            if(set.contains(st.nextToken())) sb.append(1).append('\n');
            else sb.append(0).append('\n');
        }

        System.out.println(sb);
    }
}

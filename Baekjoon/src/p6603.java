import java.util.*;

public class p6603 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while(true){
            String input = in.nextLine();
            if(input.length() == 1) break;
            StringTokenizer st = new StringTokenizer(input);
            int k = Integer.parseInt(st.nextToken());
            int[] arr = new int[k];
            boolean[] visit = new boolean[k];
            for(int i=0; i<k; i++) arr[i] = Integer.parseInt(st.nextToken());

            combination(arr, visit, 0, 0);
            sb.append('\n');
        }

        System.out.println(sb);
    }

    public static void combination(int[] arr, boolean[] visit, int start, int r){
        if(r == 6){
            for(int i=0; i<arr.length;i++){
                if(visit[i]) sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
        }

        for(int i=start; i<arr.length; i++){
            visit[i] = true;
            combination(arr, visit, i+1, r+1);
            visit[i] = false;
        }
    }
}

import java.util.*;
import java.io.*;

public class p1516 {

    static int N;
    static int[] arr, memo;
    static ArrayList<Integer>[] list;

    public static void main(String[] args)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        list = new ArrayList[N+1];
        arr = new int[N+1];
        memo = new int[N+1];

        for(int i=1;i<=N;i++) {
            list[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()) list[i].add(Integer.parseInt(st.nextToken()));
            if(list[i].size()==1) memo[i] = arr[i];
        }

        for(int i=1;i<=N;i++) sb.append(getTime(i)).append('\n');
        System.out.println(sb);
    }

    public static int getTime(int idx) {
        if(memo[idx]!=0) return memo[idx];

        int max = 0;
        for(int i=0; i<list[idx].size()-1;i++) {
            int time = getTime(list[idx].get(i));
            if(max < time) max = time;
        }
        memo[idx] = max + arr[idx];
        return memo[idx];
    }
}

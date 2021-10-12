import java.util.*;
import java.io.*;

public class p14425 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Set<Integer> set = new HashSet<>();

        for(int i=0;i<N;i++){
            String word = br.readLine();
            int hc = word.hashCode();
            set.add(hc);
        }

        int cnt = 0;
        for(int i=0;i<M;i++){
            String word = br.readLine();
            int hc = word.hashCode();
            if(set.contains(hc)) cnt++;
        }

        System.out.println(cnt);
    }
}

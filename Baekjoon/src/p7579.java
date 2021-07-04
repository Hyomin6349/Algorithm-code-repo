import java.util.*;
import java.io.*;

public class p7579 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] dp = new int[10001]; //최대 cost 값
        int[] memory = new int[N], cost = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) memory[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) cost[i] = Integer.parseInt(st.nextToken());

        Set<Integer> exist = new HashSet<>(); //최대 memory값 초기화 되어있는 cost 값 집합

        for(int i=0;i<N;i++){
            Integer[] tmpSet = exist.stream().toArray(Integer[]::new); //integer set => integer array
            int[] tmpDp = dp.clone(); // 거꾸로 dp update 해도 됨

            if(memory[i] > dp[cost[i]]){
                dp[cost[i]] = memory[i];
                exist.add(cost[i]);
            }

            for(int val : tmpSet){
                if(tmpDp[val] + memory[i] > dp[cost[i]+val]){
                    dp[cost[i]+val] = tmpDp[val] + memory[i];
                    exist.add(cost[i]+val);
                }
            }
        }

        for(int i=0;i<=10000;i++){
            if(dp[i]>=M) {
                System.out.println(i);
                break;
            }
        }
    }
}

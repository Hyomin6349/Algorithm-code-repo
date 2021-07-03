import java.util.*;
import java.io.*;

public class p2096 {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] maxDP = new int[3];
        int[] minDP = new int[3];
        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            if(i==0){
                maxDP[0] = Integer.parseInt(st.nextToken());
                maxDP[1] = Integer.parseInt(st.nextToken());
                maxDP[2] = Integer.parseInt(st.nextToken());

                minDP[0] = maxDP[0];
                minDP[1] = maxDP[1];
                minDP[2] = maxDP[2];
            }
            else{
                int x0 = Integer.parseInt(st.nextToken());
                int x1 = Integer.parseInt(st.nextToken());
                int x2 = Integer.parseInt(st.nextToken());

                int temp0 = maxDP[0], temp2 = maxDP[2];
                maxDP[0] = Math.max(maxDP[0], maxDP[1]) + x0;
                maxDP[2] = Math.max(maxDP[1], maxDP[2]) + x2;
                maxDP[1] = Math.max(temp0, Math.max(maxDP[1], temp2)) + x1;

                temp0 = minDP[0]; temp2 = minDP[2];
                minDP[0] = Math.min(minDP[0], minDP[1]) + x0;
                minDP[2] = Math.min(minDP[1], minDP[2]) + x2;
                minDP[1] = Math.min(temp0, Math.min(minDP[1], temp2)) + x1;
            }
        }
        int max = Math.max(maxDP[0], Math.max(maxDP[1], maxDP[2]));
        int min =  Math.min(minDP[0], Math.min(minDP[1], minDP[2]));
        System.out.println(max+" "+min);
    }
}

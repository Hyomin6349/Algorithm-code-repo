import java.util.*;
import java.io.*;

public class p1806 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int[] arr = new int[n];
        int[] sum = new int[n];
        int[] num = new int[n];

        int ini_sum = 0;
        int ini_num = 0;
        boolean ini = false;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
            ini_sum += arr[i];
            ini_num++;
            if(!ini && ini_sum >= s){
                ini = true;
                sum[0] = ini_sum;
                num[0] = ini_num;
            }
        }

        if(!ini){
            System.out.println(0);
            return;
        }

        int answer = n;
        for(int i=1;i<n;i++){
            sum[i] = sum[i-1] - arr[i-1];
            num[i] = num[i-1] - 1;

            while(sum[i] < s){
                if(i+num[i] >= n){
                    System.out.println(answer);
                    return;
                }
                sum[i] += arr[i+num[i]++];

            }
            if(answer > num[i]) answer = num[i];
        }
        System.out.println(answer);
    }
}

import java.util.*;
import java.io.*;

public class p2230 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }


        if(M==0 || N==1){
            System.out.println(0);
        } else {
            Arrays.sort(arr);
            int answer = Integer.MAX_VALUE;
            int left = 0, right = 1;
            while (left <= right && right<N) {
                if(arr[right] - arr[left] > M){
                    answer = Math.min(answer, arr[right] - arr[left]);
                    left++;
                } else if(arr[right]-arr[left]<M){
                    right ++;
                } else {
                    answer = M;
                    break;
                }
            }

            System.out.println(answer);
        }
    }
}

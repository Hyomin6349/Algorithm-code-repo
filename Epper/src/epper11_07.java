import java.io.*;
import java.util.*;

class epper11_07 {
    public static float solution(int[] num_arr, int n){
        Arrays.sort(num_arr);
        float sol = (float)(num_arr[0]+num_arr[1])/2;

        for(int i=2; i<n; i++){
            sol = (float)(sol+num_arr[i])/2;
        }
        return sol;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] num_arr = new int[n];
        for(int i=0;i<n;i++){
            num_arr[i] = Integer.parseInt(br.readLine());
        }
        float answer = solution(num_arr, n);
        System.out.format("%.6f", answer);
    }
}

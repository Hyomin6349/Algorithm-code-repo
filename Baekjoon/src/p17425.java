import java.util.*;
import java.io.*;

public class p17425 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        long[] d = new long[1000001];
        for(int i=1; i<=1000000;i++){
            for(int j=1; j*i<= 1000000;j++){
                d[i*j] += i;
            }
        }
        long[] arr = new long[1000001];
        arr[1] = d[1];
        for(int i=2;i<=1000000;i++){
            arr[i] =arr[i-1] + d[i];
        }
        StringBuilder sb = new StringBuilder();

        for(int i=0;i<tc;i++){
            int n = Integer.parseInt(br.readLine());
            sb.append(arr[n]).append('\n');
        }
        System.out.println(sb);
    }
}

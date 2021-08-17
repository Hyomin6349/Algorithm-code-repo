import java.util.*;
import java.io.*;

public class p11582 {

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] sortArr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++) arr[i] = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());

        int block = N/k;
        for(int i=0;i<k;i++){
            int[] part = Arrays.copyOfRange(arr, block*i, block*(i+1));
            Arrays.sort(part);
            for(int j=0;j<block;j++) sb.append(part[j]+" ");
        }

        System.out.println(sb);
    }
}

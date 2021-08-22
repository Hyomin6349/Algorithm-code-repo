import java.util.*;
import java.io.*;

public class p6549 {

    static int[] arr;
    static int n;

    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            if(n==0) break;

            arr = new int[n];
            for(int i=0;i<n;i++) arr[i] = Integer.parseInt(st.nextToken());
            sb.append(solve(0, n-1)).append('\n');
        }

        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }

    public static long solve(int left, int right){
        if(left==right) return arr[left];
        int mid = (left+right)/2;
        long max = Math.max(solve(left, mid), solve(mid+1, right));
        int height = Math.min(arr[mid], arr[mid+1]);
        int lo = mid, hi = mid+1;
        max = Math.max(max, height*2); // mid 포함한 사각형 초기화
        while(left<lo || hi<right){ //or 연산!
            if(hi<right && (lo==left || arr[lo-1] < arr[hi+1])){
                hi++;
                height = Math.min(height, arr[hi]);
            }
            else{
                lo--;
                height = Math.min(height, arr[lo]);
            }
            max = Math.max(max, (long)height*(hi-lo+1));
        }

        return max;
    }
}

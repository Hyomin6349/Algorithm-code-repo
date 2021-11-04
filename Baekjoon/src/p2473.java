import java.util.*;

public class p2473 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(sc.nextLine());
        for(int i=0;i<N;i++){
            arr[i] = Long.valueOf(st.nextToken());
        }

        Arrays.sort(arr);
        long abs = 3000000000L;
        long[] ans = new long[3];
        for(int i=0;i<N;i++){
            long ch = arr[i];
            int left = i+1;
            int right = N-1;

            while(left<right){
                long val = arr[left] + arr[right] + ch;
                if(Math.abs(val) < abs){
                    abs = Math.abs(val);
                    ans[0] = ch;
                    ans[1] = arr[left];
                    ans[2] = arr[right];
                }
                if(val > 0) right--;
                else if(val<=0) left++;
            }
        }

        System.out.println(ans[0]+" "+ans[1]+" "+ans[2]);
    }
}

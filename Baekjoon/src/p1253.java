import java.util.*;
import java.io.*;

public class p1253 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        int[] arr = new int[N];

        for(int i=0; i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        int cnt = 0;
        for(int i=0; i<N;i++){
            int left = 0;
            int right = N-1;

            while(left < right) {
                if (arr[left] + arr[right] < arr[i]) left++;
                else if (arr[left] + arr[right] > arr[i]) right--;
                else {
                    if(left == i) left ++;
                    else if(right == i) right --;
                    else {
                        cnt ++;
                        break;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}

import java.util.*;
import java.io.*;

public class p14002 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] dp = new int[n];
        int[] cache = new int[n];

        int max = -1;
        int maxIdx = -1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0;i<n;i++){
            arr[i] = Integer.parseInt(st.nextToken());  //배열 값 넣기
            dp[i] = 1;  //자기 자신 포함
            cache[i] = i;

            //이전 값들과 비교, 이전 부분수열과 합치기
            for(int j=0;j<i;j++) {
                //나보다 작고, 부분 수열의 크기가 증가함?
                // dp[j]: arr[j]로 끝나는 가장 긴 증가하는 부분수열
                // dp[j]+1 : arr[i] 포함한 경우
                if (arr[j] < arr[i] && dp[j]+1 > dp[i]){
                    dp[i] = dp[j]+1;
                    cache[i] = j;   //이전 값들이 어떤 부분 수열의 일부가 되었는지(?) 표시
                }
            }

            //최대 부분 수열, 끝나는 인덱스 찾기
            if(dp[i]>max){
                max = dp[i];
                maxIdx = i;
            }
        }

        int[] answer = new int[max];
        int idx = maxIdx;
        //오름차순으로 넣기
        for(int i=max-1;i>=0;i--){
            answer[i] = arr[idx];
            idx = cache[idx];
        }

        System.out.println(max);
        for(int i=0;i<max;i++){
            System.out.print(answer[i]+" ");
        }
    }
}

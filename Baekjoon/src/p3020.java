import java.util.*;
import java.io.*;

public class p3020 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        bot = new int[H+1];
        top = new int[H+1];
        min = N; cnt = 0;

        for(int i=0;i<N/2;i++){
            bot[Integer.parseInt(br.readLine())]++;
            top[Integer.parseInt(br.readLine())]++;
        }

        process();

        System.out.println(min+" "+cnt);

    }

    static int N, H;
    static int[] bot, top;
    static int min, cnt;

    public static void process(){
        int[] bot_sum = new int[H+1]; // 높이가 h 이하인 석순의 수
        int[] top_sum = new int[H+1];

        for(int i=1;i<=H;i++){
            bot_sum[i] = bot_sum[i-1] + bot[i];
            top_sum[i] = top_sum[i-1] + top[i];
        }

        for(int i=1;i<H+1;i++){
            int crush = 0;

            crush += bot_sum[H] - bot_sum[i-1];
            crush += bot_sum[H] - top_sum[H-i];

            if(min>crush){
                cnt = 1;
                min = crush;
            } else if(min==crush){
                cnt++;
            }
        }
    }

}

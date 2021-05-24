import java.util.*;
import java.io.*;

public class p17281 {

    static int[][] sheet;
    static boolean[] visit;
    static int[] player;
    static Set<String> set = new HashSet<>();
    static int n;
    static int answer = -1;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        sheet = new int[n][9];

        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<9;j++){
                sheet[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        visit = new boolean[9];
        player = new int[9];
        player[3] = 0;
        //2번 - 9번 순서 섞기
        lineUp(0);

        System.out.println(answer);
    }


    public static void lineUp(int cur){
        if(cur == 9){
            //중복 순서 제거
            String string= "";
            for(int i=0;i<9;i++) string += String.valueOf(player[i]);
            if(set.add(string)){
                int score = calScore();
                if(score > answer) answer = score;
            }
            return;
        }
        if(cur == 3){
            lineUp(cur+1);
            return;
        }
        for(int i=1;i<9;i++){
            if(visit[i]) continue;
            player[cur] = i;
            visit[i] = true;
            lineUp(cur+1);
            visit[i] = false;
        }
    }

    private static int calScore() {

        int result = 0;
        int index = 0;

        for(int i=0; i<n; i++) {
            boolean base[] = new boolean[4];
            base[0] = true;

            for(int j=0; j<3; j++) {
                int val = sheet[i][player[index]];
                if(val == 0) {
                    index++;
                    index%=9;
                }else {
                    for(int bs=3; bs>=0; bs--) {

                        if(base[bs]) {
                            if(bs+val >= 4) {
                                result++;
                                base[bs] = false;
                            }
                            else {
                                base[bs+val] = true;
                                base[bs] = false;
                            }
                        }
                    }
                    base[0] = true;
                    index++;
                    index%=9;
                    j--;
                }
            }
        }
        return result;
    }
}

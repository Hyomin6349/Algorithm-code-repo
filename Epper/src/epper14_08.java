// 실제 시험에서는 solution 함수를 사용한다는 점을 감안하고 풀이해주세요.
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 실제 시험에서는 solution을 제외한 함수 형태를 제공하지 않을 수 있습니다.
public class epper14_08 {
    static int n,m;
    static boolean change = true;
    static int answer=0;

    public static int check(int[][] box){
        for(int i=1;i<=n ; i++){
            for(int j=1;j<=m;j++){
                if(box[i][j]==0){
                    return -1;
                }
            }
        }
        return answer-1;
    }

    public static void day(int[][] box){
        change = false;
        for(int i=1;i<=n ; i++){
            for(int j=1;j<=m;j++){
                if(box[i][j]==1){
                    if(box[i-1][j]==0) box[i-1][j]=2;
                    if(box[i+1][j]==0) box[i+1][j]=2;
                    if(box[i][j-1]==0) box[i][j-1]=2;
                    if(box[i][j+1]==0) box[i][j+1]=2;
                }
            }
        }

        for(int i=1;i<=n ; i++){
            for(int j=1;j<=m;j++){
                if(box[i][j]==2){
                    change = true;
                    box[i][j] = 1;
                }
            }
        }

    }

    // 실제 시험에서 main은 수정할 수 없습니다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int temp = 0;
        // 입력 받기
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] box = new int[n+2][m+2];

        for(int y=1; y<=m; y++) {
            st = new StringTokenizer(br.readLine());
            for (int x = 1; x <= n; x++) {
                temp = Integer.parseInt(st.nextToken());
                box[x][y] = temp;
            }
        }

        while(change){
            day(box);
            answer++;
        };

        System.out.print(check(box));
    }
}
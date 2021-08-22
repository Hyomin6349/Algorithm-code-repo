import java.util.*;
import java.io.*;

public class p14499 {
    public static void main(String[] args)throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] d = {{0, 0, -1, 1}, {1, -1, 0, 0}};

        int[][] map = new int[N][M];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dice = {0, 0, 0, 0, 0, 0};
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<K;i++){
            int dir = Integer.parseInt(st.nextToken());
            int nx = x + d[0][dir-1];
            int ny = y + d[1][dir-1];
            if(0>nx || nx>=N || 0>ny || ny>=M) continue;
            int[] temp = dice.clone();
            switch(dir){
                case 1:
                    dice[0] = temp[3];
                    dice[2] = temp[5];
                    dice[3] = temp[2];
                    dice[5] = temp[0];
                    break;
                case 2:
                    dice[0] = temp[5];
                    dice[2] = temp[3];
                    dice[3] = temp[0];
                    dice[5] = temp[2];
                    break;
                case 3:
                    dice[0] = temp[4];
                    dice[1] = temp[0];
                    dice[2] = temp[1];
                    dice[4] = temp[2];
                    break;
                case 4:
                    dice[0] = temp[1];
                    dice[1] = temp[2];
                    dice[2] = temp[4];
                    dice[4] = temp[0];
                    break;
            }
            sb.append(dice[0]).append('\n');

            if(map[nx][ny]==0) map[nx][ny] = dice[2];
            else {
                dice[2] = map[nx][ny];
                map[nx][ny] = 0;
            }
            x = nx;
            y = ny;
        }
        sb.setLength(sb.length()-1);
        System.out.println(sb);
    }

}

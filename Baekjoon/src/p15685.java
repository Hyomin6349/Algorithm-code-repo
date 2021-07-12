import java.util.*;

public class p15685 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] pattern = new int[4][1024];
        boolean[][] map = new boolean[101][101];

        pattern[0][0] = 0;
        pattern[1][0] = 1;
        pattern[2][0] = 2;
        pattern[3][0] = 3;

        for (int k = 0; k < 4; k++) {
            for (int i = 1; i <= 10; i++) {
                int start = (int) Math.pow(2, i - 1);
                int end = (int) Math.pow(2, i);
                for (int j = start, l = 1; j < end; j++, l += 2) {
                    pattern[k][j] = pattern[k][j - l] + 1 == 4 ? 0 : pattern[k][j - l] + 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int d = sc.nextInt();
            int g = sc.nextInt();
            int end = (int) Math.pow(2, g);

            int currentX = x;
            int currentY = y;
            map[currentY][currentX] = true;

            for (int j = 0; j < end; j++) {
                if (pattern[d][j] == 0) {
                    currentX += 1;
                } else if (pattern[d][j] == 1) {
                    currentY -= 1;
                } else if (pattern[d][j] == 2) {
                    currentX -= 1;
                } else {
                    currentY += 1;
                }
                map[currentY][currentX] = true;
            }
        }

        // 맵 탐색
        int cnt = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (map[i][j] && map[i][j + 1] && map[i + 1][j] && map[i + 1][j + 1]) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }
}

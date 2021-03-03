//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Arrays;
import java.util.Comparator;

public class greedy6 {
    public greedy6() {
    }

    public static int solution(int[][] routes) {
        int answer = 0;
        Arrays.sort(routes, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int camera = -30001;
        int[][] var6 = routes;
        int var5 = routes.length;

        for(int var4 = 0; var4 < var5; ++var4) {
            int[] route = var6[var4];
            if (camera < route[0]) {
                camera = route[1];
                ++answer;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[][] routes = new int[][]{{-20, 15}};
        System.out.println(solution(routes));
    }
}

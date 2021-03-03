//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;

public class greedy5 {
    public greedy5() {
    }

    static int solution(int n, int[][] costs) {
        int answer = 0;
        ArrayList<Integer> in = new ArrayList();
        int[][] adj = new int[n][n];

        int min;
        for(min = 0; min < costs.length; ++min) {
            adj[costs[min][0]][costs[min][1]] = adj[costs[min][1]][costs[min][0]] = costs[min][2];
        }

        in.add(0);

        while(in.size() < n) {
            min = 2147483647;
            int minIdx = -1;

            for(int i = 0; i < in.size(); ++i) {
                int island = (Integer)in.get(i);

                for(int j = 0; j < n; ++j) {
                    if (!in.contains(j) && adj[island][j] > 0 && adj[island][j] < min) {
                        min = adj[island][j];
                        minIdx = j;
                    }
                }
            }

            in.add(minIdx);
            answer += min;
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 4;
        int[][] costs = new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}};
        System.out.println(solution(n, costs));
    }
}

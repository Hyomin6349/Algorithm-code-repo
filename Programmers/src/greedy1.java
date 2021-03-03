//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Arrays;

public class greedy1 {
    public greedy1() {
    }

    static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int lost_index = 0;
        int reserve_index = 0;
        int[] students = new int[n + 2];
        Arrays.sort(lost);
        Arrays.sort(reserve);

        int var10002;
        int i;
        for(i = 1; i <= n; ++i) {
            students[i] = 1;
            if (lost_index < lost.length && i == lost[lost_index]) {
                var10002 = students[i]--;
                ++lost_index;
            }

            if (reserve_index < reserve.length && i == reserve[reserve_index]) {
                var10002 = students[i]++;
                ++reserve_index;
            }
        }

        for(i = 1; i <= n; ++i) {
            if (students[i] == 0) {
                if (students[i - 1] > 1) {
                    --students[i - 1];
                    var10002 = students[i]++;
                } else if (students[i + 1] > 1) {
                    --students[i + 1];
                    var10002 = students[i]++;
                }
            }
        }

        for(i = 1; i <= n; ++i) {
            if (students[i] >= 1) {
                ++answer;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int n = 3;
        int[] lost = new int[]{3};
        int[] reserve = new int[]{1};
        System.out.println(solution(n, lost, reserve));
    }
}

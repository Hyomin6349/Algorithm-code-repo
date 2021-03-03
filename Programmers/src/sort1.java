//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Arrays;

public class sort1 {
    public sort1() {
    }

    static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i = 0; i < commands.length; ++i) {
            int[] arr = new int[commands[i][1] - commands[i][0] + 1];
            int index = 0;

            for(int j = commands[i][0] - 1; j <= commands[i][1] - 1; ++j) {
                arr[index] = array[j];
                ++index;
            }

            Arrays.sort(arr);
            answer[i] = arr[commands[i][2] - 1];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 5, 2, 6, 3, 7, 4};
        int[][] commands = new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        solution(array, commands);
    }
}

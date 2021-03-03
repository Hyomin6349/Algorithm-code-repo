//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Arrays;

public class greedy3 {
    public greedy3() {
    }

    public static int solution(String name) {
        int answer = 0;
        char[] arr = name.toCharArray();
        char[] temp = new char[arr.length];
        int left = 0;
        int down = 0;
        int up = 0;
        int right = 0;

        int i;
        for(i = 0; i < arr.length; ++i) {
            temp[i] = 'A';
        }

        for(i = 1; i < arr.length; ++i) {
            if (arr[i] != 'A') {
                left = arr.length - i;
                break;
            }
        }

        for(i = arr.length - 1; i > 0; --i) {
            if (arr[i] != 'A') {
                right = i;
                break;
            }
        }

        char check = right <= left ? 'r' : 'l';
        up = arr[0] - 'A';
        down = 'Z' - arr[0] + 1;
        if (up <= down) {
            answer = answer + up;
        } else {
            answer = answer + down;
        }

        temp[0] = arr[0];
        ++answer;
        if (check == 'r') {
            for(i = 1; i < arr.length && !Arrays.equals(arr, temp); ++i) {
                up = arr[i] - 'A';
                down = 'Z' - arr[i] + 1;
                if (up <= down) {
                    answer += up;
                } else {
                    answer += down;
                }

                temp[i] = arr[i];
                ++answer;
            }
        }

        if (check == 'l') {
            for(i = arr.length - 1; i >= 0 && !Arrays.equals(arr, temp); --i) {
                up = arr[i] - 'A';
                down = 'Z' - arr[i] + 1;
                if (up <= down) {
                    answer += up;
                } else {
                    answer += down;
                }

                temp[i] = arr[i];
                ++answer;
            }
        }

        return answer - 1;
    }

    public static void main(String[] args) {
        String name = "ABAAAAAAAAABB";
        System.out.println(solution(name));
    }
}

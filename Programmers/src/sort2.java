//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Arrays;
import java.util.Comparator;

public class sort2 {
    public sort2() {
    }

    static String solution(int[] numbers) {
        String answer = "";
        String[] str = new String[numbers.length];

        int j;
        for(j = 0; j < str.length; ++j) {
            str[j] = String.valueOf(numbers[j]);
        }

        Arrays.sort(str, new Comparator<String>() {
            public int compare(String s1, String s2) {
                return (s2 + s1).compareTo(s1 + s2);
            }
        });
        if (str[0].startsWith("0")) {
            answer = answer + "0";
        } else {
            for(j = 0; j < str.length; ++j) {
                answer = answer + str[j];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{30, 3, 30, 30, 3, 3};
        String a = solution(nums);
        System.out.println(a);
    }
}

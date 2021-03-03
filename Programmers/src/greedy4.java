//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Arrays;

public class greedy4 {

    static int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int right = people.length - 1;
        int left = 0;

        while(left <= right) {
            if (people[right] + people[left] <= limit) {
                --right;
                ++left;
                ++answer;
            } else {
                --right;
                ++answer;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] people = new int[]{70, 50, 80, 50};
        int limit = 100;
        System.out.println(solution(people, limit));
    }
}

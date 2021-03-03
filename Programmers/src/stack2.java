//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;

public class stack2 {
    public stack2() {
    }

    static int[] solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> list_answer = new ArrayList();
        int[] left = new int[progresses.length];
        int[] days = new int[progresses.length];

        int temp;
        int i;
        for(temp = 0; temp < progresses.length; ++temp) {
            left[temp] = 100 - progresses[temp];

            for(i = 1; left[temp] > speeds[temp] * i; ++i) {
            }

            days[temp] = i;
        }

        temp = 0;

        for(i = 0; i < days.length; ++i) {
            if (days[temp] < days[i]) {
                list_answer.add(i - temp);
                temp = i;
            }

            if (i == days.length - 1) {
                list_answer.add(days.length - temp);
            }
        }

        int[] answer = new int[list_answer.size()];

        for(i = 0; i < answer.length; ++i) {
            answer[i] = (Integer)list_answer.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] progresses = new int[]{55, 55, 55};
        int[] speeds = new int[]{5, 5, 3};
        int[] answer = solution(progresses, speeds);

        for(int i = 0; i < answer.length; ++i) {
            System.out.println(answer[i]);
        }

    }
}

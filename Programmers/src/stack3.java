//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.LinkedList;
import java.util.Queue;

public class stack3 {
    public stack3() {
    }

    static int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> q = new LinkedList();
        int[] bridge = new int[bridge_length];
        int sum = 0;

        int i;
        for(i = 0; i < truck_weights.length; ++i) {
            q.offer(truck_weights[i]);
        }

        while(!q.isEmpty()) {
            if (sum + (Integer)q.peek() <= weight) {
                bridge[bridge_length - 1] = (Integer)q.poll();
            }

            sum = 0;
            ++answer;

            for(i = 0; i < bridge_length - 1; ++i) {
                bridge[i] = bridge[i + 1];
                sum += bridge[i];
            }

            bridge[bridge_length - 1] = 0;
        }

        answer += bridge_length;
        return answer;
    }

    public static void main(String[] args) {
        int bridge_length = 10;
        int weight = 20;
        int[] truck_weights = new int[]{1, 5, 7, 9, 5, 4, 2, 1, 5, 1, 20, 11, 13};
        int answer = solution(bridge_length, weight, truck_weights);
        System.out.println(answer);
    }
}

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.PriorityQueue;

public class heap3 {
    public heap3() {
    }

    static int[] solution(String[] operations) {
        int[] answer = new int[2];
        PriorityQueue<Integer> maxQ = new PriorityQueue();
        PriorityQueue<Integer> minQ = new PriorityQueue();

        for(int i = 0; i < operations.length; ++i) {
            int endIndex = operations[i].length();
            int num = 0;
            if (operations[i].charAt(2) == '-') {
                num = Integer.parseInt(operations[i].substring(3, endIndex));
                num *= -1;
            } else {
                num = Integer.parseInt(operations[i].substring(2, endIndex));
            }

            switch(operations[i].charAt(0)) {
                case 'D':
                    if (maxQ.size() != 0) {
                        int delete;
                        if (operations[i].charAt(2) == '1') {
                            delete = (Integer)maxQ.poll();
                            maxQ.remove(delete * -1);
                        } else {
                            delete = (Integer)minQ.poll();
                            minQ.remove(delete * -1);
                        }
                    }
                    break;
                case 'I':
                    maxQ.add(num * -1);
                    minQ.add(num);
            }
        }

        if (maxQ.size() > 0) {
            answer[0] = (Integer)maxQ.peek() * -1;
            answer[1] = (Integer)minQ.peek();
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] operations = new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        int[] answer = solution(operations);
        System.out.println(answer[0] + " " + answer[1]);
    }
}

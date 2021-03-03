package heap2;//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class heap2 {
    public heap2() {
    }

    static int solution(int[][] jobs) {
        int answer = 0;
        PriorityQueue<Job> pq = new PriorityQueue(new Comparator<Job>() {
            public int compare(Job j1, Job j2) {
                return j1.t - j2.t;
            }
        });
        int finish = 0;
        int index = 0;
        int time = 0;
        int take = 0;
        Arrays.sort(jobs, new Comparator<int[]>() {
            public int compare(int[] i1, int[] i2) {
                return i1[0] - i2[0];
            }
        });

        while(finish < jobs.length) {
            while(index < jobs.length && jobs[index][0] <= time) {
                pq.add(new Job(jobs[index][0], jobs[index][1]));
                ++index;
            }

            if (!pq.isEmpty()) {
                Job tmp = (Job)pq.peek();
                ++finish;
                time += tmp.t;
                take += time - tmp.s;
            } else {
                ++time;
            }
        }

        answer = take / jobs.length;
        return answer;
    }

    public static void main(String[] args) {
        int[][] jobs = new int[][]{{2, 1}, {3, 4}, {5, 3}};
        int answer = solution(jobs);
        System.out.println(answer);
    }
}

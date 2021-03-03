//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package stack4;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class stack4 {
    public stack4() {
    }

    static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Waiting> q = new LinkedList();

        int top;
        for(top = 0; top < priorities.length; ++top) {
            q.offer(new Waiting(priorities[top], top));
        }

        Arrays.sort(priorities);
        top = priorities.length - 1;

        while(!q.isEmpty()) {
            Waiting tmp;
            if (top > -1 && ((Waiting)q.peek()).priority == priorities[top]) {
                tmp = (Waiting)q.poll();
                ++answer;
                --top;
                if (tmp.index == location) {
                    break;
                }
            } else {
                tmp = (Waiting)q.poll();
                q.offer(tmp);
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] priorities = new int[]{2, 1, 3, 2};
        int location = 2;
        int answer = solution(priorities, location);
        System.out.println(answer);
    }
}

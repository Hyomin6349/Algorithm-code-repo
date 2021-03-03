//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.ArrayList;
import java.util.Arrays;

public class heap1 {
    public heap1() {
    }

    static void min_heap(ArrayList<Integer> heap, int val) {
        heap.add(val);

        for(int p = heap.size() - 1; p > 1 && (Integer)heap.get(p / 2) > (Integer)heap.get(p); p /= 2) {
            int tmp = (Integer)heap.get(p / 2);
            heap.set(p / 2, (Integer)heap.get(p));
            heap.set(p, tmp);
        }

    }

    static void delete(ArrayList<Integer> heap) {
        heap.set(1, (Integer)heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);

        int minPos;
        for(int pos = 1; pos * 2 < heap.size(); pos = minPos) {
            int min = (Integer)heap.get(pos * 2);
            minPos = pos * 2;
            if (pos * 2 + 1 < heap.size() && min > (Integer)heap.get(pos * 2 + 1)) {
                min = (Integer)heap.get(pos * 2 + 1);
                minPos = pos * 2 + 1;
            }

            if ((Integer)heap.get(pos) < min) {
                break;
            }

            int tmp = (Integer)heap.get(pos);
            heap.set(pos, (Integer)heap.get(minPos));
            heap.set(minPos, tmp);
        }

    }

    static int solution(int[] scoville, int K) {
        int answer = 0;
        ArrayList<Integer> heap = new ArrayList();
        heap.add(0);
        Arrays.sort(scoville);

        int first;
        for(first = 0; first < scoville.length; ++first) {
            min_heap(heap, scoville[first]);
        }

        while((Integer)heap.get(1) < K) {
            if (heap.size() < 3) {
                return -1;
            }

            ++answer;
            first = (Integer)heap.get(1);
            delete(heap);
            int second = (Integer)heap.get(1);
            delete(heap);
            int addFood = first + second * 2;
            min_heap(heap, addFood);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] scoville = new int[]{1, 2, 3, 9, 10, 12};
        int k = 7;
        int answer = solution(scoville, k);
        System.out.println(answer);
    }
}

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Arrays;

public class sort3 {
    public sort3() {
    }

    static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        if (citations[citations.length - 1] == 0) {
            return answer;
        } else {
            for(int i = citations.length - 1; i >= 0; --i) {
                ++answer;
                if (answer > citations[i]) {
                    --answer;
                    break;
                }
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        int[] c = new int[]{6, 6, 6, 6, 6};
        int answer = solution(c);
        System.out.println(answer);
    }
}

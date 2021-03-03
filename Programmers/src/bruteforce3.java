//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class bruteforce3 {
    public bruteforce3() {
    }

    static int[] solution(int brown, int yellow) {
        int[] answer = new int[2];

        for(int m = 1; m <= yellow; ++m) {
            if (yellow % m == 0) {
                int n = yellow / m;
                if (m >= n && brown == 2 * m + 2 * n + 4) {
                    answer[0] = m + 2;
                    answer[1] = n + 2;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int brown = 10;
        int yellow = 2;
        int[] answer = solution(brown, yellow);
        System.out.println(answer[0] + " " + answer[1]);
    }
}

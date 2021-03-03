//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class bruteforce1 {
    public bruteforce1() {
    }

    static int[] solution(int[] answers) {
        int[] answer = new int[2];
        int[] A = new int[]{1, 2, 3, 4, 5};
        int[] B = new int[]{2, 1, 2, 3, 2, 4, 2, 5};
        int[] C = new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int a = 0;
        int b = 0;
        int c = 0;
        int aa = 0;
        int bb = 0;
        int cc = 0;

        for(int i = 0; i < answers.length; ++i) {
            int val = answers[i];
            if (A[a] == val) {
                ++aa;
            }

            if (B[b] == val) {
                ++bb;
            }

            if (C[c] == val) {
                ++cc;
            }

            a = (a + 1) % 5;
            b = (b + 1) % 8;
            c = (c + 1) % 10;
        }

        System.out.println(aa + " " + bb + " " + cc);
        return answer;
    }

    public static void main(String[] args) {
        int[] answers = new int[]{1, 2, 3, 4, 5};
        int[] answer = solution(answers);

        for(int i = 0; i < answer.length; ++i) {
            System.out.println(answer[i]);
        }

    }
}

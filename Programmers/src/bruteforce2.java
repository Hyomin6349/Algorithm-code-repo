//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.HashSet;

public class bruteforce2 {
    static char[] chs;
    static boolean[] visited;
    static HashSet<Integer> set;
    static char[] select;

    public bruteforce2() {
    }

    static int solution(String numbers) {
        chs = numbers.toCharArray();
        visited = new boolean[numbers.length()];
        set = new HashSet();

        int answer;
        for(answer = 1; answer <= numbers.length(); ++answer) {
            select = new char[answer];
            perm(0, answer, numbers.length());
        }

        answer = set.size();
        return answer;
    }

    static void perm(int start, int r, int n) {
        if (start != r) {
            for(int i = 0; i < n; ++i) {
                if (!visited[i]) {
                    visited[i] = true;
                    select[start] = chs[i];
                    perm(start + 1, r, n);
                    visited[i] = false;
                }
            }

        } else {
            String str = "";

            int num;
            for(num = 0; num < select.length; ++num) {
                str = str + select[num];
            }

            num = Integer.parseInt(str);
            if (num != 1 && num != 0) {
                boolean flag = false;

                for(int i = 2; (double)i <= Math.sqrt((double)num); ++i) {
                    if (num % i == 0) {
                        flag = true;
                    }
                }

                if (!flag) {
                    set.add(num);
                }

            }
        }
    }

    public static void main(String[] args) {
        String numbers = "17";
        int answer = solution(numbers);
        System.out.println(answer);
    }
}

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class stack1 {
    public stack1() {
    }

    static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int tmp = 0;

        for(int i = 0; i < prices.length - 1; ++i) {
            for(int j = i; j < prices.length; ++j) {
                if (prices[i] > prices[j]) {
                    tmp = j - i;
                    break;
                }

                if (j == prices.length - 1) {
                    tmp = prices.length - i - 1;
                }
            }

            answer[i] = tmp;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1, 2, 3, 2, 3};
        int[] answer = solution(prices);

        for(int i = 0; i < answer.length; ++i) {
            System.out.println(answer[i]);
        }

    }
}

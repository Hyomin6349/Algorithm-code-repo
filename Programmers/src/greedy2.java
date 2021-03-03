//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

public class greedy2 {
    public greedy2() {
    }

    public static String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();

        int idx = 0;
        int comp = 0;
        for(int i=0; i<number.length()-k; i++){
            comp = 0;
            for(int j=idx; j<=i+k; j++){
                if(comp < number.charAt(j)-'0'){
                    comp = number.charAt(j)-'0';
                    idx = j+1;
                }
            }
            answer.append(comp);
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        String number = "0010000";
        int k = 4;
        System.out.println(solution(number, k));
    }
}

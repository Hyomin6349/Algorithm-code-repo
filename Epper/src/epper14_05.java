// 실제 시험에서는 Solution 클래스의 solution 함수를 사용합니다. 이를 감안하여 풀이해주세요.
import java.util.*;

// 실제 시험 시, 필요한 클래스를 참가자가 '직접' 구현해야 할 수 있습니다.
class Word implements Comparable<Word>{
    String word;
    int count; //말해진 횟수
    int idx;

    public Word(String word, int idx) {
        this.word = word;
        this.idx = idx;
        this.count = 0;
    }

    @Override
    public int compareTo(Word o) {
        if(this.count == o.count) return word.compareTo(o.word);    //count가 같다면 소문자 오름차순 정렬
        else return this.count - o.count; //count 오름차순
    }


}

class epper14_05 {
    // 실제 시험에서는 solution을 사용하여 답안을 제출합니다.
    public static String[] solution(int k, int n, String[] words, String[] user_inputs){
        String[] answer = new String[user_inputs.length];
        Word[] temp_word = new Word[words.length];

        for(int i=0;i<words.length;i++) temp_word[i] = new Word(words[i], i); //initalize

        for(int i=0; i< user_inputs.length; i++){
            PriorityQueue<Word> pq = new PriorityQueue<Word>();
            for(int j=0 ;j< words.length; j++){
                if(user_inputs[i].charAt(0) == words[j].charAt(0)){
                    pq.add(temp_word[j]);
                }
            }
            temp_word[pq.peek().idx].count++;
            answer[i] = pq.peek().word;
        }

        return answer;
    }
    // 실제 시험에서는 main을 사용하지 않습니다.
    // main은 수정하지 말아주세요.
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int k, n;
        // k, n 입력받기
        k = scanner.nextInt();
        n = scanner.nextInt();
        scanner.nextLine();
        String[] words = new String[k];
        String[] user_inputs = new String[n];
        // 미리 주어지는 단어 입력 받기
        for(int i = 0; i < k; i++)
            words[i] = scanner.nextLine();
        for(int i = 0; i < n; i++)
            user_inputs[i] = scanner.nextLine();

        String[] answer = solution(k, n, words, user_inputs);

        for(String ans : answer)
            System.out.println(ans);
    }
}

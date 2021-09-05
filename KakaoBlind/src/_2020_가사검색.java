public class _2020_가사검색 {

    public static class Trie{
        int count; //자식의 수
        Trie[] childList;

        public Trie(){
            count = 0;
            childList = new Trie[26];// 26개의 알파벳
        }

        // 트리의 자식 노드로 이동하며 트리 갱신
        public void insert(char[] word){
            Trie cur = this;
            for(char c: word){
                ++cur.count;
                int idx = c-'a';
                if(cur.childList[idx]==null) cur.childList[idx] = new Trie();
                cur = cur.childList[idx];
            }
        }

        public int search(char[] query){
            Trie cur = this;
            for(char c: query){
                if(c=='?') return cur.count;
                int idx = c-'a';
                if(cur.childList[idx]==null) return 0;
                cur = cur.childList[idx];
            }
            return cur.count;
        }
    }

    public static int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

        // root 아래 word의 길이 노드가 오고 그아래 word가 옴
        // word의 길이는 1 이상 10000이하
        Trie[] tries = new Trie[10001]; // 접미사 용
        Trie[] rtries = new Trie[10001]; // 접두사 용

        //word 집어 넣으며 trie 생성
        for(String word: words){
            int size = word.length();
            if(tries[size]==null) tries[size] = new Trie();
            tries[size].insert(word.toCharArray());

            word = (new StringBuilder(word)).reverse().toString(); //반대 문자열
            if(rtries[size]==null) rtries[size] = new Trie();
            rtries[size].insert(word.toCharArray());
        }

        int idx = -1;
        for(String query: queries){
            idx++;
            if(query.charAt(0)=='?'){//접두사
                if(rtries[query.length()]==null) continue;
                query = (new StringBuilder(query)).reverse().toString();
                answer[idx] = rtries[query.length()].search(query.toCharArray());
            }
            else{
                if(tries[query.length()]==null) continue;
                answer[idx] = tries[query.length()].search(query.toCharArray());
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        String[] words = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String[] queries = {"fro??", "????o", "fr???", "fro???", "pro?"};
        int[] answer = solution(words, queries);
        for(int i=0;i<answer.length;i++){
            System.out.println(answer[i]);
        }
    }
}

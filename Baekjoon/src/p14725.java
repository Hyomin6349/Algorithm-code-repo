import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class p14725 {

    public static class Trie{
        String value;
        ArrayList<Trie> childList;

        public Trie(String value){
            childList = new ArrayList<>();
            this.value = value;
        }

        public void insert(String[] foods){
            Trie cur = this;
            nextFood : for(String food: foods){
                for(int i=0; i<cur.childList.size();i++){
                    Trie next = cur.childList.get(i);
                    if(next.value.equals(food)){
                        cur = next;
                        continue nextFood;
                    }
                }
                Trie next = new Trie(food);
                cur.childList.add(next);

                cur = next;
            }
        }

        public void print(String level){
            Collections.sort(childList, new Comparator<Trie>() {
                @Override
                public int compare(Trie o1, Trie o2) {
                    return o1.value.compareTo(o2.value);
                }
            });

            for(Trie trie:childList){
                sb.append(level).append(trie.value).append('\n');
                trie.print(level+"--");
            }
        }
    }

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Trie root = new Trie("");

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            String[] foods = new String[k];
            for(int j=0;j<k;j++) foods[j] = st.nextToken();
            root.insert(foods);
        }

        root.print("");

        System.out.println(sb);

    }
}

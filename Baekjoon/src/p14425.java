import java.util.*;
import java.io.*;

public class p14425 {

    public static class Trie{
        int length;
        Trie[] child;

        public Trie(int length){
            this.length = length;
            child = new Trie[26];
        }

        public void insert(char[] word){
            Trie cur = this;
            next: for(char c: word){
                if(cur.child[c-'a']!=null) {
                    cur = cur.child[c-'a'];
                    continue next;
                } else {
                    cur.child[c-'a'] = new Trie(0);
                    cur = cur.child[c-'a'];
                }
            }
        }

        public int find(char[] word){
            Trie cur = this;
            next: for(char c: word){
                if(cur.child[c-'a']==null) return 0;

                cur = cur.child[c-'a'];
                continue next;
            }
            return 1;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Trie[] root = new Trie[N];

        for(int i=0;i<N;i++){
            char[] word = br.readLine().toCharArray();
            root[i] = new Trie(word.length);
            root[i].insert(word);
        }

        int cnt = 0;
        for(int i=0;i<M;i++){
            char[] word = br.readLine().toCharArray();

            for(int j=0;j<N;j++){
                if(word.length == root[j].length) {
                    int res = root[j].find(word);
                    if (res == 1) {
                        cnt++;
                        break;
                    }
                }
            }
        }

        System.out.println(cnt);
    }
}

import java.util.*;
import java.io.*;

public class p14425 {

    public static class Trie{
        Trie[] child;

        public Trie(){
            child = new Trie[26];
        }

        public void insert(char[] word){
            Trie cur = this;
            next: for(char c: word){
                if(cur.child[c-'a']!=null) {
                    cur = cur.child[c-'a'];
                    continue next;
                } else {
                    cur.child[c-'a'] = new Trie();
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
            for(int i=0;i<26;i++){
                if(cur.child[i] != null) return 0;
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
            root[i] = new Trie();
            root[i].insert(br.readLine().toCharArray());
        }

        int cnt = 0;
        for(int i=0;i<M;i++){
            char[] word = br.readLine().toCharArray();

            for(int j=0;j<N;j++){
                int res = root[j].find(word);
                if(res == 1){
                    cnt++;
                    break;
                }
            }
        }

        System.out.println(cnt);
    }
}

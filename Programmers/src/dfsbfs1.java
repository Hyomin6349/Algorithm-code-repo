import java.util.*;

class Node{
    String val;
    int level;
    public Node(String v,int l) {
        val=v;
        level=l;
    }
}

public class dfsbfs1 {
    static boolean check(String a,String b) {
        int num=0;
        for(int i=0;i<a.length();i++) {
            if(a.charAt(i)!=b.charAt(i)) num++;
        }
        return num==1?true:false;
    }

    static int solution(String begin, String target, String[] words) {
        int answer = 0;

        Queue<Node> q = new LinkedList<>();
        boolean[] visited=new boolean[words.length];
        for(int i=0;i<words.length;i++) {
            visited[i]=false;
            if(begin.equals(words[i]))
                return 0;
        }

        q.add(new Node(begin,0));

        while(!q.isEmpty()) {
            Node cur=q.poll();
            if(target.equals(cur.val)) return cur.level;
            for(int i=0;i<words.length;i++) {
                //방문하지 않았고 1개의 문자만 다르다면
                if(!visited[i] && check(cur.val,words[i])) {
                    visited[i]=true;
                    q.add(new Node(words[i],cur.level+1));
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String begin="hit";
        String target="cog";
        String[] words= {"hot", "dot", "dog", "lot", "log", "cog"};

        System.out.println(solution(begin,target,words));
    }

}

import java.util.*;
import java.io.*;

public class p1967 {
    public static class Node{
        int parent;
        int end; //이 노드를 포함하는 최대 지름을 만들 때 끝 노드
        int weight; //지름
        public Node(int p, int e, int w){
            parent = p;
            end = e;
            weight = w;
        }
    }

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[10001];
        Set<Integer> leaves = new HashSet<>();
        nodes[1] = new Node(0,1, 0);
        leaves.add(1);
        int answer = 0;

        for(int i=0;i<N-1;i++){
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            leaves.remove(p); // leaf node에서 제거
            leaves.add(c);  //leaf node에 추가
            int p_end = nodes[p].end;

            // 새로운 노드 값 갱신\
            nodes[c] = new Node(p,p_end, nodes[p].weight + w);
            if(nodes[c].weight > answer) answer = nodes[c].weight;

            // 연결된 node 값 갱신
            if(nodes[p_end].weight < nodes[c].weight){
                nodes[p_end].end = c;
                nodes[p_end].weight = nodes[c].weight;
            }

            //부모노드 갱신 max(기존, 새로운)
            if(nodes[p].weight < w){
                nodes[p].end = c;
                nodes[p].weight = w;
            }

            // leaves 중 새로운 노드의 부모노드를 끝 노드로 하고 있던 노드들 갱신
            Iterator<Integer> it = leaves.iterator();
            while(it.hasNext()){
                int node = it.next();
                if(node!=c && nodes[node].parent!=p &&nodes[node].end == p){
                    nodes[node].end = c;
                    nodes[node].weight += w;
                }
            }
        }

        System.out.println(answer);
    }
}


import java.util.*;

public class graph1 {
    static int solution(int n, int[][] edge) {

        Set<Integer> list=new HashSet<>(); //가장 거리가 먼 간선이 아닌것;
        Set<Integer> temp=new HashSet<>();
        int left=n-1;	//남은 노드 수, 1제외
        int count=0; 	// 새로 큐에 포함될 노드의 개수

        list.add(1);

        while(true) {
            for(int i=0;i<edge.length;i++) {
                if(!list.contains(edge[i][0])&& list.contains(edge[i][1])){
                    temp.add(edge[i][0]);
                }
                if(!list.contains(edge[i][1])&& list.contains(edge[i][0])){
                    temp.add(edge[i][1]);
                }
            }
            //temp를 list에 추가
            count=temp.size();
            list.addAll(temp);
            temp.clear();
            left -= count;
            if(left==0) {
                return count;
            }
        }

    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n=6;
        int[][] vertex= {{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}};
        System.out.println(solution(n,vertex));
    }

}

import java.util.*;

public class test2 {

    public static class Client implements Comparable<Client>{
        int id;
        int grade;
        public Client(int id, int grade){
            this.id = id;
            this.grade = grade;
        }
        @Override
        public int compareTo(Client o){
            if(grade == o.grade){
                return id - o.id;
            }
            else return grade - o.grade;
        }
    }

    public static int[] solution(int[] t, int[] r) {
        int[] answer = new int[t.length];
        ArrayList<Client>[] lift = new ArrayList[1000];

        for(int i=0;i<1000;i++) lift[i] = new ArrayList<>();
        for(int i=0;i<t.length;i++){
            lift[t[i]].add(new Client(i, r[i]));
        }

        for(int i=0;i<t.length;i++){
            if(lift[i].size() == 0) continue;
            Collections.sort(lift[i]);
            answer[i] = lift[i].get(0).id;

            for(int j=0;j<lift[i].size();j++){
                System.out.print(lift[i].get(j).id+" ");
            }
            System.out.println();

            for(int j=1;j<lift[i].size();j++){
                Client c = lift[i].get(j);
                lift[i+1].add(c);
            }
        }

        return answer;
    }

    public static void main(String[] args){

        int[] t = {7,6,8,1};
        int[]  r = {0,1,2,3};

        int[] result = solution(t, r);
        for(int i=0;i<result.length;i++) System.out.print(result[i]);
    }
}

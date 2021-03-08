import java.util.*;

public class epper13_07 {
    public static int solution(ArrayList<Integer> list, int start, int end) {
        int answer = 0;

        int size = list.size();
        for(int i=0;i<size/2;i++){
            if(size==1) break;
            if(list.get(i)>list.get(size-1-i)){
                list.set(size-2-i, list.get(size-1-i)+list.get(size-2-i));
                list.remove(size-1-i);
                i=-1;
                size=list.size();
                answer++;
                continue;
            }else if(list.get(i)<list.get(size-1-i)){
                list.set(i, list.get(i)+list.get(i+1));
                list.remove(i+1);
                i=-1;
                size=list.size();
                answer++;
                continue;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList<Integer>();
        int n =  sc.nextInt();
        int start = 0;
        int end = 0;

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        end = n - 1;

        System.out.println(solution(list, start, end));
    }
}
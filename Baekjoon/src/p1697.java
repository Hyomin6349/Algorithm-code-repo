import java.util.*;

public class p1697 {

    static int brother;
    static Queue<Integer> q = new LinkedList<>();
    static Set<Integer> set = new HashSet<>();

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int subin = input.nextInt();
        brother = input.nextInt();

        if(subin == brother){
            System.out.println(0);
            return;
        }

        q.add(subin);
        set.add(subin);

        int ans = 0;
        while(true){
            ans++;
            if(move()){
                System.out.println(ans);
                return;
            }
        }
    }

    public static boolean move(){
        int size = q.size();

        for(int i=0; i<size; i++){
            int cur = q.poll();

            if(cur-1 == brother || cur+1 == brother || cur*2 == brother) return true;
            else{
                if(set.add(cur-1))q.add(cur-1);
                if(set.add(cur+1) && cur+1<=100000)q.add(cur+1);
                if(set.add(cur*2) && cur*2<=100000)q.add(cur*2);
            }
        }
        return false;
    }
}

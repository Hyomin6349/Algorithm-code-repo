import java.util.*;

public class p13913 {

    static int brother;
    static Queue<Integer> q = new LinkedList<>();
    static Set<Integer> set = new HashSet<>();
    static int[] from = new int[100001];
    static Stack<Integer> stack = new Stack<>();


    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int subin = input.nextInt();
        brother = input.nextInt();

        if(subin == brother){
            sb.append(0).append('\n').append(subin);
            System.out.println(sb);
            return;
        }
        if(subin > brother){
            sb.append(subin-brother).append('\n');
            for(int i=subin; i>=brother; i--){
                sb.append(i).append(' ');
            }
            System.out.println(sb);
            return;
        }

        q.add(subin);
        set.add(subin);
        from[subin] = -1;
        stack.push(brother);//도착지

        int ans = -1;
        while(true){
            ans++;
            if(move()){
                sb.append(ans).append('\n');
                int f = from[brother];
                while(f!=-1){
                    stack.push(f);
                    f = from[f];
                }
                break;
            }
        }
        while(!stack.isEmpty()){
            int n = stack.pop();
            sb.append(n).append(' ');
        }
        System.out.println(sb);
    }

    public static boolean move(){
        int size = q.size();

        for(int i=0; i<size; i++){
            int cur = q.poll();

            if(cur == brother) return true;
            else{
                if(set.add(cur-1) && cur-1>0){
                    from[cur-1] = cur;
                    q.add(cur-1);
                }
                if(set.add(cur+1) && cur+1<=100000){
                    from[cur+1] = cur;
                    q.add(cur+1);
                }
                if(set.add(cur*2) && cur*2<=100000){
                    from[cur*2] = cur;
                    q.add(cur*2);
                }
            }
        }
        return false;
    }
}

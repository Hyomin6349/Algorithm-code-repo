import java.util.*;

public class p16438 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        monkeys = new char[7][N];
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<N;i++) sb.append('A');

        make(0, N-1, 0);

        for(int i=0;i<7;i++){
            String str = new String(monkeys[i]);
            if(str.equals(sb.toString())){
                str = str.substring(1);
                str += "B";
            }
            System.out.println(str);
        }
    }

    static char[][] monkeys;
    static int cnt = 0;

    public static void make(int start, int end, int layer){
        if(layer==7){
            cnt++;
            return;
        }

        int mid = (start+end)/2;
        for(int i=start;i<=mid;i++) monkeys[layer][i] = 'A';
        for(int i=mid+1;i<=end;i++)  monkeys[layer][i] = 'B';
        make(start, mid, layer+1);
        make(mid+1, end, layer+1);

    }
}

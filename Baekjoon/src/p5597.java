import java.util.*;

public class p5597 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        HashSet<Integer> set = new HashSet<>();
        for(int i=1;i<=30;i++) set.add(i);

        for(int i=0;i<28;i++){
            int n = Integer.valueOf(input.nextLine());
            set.remove(n);
        }

        Iterator it = set.iterator();
        int a = (int)it.next();
        int b = (int)it.next();
        if(a>b) System.out.format("%d\n%d",b,a);
        else System.out.format("%d\n%d",a,b);
    }
}

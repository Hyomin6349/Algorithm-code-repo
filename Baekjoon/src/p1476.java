import java.util.*;

public class p1476 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int E = input.nextInt();
        int S = input.nextInt();
        int M = input.nextInt();
        int e=-1, s=-1, m=-1, year=0;
        while(true){
            year++;
            e = year % 15;
            if(e==0) e = 15;
            s = year % 28;
            if(s==0) s = 28;
            m = year % 19;
            if(m==0) m = 19;
            if(e==E && s==S && m==M) break;
        }
        System.out.println(year);
    }
}

import java.util.*;

public class p2609 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();

        int gcd = GCD(a,b);

        int lcm = gcd * (a/gcd) * (b/gcd);
        System.out.println(gcd);
        System.out.println(lcm);
    }

    public static int GCD(int a, int b){
        if(b==0) return a;
        else{
           return GCD(b, a%b);
        }
    }
}

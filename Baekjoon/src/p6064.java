import java.util.*;

public class p6064 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int tc = Integer.parseInt(input.nextLine());
        StringBuilder sb = new StringBuilder();
        while(tc-->0){
            int n = input.nextInt();
            int m = input.nextInt();
            int x = input.nextInt()-1;
            int y = input.nextInt()-1;
            int q = 0;
            int gcd = GCD(n,m);
            int lcm = gcd * (n/gcd) * (m/gcd);
            boolean impos = false;
            while((n*q+x)%m != y){
                q++;
                if((n*q+x)>lcm){
                    impos = true;
                    break;
                }
            }
            if(impos){
                sb.append("-1").append('\n');
            }
            else sb.append(n*q+x+1).append('\n');

            input.nextLine();
        }
        System.out.println(sb);
    }
    public static int GCD(int n, int m){
        if(m == 0) return n;
        return GCD(m, n%m);
    }
}

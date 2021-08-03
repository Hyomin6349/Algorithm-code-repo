import java.util.*;
import java.math.*;

public class p1914 {

    static StringBuilder sb = new StringBuilder();
    static int N;

    public static void hanoi(int n, int start, int temp, int dest) {
        if(n<1) return;

        hanoi(n-1, start, dest, temp);
        sb.append(start+" "+dest).append('\n');
        hanoi(n-1, temp, start, dest);
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        N = input.nextInt();

        BigInteger k = new BigInteger("2").pow(N).subtract(BigInteger.ONE);
        System.out.println(k);
        if(N<=20) {
            hanoi(N, 1,2,3);
            System.out.println(sb);
        }
    }

}

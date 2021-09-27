import java.util.*;

public class p9660 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        String answer = "SK";
        if(N%7==0 || N%7==2) answer = "CY";

        System.out.println(answer);
    }
}

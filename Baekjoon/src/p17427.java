import java.util.*;

public class p17427 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        long sum = 0;
        for(int i=1; i<=n ;i++){
            sum += i*(n/i);
        }
        System.out.println(sum);
    }
}

import java.util.*;

public class p10872 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        if(n==0) System.out.println(1);
        else{
            int ans = 1;
            while(n>1) ans *= n--;
            System.out.println(ans);
        }
    }
}

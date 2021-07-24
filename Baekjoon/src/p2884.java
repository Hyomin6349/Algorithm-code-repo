import java.util.*;

public class p2884 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int H = input.nextInt();
        int M = input.nextInt();

        if(M<45){
            M += 60;
            if(H==0) H = 24;
            H--;
        }
        M -= 45;

        System.out.println(H+" "+M);
    }
}

import java.util.*;

public class p2439 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();

        for(int i=1;i<=N;i++){
            for(int j=1;j<=N-i;j++){
                System.out.print(" ");
            }
            for(int j=N-i;j<N;j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}

import java.util.*;

public class p4375 {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        while(input.hasNextInt()){
            int n = input.nextInt();
            int pre=1;
            int cnt = 1;

            while( pre%n != 0){
                pre = (pre*10+1)%n;
                cnt ++;
            }
            System.out.println(cnt++);
        }

    }

}

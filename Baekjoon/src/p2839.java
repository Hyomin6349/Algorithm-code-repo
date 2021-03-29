import java.util.*;

public class p2839 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int answer =0;
        int quo = n/5;
        int left = n%5;

        if(quo>=1 && left==1) answer = quo - 1 + 2;
        else if(quo>=2 && left==2) answer = quo - 2 + 4;
        else if(left==3) answer = quo + 1;
        else if(quo>=1 && left==4) answer = quo - 1 + 3;
        else if(left==0) answer = quo;

        if(answer==0) answer = -1;



        System.out.println(answer);

    }
}

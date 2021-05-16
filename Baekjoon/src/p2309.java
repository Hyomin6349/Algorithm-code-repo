import java.util.*;

public class p2309 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int[] p = new int[9];
        int i = 0, sum =0;
        while(i<9){
            p[i] = Integer.parseInt(input.nextLine());
            sum += p[i];
            i++;
        }
        sum -= 100;
        Arrays.sort(p);
        int a=-1,b=-1;
        for(i=0;i<8;i++){
            for(int j=i+1;j<9;j++){
                if(p[i]+p[j] == sum){
                    a = i;
                    b = j;
                }
            }
        }

        for(i=0;i<9;i++){
            if(i!=a && i!=b){
                System.out.println(p[i]);
            }
        }

    }
}

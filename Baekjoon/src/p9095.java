import java.util.*;

public class p9095 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int tc = input.nextInt();

        int[] array = new int[11];

        array[0] = 0;
        array[1] = 1;
        array[2] = 2;
        array[3] = 4;
        for(int j = 4; j <= 10; j++) {
            array[j] = array[j - 1] + array[j - 2] + array[j - 3];
        }
        while(tc-->0){
            int n = input.nextInt();
            System.out.println(array[n]);
        }
    }
}

import java.util.*;

public class p20937 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int n = Integer.valueOf(input.nextLine());
        int[] bowl = new int[n];
        for(int i=0;i<n;i++) bowl[i] = input.nextInt();

        Arrays.sort(bowl);
        int count =1;
        int max=0;
        for(int i=1;i<n;i++){
            if(bowl[i-1]==bowl[i]) count++;
            else{
                if(max < count) max = count;
                count =0;
            }
        }
        System.out.println(max);
    }
}

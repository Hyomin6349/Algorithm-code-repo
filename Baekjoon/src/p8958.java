import java.util.*;

public class p8958 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int tc = Integer.parseInt(input.nextLine());
        while(tc-->0){
            char[] result = input.nextLine().toCharArray();
            int count = 1;
            int sum = 0;
            for(int i=0;i<result.length;i++){
                if(result[i]=='X'){
                    count = 1;
                }
                else{
                    sum += count;
                    count++;
                }
            }
            System.out.println(sum);
        }
    }
}

import java.util.*;

 class p1094 {
     public static void main(String[] args){
         Scanner input = new Scanner(System.in);
         int K = input.nextInt();

         int[] pows = {1,2,4,8,16,32,64};

         int temp = 0, answer = 0;

         for(int i=6;i>=0;i--){
             if(temp+pows[i] <= K){
                 temp+=pows[i];
                 answer++;
             }
             if(temp==K) break;
         }
         System.out.println(answer);
     }
}

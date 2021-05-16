import java.util.*;

public class p1978 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        boolean[] prime = new boolean[1001];
        prime[1] = true;
        for(int i=2;i<=500;i++){
            int j = i;
            while(j*i<=1000){
                prime[i*j] = true;
                j++;
            }
        }
        int answer = 0, idx=0;
        while(idx<n){
            int x = input.nextInt();
            if(!prime[x]) answer++;
            idx++;
        }
        System.out.println(answer);
    }
}

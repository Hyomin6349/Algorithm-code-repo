import java.util.*;

public class p2960 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int K = input.nextInt();
        boolean[] check = new boolean[N+1];
        int count = 0;

        for(int i=2;i<=N;i++){
            if(!check[i]){
                for(int j=i;j<=N;j+=i){
                    if(!check[j]){
                        count++;
                        check[j] = true;
                        if(count == K){
                            System.out.println(j);
                            System.exit(0);
                        }
                    }
                }
            }
        }
    }
}

import java.util.*;
import java.io.*;

public class p6588 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 1000000;
        boolean[] check = new boolean[N+1];
        ArrayList<Integer> prime = new ArrayList<>();
        check[0] = check[1] = true; //소수가 아님
        for(int i=2; i*i<=N ;i++){
            if(!check[i]){
                prime.add(i); //제외한 수 중 가장 작은 수
                for(int j=i*i; j<=N; j+=i) check[j] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        while(true){
            int x = Integer.parseInt(br.readLine());
            if(x==0) break;
            for(int i=1;i<prime.size();i++){    //prime.get(0) = 2
                int a = prime.get(i);
                int b = x - a;
                if(!check[b]){
                    sb.append(x+" = "+a+" + "+b+'\n');
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}

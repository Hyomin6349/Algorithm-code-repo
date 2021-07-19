import java.util.*;

public class p1644 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        ArrayList<Integer> primes = new ArrayList<>();
        boolean[] check = new boolean[4000001];

        check[0] = check[1] = true;
        for(int i=2;i<4000001;i++){
            if(!check[i]){
                primes.add(i);
                for(int j=i;j<4000001;j+=i){
                    check[j] = true;
                }
            }
        }

        //투 포인터, 시작, 끝 포인터가 0을 가리키게
        int start =0, end=0, sum=0, ans =0;
        for(;start<primes.size();start++){
            while(end<primes.size() && sum<N){
                sum += primes.get(end++); //합이 N보다 작으므로 end 인덱스 증가
            }
            if(sum==N) ans++;   //정답 찾음!
            sum -= primes.get(start);   //while문에 의해 sum이 N보다 커졌으므로 start 인덱스 증가
        }

        System.out.println(ans);
    }
}

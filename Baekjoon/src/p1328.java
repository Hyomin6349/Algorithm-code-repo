import java.util.*;

public class p1328 {

    static int D = 1000000007;
    static long[][] memo = new long[101][101]; //시간 초과 땜시

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int L = sc.nextInt();
        int R = sc.nextInt();

        if(L-1+R > N || L+R==2) {
            System.out.println(0);
            System.exit(0);
        }

        // (오른쪽, 왼쪽에 놓을 건물 선택) * (나머지 건물들 줄세우기) * (중간의 큰 건물들 자리 고르기)
        // (L+R-2 C R-1) * (N-R-L+1)! * (N-R-L+2 H R+L-3)
        // N-R-L+2 H R+L-3 = N-2 C R+L-3 => nHr = n+r-1Cr

        long res = comb(L+R-2, R-1) % D;
        //System.out.println(res + " " +(N-R-L+1));
        res = (res * fact(N-R-L+1)%D) % D;
        //System.out.println(comb(N-2, R+L-3));
        if(N-2>0 && R+L-3>=0) res = (res * comb(N-2, R+L-3)%D) % D;

        System.out.println(res);

    }

    public static long comb(int n, int r) {
        if(memo[n][r]!=0) return memo[n][r];
        if(n==r || r==0) {
            memo[n][r] = 1;
            return 1;
        }

        memo[n][r] = (comb(n-1, r-1)%D + comb(n-1, r)%D)%D;
        return memo[n][r];
    }

    public static long fact(int n) {
        if(n==1 || n==0) return 1;
        return (n*(fact(n-1)%D))%D; //1000000007
    }

}

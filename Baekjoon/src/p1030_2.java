import java.util.*;

public class p1030_2 {

    static int s, n, k, b1, b2;

    public static int find(int size, int r, int c){
       if(size==1) return 0;
       int side = size/n;
       if(side*b1 <= r && r < side*b2 && side*b1<=c && c<side*b2)
           return 1;
       return find(side, r%side, c%side);
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        s = input.nextInt();
        n = input.nextInt();
        k = input.nextInt();
        int r1 = input.nextInt();
        int r2 = input.nextInt();
        int c1 = input.nextInt();
        int c2 = input.nextInt();

        b1 = (n-k)/2;
        b2 = (n+k)/2;

        StringBuilder sb = new StringBuilder();

        for(int i=r1; i<=r2;i++){
            for(int j=c1;j<=c2;j++){
                sb.append(find((int)Math.pow(n,s), i, j));
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}

import java.util.*;

public class p1030 {
    static int s ,n ,k, k1, k2;
    static int pre[][], cur[][];

    public static void split(int sec){
        if(sec > s) return;
        pre = cur;

        cur = new int[(int)Math.pow(n,s)][(int)Math.pow(n,s)];

        for(int i=0;i<pre.length;i++){
            for(int j=0;j<pre.length;j++){
                if(pre[i][j] == 0) continue;
                draw(cur, i, j);
            }
        }
        split(sec+1);
    }

    public static void draw(int[][] cur, int r, int c){
        int s1 = r*n;
        int e1 = s1+n;
        int s2 = c*n;
        int e2 = s2+n;
        for(int i=s1 ; i<e1;i++){
            for(int j=s2;j<e2;j++){
                if(s1+k1<=i && i<s1+k2 && s2+k1<=j && j<s2+k2)
                    cur[i][j] = 0;
                else cur[i][j] = 1;
            }
        }
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

        k1 = (n-k)/2;
        k2 = (n+k)/2;

        cur = new int[1][1];
        cur[0][0] = 1;

        split(1);

        StringBuilder sb = new StringBuilder();
        for(int i=r1; i<=r2;i++){
            for(int j=c1;j<=c2;j++){
                if(cur[i][j] == 0)
                    sb.append(1);
                else sb.append(0);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }
}

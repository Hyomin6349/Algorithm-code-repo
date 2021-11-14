import java.util.*;

public class p10993 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        w = new int[11];
        h = new int[11];
        w[1] = h[1] = 1;
        for(int i=2;i<=N;i++){
            w[i] = 2*w[i-1] + 3;
            h[i] = 2*h[i-1] + 1;
        }



        paper = new char[h[N]][w[N]];
        for(int i=0;i<h[N];i++){
            Arrays.fill(paper[i], ' ');
        }
        int r = (N%2==0)?0:h[N]-1;
        int c = (N%2==0)?w[N]:w[N]/2+1;

        draw(N, r, w[N]/2);

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<h[N];i++){
            for(int j=0;j<c;j++) {
                sb.append(paper[i][j]);
                if(c<w[N]/2 || c>w[N]) break;
            }
            if(N%2==0) c--;
            else c++;
            if(i!=h[N]-1)sb.append('\n');
        }

        System.out.println(sb);
    }

    static int N;
    static int[] h,w;
    static char[][] paper;

    public static void draw(int size, int r, int c){
        if(size==0) return;

        int left, right;
        left = right = c;
        for(int j=0;j<=w[size]/2;j++){
            paper[r][left--] = '*';
            paper[r][right++] = '*';
        }

        if(size%2==1){
            for(int i=r; i>r-h[size]+1; i--){
                paper[i][++left] = '*';
                paper[i][--right] = '*';
            }

            paper[r-h[size]+1][c] = '*';
            draw(size-1, r-h[size]/2,c);
        }
        else {
            for(int i=r; i<r+h[size]-1; i++){
                paper[i][++left] = '*';
                paper[i][--right] = '*';
            }
            paper[r+h[size]-1][c] = '*';
            draw(size-1, r+h[size]/2,c);
        }

    }
}

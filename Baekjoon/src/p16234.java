import java.util.*;

public class p16234 {
    static int n,l,r;
    static int[][] A;
    static boolean[][] visit;
    static ArrayList<ArrayList<Country>> union;
    static boolean change = true;

    public static class Country{
        int r;
        int c;
        int p;
        public Country(int r, int c, int p){
            this.r = r;
            this.c = c;
            this.p = p;
        }
    }

    public static boolean open(int v1, int v2){
        int gap = Math.abs(v1-v2);
        if(l <= gap && gap <= r) return true;
        else return false;
    }

    public static void makeUnion(int idx, int r, int c, int root){
        if(root==1) union.get(idx).add(new Country(r,c, A[r][c]));
        visit[r][c] = true;

        if(r > 1 && open(A[r][c], A[r-1][c]) && !visit[r-1][c]){
            union.get(idx).add(new Country(r-1, c, A[r-1][c]));
            makeUnion(idx, r-1, c, 0);
        }
        if(r < n-1 && open(A[r][c], A[r+1][c]) && !visit[r+1][c]){
            union.get(idx).add(new Country(r+1, c, A[r+1][c]));
            makeUnion(idx, r+1, c, 0);
        }
        if(c > 1 && open(A[r][c], A[r][c-1]) && !visit[r][c-1]){
            union.get(idx).add(new Country(r, c-1, A[r][c-1]));
            makeUnion(idx, r, c-1, 0);
        }
        if(c < n-1 && open(A[r][c], A[r][c+1]) && !visit[r][c+1]){
            union.get(idx).add(new Country(r, c+1, A[r][c+1]));
            makeUnion(idx, r, c+1, 0);
        }

        if(root == 1) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visit[i][j]) {
                        union.add(new ArrayList<>());
                        makeUnion(idx + 1, i, j, 1);
                        return;
                    }
                }
            }
        }
    }

    public static void move(){
        for(int i=0;i<union.size();i++){
            if(union.get(i).size() < 2) continue;

            change = true;
            int sum = 0;
            for(Country country: union.get(i)){
                sum += country.p;
            }
            System.out.println(sum+" "+union.get(i).size());
            int avg = sum/union.get(i).size();
            for(Country country: union.get(i)){
                A[country.r][country.c] = avg;
            }
        }
    }

    public static void show(){
        System.out.println("================");
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(A[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println("================");
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        l = input.nextInt();
        r = input.nextInt();
        input.nextLine();
        A = new int[n][n];
        visit = new boolean[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                A[i][j] = input.nextInt();
            }
            input.nextLine();
        }

        int answer = -1;
        union = new ArrayList<>();
        union.add(new ArrayList<>());
        makeUnion(0, 0, 0, 1);
        while(change){
            change = false;
            move();
            show();
            answer++;
            union.clear();
            visit = new boolean[n][n];
            union.add(new ArrayList<>());
            makeUnion(0, 0, 0, 1);
        }

        System.out.println(answer);
    }
}

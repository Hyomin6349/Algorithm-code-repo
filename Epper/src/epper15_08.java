import java.io.*;
class epper15_08 {
    static int chess[] = new int[14];
    static int answer=0;

    public static boolean isPossible(int col){
        //search가 한 행에 하나의 체스말을 두기 때문에
        //열과 대각선에 체스말이 있는지 검사하면 됨

        for(int i=0;i<col; i++){
            if(chess[col] == chess[i]) return false;    //열조사

            if(Math.abs(chess[col]-chess[i]) == Math.abs(col-i)) return false; //대각선 조사
        }
        return true;
    }

    public static void solution(int n, int col, int k, int[] X, int[] Y) {
        if(col == n) answer++;
        else{
            for(int i=0; i<n; i++){
                // 체스말이 놓을 수 있는 곳의 위치에 있는지 확인한 후 둔다
                boolean okay = true;
                for(int j=0;j<k;j++){
                    if(col == X[j]-1 && i == Y[j]-1) okay=false;
                }
                if(okay){
                    chess[col] = i;//공격할 수 없는 위치인지 조사
                    if(isPossible(col))
                        solution(n, col+1, k ,X,Y);	//다음 행에 체스말을 넣는다
                }
            }
        }
    }

    //main은 다시 수정하지 않아도 됩니다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt((br.readLine()));
        int k = Integer.parseInt(br.readLine());

        String xs = br.readLine();
        String[] splitxs =  xs.split(", ");
        int X[] = new int[k];
        for(int i=0; i<k; i++){
            X[i] = Integer.parseInt(splitxs[i]);
        }

        String ys = br.readLine();
        String[] splitys =  ys.split(", ");
        int Y[] = new int[k];
        for(int i=0; i<k; i++){
            Y[i] = Integer.parseInt(splitys[i]);
        }

        solution(n,0,k,X,Y);
        System.out.println(answer);
    }


}
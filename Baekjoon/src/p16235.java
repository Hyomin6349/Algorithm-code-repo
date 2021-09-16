import java.util.*;
import java.io.*;

public class p16235 {

    public static class Tree implements Comparable<Tree>{
        int row, col, age;
        public Tree(int r, int c, int a){
            row = r; col = c; age = a;
        }
        public int compareTo(Tree o){
            return age-o.age;
        }
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 땅의 양분
        int[][] ground = new int[N][N];
        for(int i=0;i<N;i++) Arrays.fill(ground[i], 5);

        //로봇이 주는 양분 정보
        int[][] A = new int[N][N];
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //심은 나무의 정보
        PriorityQueue<Integer>[][] trees = new PriorityQueue[N][N];
        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                trees[i][j] = new PriorityQueue<>();
            }
        }
        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken())-1;
            int col = Integer.parseInt(st.nextToken())-1;
            int age = Integer.parseInt(st.nextToken());
            trees[row][col].add(age);
        }

        int[][] d = {{-1, -1, -1, 0, 0, 1, 1, 1}, {-1, 0, 1, -1, 1, -1, 0, 1}};
        int treeCnt = M;

        while(K-->0) {
            //봄
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    PriorityQueue<Integer> list = trees[i][j];
                    ArrayList<Integer> temp = new ArrayList<>();
                    int plus = 0;

                    while(!list.isEmpty()){
                        int age = list.poll();
                        ground[i][j] -= age;

                        if (ground[i][j] < 0) {
                            ground[i][j] += age;
                            plus += age/2;
                            treeCnt--;
                        }
                        else temp.add(age + 1);
                    }
                    for(int k=0;k< temp.size();k++) list.add(temp.get(k));
                    ground[i][j] += plus; //여름 양분
                }
            }

            //가을
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    PriorityQueue<Integer> list = trees[i][j];
                    Iterator<Integer> it = list.iterator();
                    while (it.hasNext()) {
                        if (it.next() % 5 == 0) {
                            for (int k = 0; k < 8; k++) {
                                int nr = i + d[0][k];
                                int nc = j + d[1][k];

                                if (0 <= nr && nr < N && 0 <= nc && nc < N) {
                                    trees[nr][nc].add(1);
                                    treeCnt++;
                                }
                            }
                        }
                    }

                    //겨울 양분 주기
                    ground[i][j] += A[i][j];
                }
            }
        }
        System.out.println(treeCnt);
    }
}

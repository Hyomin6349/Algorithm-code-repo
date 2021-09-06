import java.util.*;

//정확성 100
public class _2020_기둥과보설치 {

    static boolean[][] pillars;
    static boolean[][] pans;

    public static int[][] solution(int n, int[][] build_frame) {

        pillars = new boolean[n][n+1];
        pans = new boolean[n+1][n];

        for(int[] build : build_frame){
            int x = build[0];
            int y = build[1];
            if(build[2]==1){
                if(build[3]==1){ //x,y에 보설치
                    if(panBuild(n, x, y)) pans[y][x] = true;
                    else continue;
                }
                if(build[3]==0){ //x,y 의 보 삭제
                    pans[y][x] = false;
                    if(y<n && pillars[y][x] && !pillarBuild(n, x, y)) pans[y][x] = true;
                    if(y<n && x+1<=n && pillars[y][x+1] && !pillarBuild(n, x+1, y)) pans[y][x] = true;
                    if(0<x && pans[y][x-1] && !panBuild(n, x-1, y)) pans[y][x] = true;
                    if(x+1<n && pans[y][x+1] && !panBuild(n, x+1, y)) pans[y][x] = true;
                }
            }
            if(build[2]==0){
                if(build[3]==1){ // x,y에 기둥 설치
                    if(pillarBuild(n, x, y)) pillars[y][x] = true;
                    else continue;
                }
                if(build[3]==0){ //x,y의 기둥 삭제
                    pillars[y][x] = false;
                    if(y+1<n && pillars[y+1][x] && !pillarBuild(n, x, y+1)) pillars[y][x] = true;
                    if(x<n && pans[y+1][x] && !panBuild(n, x, y+1)) pillars[y][x] = true;
                    if(x>0 && pans[y+1][x-1] && !panBuild(n, x-1, y+1)) pillars[y][x] = true;
                }
            }
        }

        ArrayList<int[]> answerList = new ArrayList<>();

        for(int i=0;i<=n;i++){
            for(int j=0;j<=n;j++){
                if(i<n && pillars[i][j]) answerList.add(new int[]{j, i, 0});
                if(j<n && pans[i][j]) answerList.add(new int[]{j, i, 1});
            }
        }

        Collections.sort(answerList, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]==o2[0]){
                    if(o1[1]==o2[1]) return o1[2] - o2[2];
                    return o1[1] - o2[1];
                }
                return o1[0]-o2[0];
            }
        });

        int[][] answer = new int[answerList.size()][3];
        int idx = 0;
        for(int[] el: answerList){
            answer[idx++] = el;
        }

        return answer;
    }

    public static boolean panBuild(int n, int x, int y){
        System.out.println(x+" "+y);
        if(pillars[y-1][x+1] || pillars[y-1][x]) return true;
        else if(0<x && x+1<n && pans[y][x-1] && pans[y][x+1]) return true;
        else return false;
    }

    public static boolean pillarBuild(int n, int x, int y){
        if(y==0)  return true;
        else if(pillars[y-1][x]) return true; //기둥인 경우
        else if(pans[y][x]) return true; //보인경우
        else if(x-1>=0 && pans[y][x-1]) return true;
        else return false;
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] build_frames = {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},{2,1,1,1},{3,1,1,1},{2,0,0,0}, {1,1,1,0}, {2,2,0,1}};
        int[][] answer = solution(n, build_frames);
        for(int i=0;i<answer.length;i++){
            System.out.println(Arrays.toString(answer[i]));
        }
    }
}

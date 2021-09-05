import java.util.*;

//정확성 33.6
public class _2020_기둥과보설치 {

    public static  int[][] solution(int n, int[][] build_frame) {

        boolean[][] pillars = new boolean[n][n+1];
        boolean[][] pans = new boolean[n+1][n];

        for(int[] build : build_frame){
            int x = build[0];
            int y = build[1];
            if(build[2]==1){
                if(build[3]==1){ //x,y에 보설치
                    if(pillars[y-1][x+1] || pillars[y-1][x]) pans[y][x] = true; //한쪽 끝이 기둥이거나
                    else if(0<x && x+1<n && pans[y][x-1] && pans[y][x+1]) pans[y][x] = true; //양쪽이 보인 경우
                    else System.out.println(x+" "+y+" 보 설치 실패");
                    System.out.println(x+" "+y+" 보 설치 성공  "+pans[y][x]);
                }
                if(build[3]==0){ //x,y 의 보 삭제
                    if(0<x && pans[y][x-1] && !pillars[y-1][x-1]) continue;
                    else if(x+1<n && pans[y][x+1] && !pillars[y-1][x+1]) continue;
                    else if(y<n && pillars[y][x]){
                        if(!((0<x && pans[y][x-1]) || pillars[y-1][x])) continue;
                        if(!(pillars[y-1][x+1] || (x+1<n && pans[y][x+1]))) continue;
                    }
                    pans[y][x] = false;
                    System.out.println(x+" "+y+" 보 삭제 성공");
                }
            }
            if(build[2]==0){
                if(build[3]==1){ // x,y에 기둥 설치
                    if(y==0) pillars[y][x] = true; //바닥인 경우
                    else if(pillars[y-1][x]) pillars[y][x] = true; //기둥인 경우
                    else if(pans[y][x]) pillars[y][x] = true; //보인경우
                    else if(x-1>=0 && pans[y][x-1]) pillars[y][x] = true;
                    else System.out.println(x+" "+y+" 기둥 설치 실패");
                    System.out.println(x+" "+y+" 기둥 설치 성공  "+pillars[y][x]);
                }
                if(build[3]==0){ //x,y의 기둥 삭제
                    if(x<n && pans[y][x] && !pillars[y][x+1]) continue; //기둥 삭제 실패
                    else if(x-1>=0 && pans[y][x-1] && !pillars[y][x-1]) continue;
                    else if(y+1<n && pillars[y+1][x]){ //위에 기둥이 있는데
                        if(!((x<n && pans[y][x]) || (x-1>=0 && pans[y][x-1]))) continue; //받쳐주는 보가 없을 때
                    }
                    pillars[y][x] = false;
                    System.out.println(x+" "+y+" 기둥 삭제 성공");
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

    public static void main(String[] args) {
        int n = 5;
        int[][] build_frames = {{1,0,0,1},{1,1,1,1},{2,1,0,1},{2,2,1,1},{5,0,0,1},{5,1,0,1},{4,2,1,1},{3,2,1,1}};
        solution(n, build_frames);
    }
}

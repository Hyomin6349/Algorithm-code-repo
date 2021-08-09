import java.util.*;

//https://zoosso.tistory.com/155
public class p2571 {

    static int[][] map = new int[101][101];

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i=0;i<N;i++){
            int C = sc.nextInt();
            int R = sc.nextInt();
            for(int col=C;col<C+10;col++){
                for(int row=R;row<R+10;row++){
                    map[col][row] = 1;
                }
            }
        }

        //세로구간에 대한 누적합 구하기
        //map[col][row] = 영역의 높이를 담는 배열이 됨
        //사각형을 찾을 때: 기준점 보다 높은 높이로 갈 수 없음 ???
        for(int col=1;col<=100;col++){
            for(int row=1;row<=100;row++){
                //중간에 비어있을 수도 있어서
                if(map[col][row]!=0) map[col][row] += map[col-1][row];
            }
        }

        int max = 100;

        //모든 위치를 기준으로 우측으로 확장해가며 최대 사각형을 찾아본다
        for(int col=1;col<=100;col++){  //height
            for(int row=1;row<=100;row++){  //width
                int h = 100;
                for(int z=row; z<=100; z++){
                    h = Math.min(h, map[col][z]);   //기준점으로 가장 낮은 높이 구하기
                    max = Math.max(max, h*(z-row+1)); //높이 * 최대로 확장시켜서 구한 width
                }
            }
        }

        System.out.println(max);

    }

}

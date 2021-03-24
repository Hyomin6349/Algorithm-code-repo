/*분할정복 문제1
* 쿼드 트리 뒤집기
* 쿼드 트리를 이용해 압축된 흑백 그림을 상하로 뒤집어 출력하기
* */

import java.util.*;

public class DivideConquer1 {
    static int idx;

    public static String reverse(char[][] zip,int n){
        idx++; //왼쪽 위 구역부터 접근하여 idx 증가하게 됨
        if(zip[n][idx] == 'b' || zip[n][idx]=='w') return String.valueOf(zip[n][idx]);
        String upperLeft = reverse(zip, n);
        String upperRight = reverse(zip, n);
        String bottomLeft = reverse(zip, n);
        String bottomRight = reverse(zip, n);
        return "x"+ bottomLeft +bottomRight +upperLeft+upperRight;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        //입력
        int n = Integer.valueOf(input.nextLine());
        char[][] zip = new char[n][];
        for(int i=0;i<n;i++){
            String s = input.nextLine();
            zip[i] = new char[s.length()];
            for(int j=0; j<s.length();j++){
                zip[i][j] = s.charAt(j);
            }
        }

        for(int i=0;i<n;i++){
            idx = -1;
            System.out.println(reverse(zip,i));
        }


    }
}

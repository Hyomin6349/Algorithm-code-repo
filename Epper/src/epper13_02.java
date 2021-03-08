// 메인코드를 토대로 stair 함수를 작성하세요

import java.io.*;

class epper13_02 {
    public static int stair(int n){
        if(n==1) return 1;
        else if(n==2) return 2;
        else return stair(n-1)+stair(n-2);
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new 	InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        System.out.println("계단 오르는 방법의 수 : " + stair(n));
    }
}
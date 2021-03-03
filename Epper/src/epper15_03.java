import java.util.Scanner;

public class epper15_03{
    public static int solution(int n, int m){
        //이 아래 필요한 변수 및 필요한 코드를 작성하세요
        int answer=0;
        int left = n;
        int day = 1;

        while(left!=0){
            if(day%m != 0){
                left--;
            }
            day++;
        }

        answer = day-1;

        return answer;
    }


    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int m= scanner.nextInt();
        int answer=solution(n,m);

        System.out.println(answer);
    }

}
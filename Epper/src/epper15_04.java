import java.util.Scanner;

public class epper15_04 {
    public static int[] solution(int[] numbers) {
        int[] answer = new int[7];
        int sum = 0;
        int val = 0;

        for(int i=0; i<9; i++){
            sum += numbers[i];
        }

        val = sum - 100;    // 9개의 변수 중 2개의 변수의 합이 val이 되는 것을 찾는다
        int idx=0;

        for(int i=0; i<8; i++){
            for(int j=i+1; j<9; j++){
                int add = numbers[i] + numbers[j];
                if(add == val){ // 답은 항상 존재하고 유일하므로
                    for(int k=0; k<9; k++){
                        if(!(k==i || k==j)){
                            answer[idx++] = numbers[k];
                        }
                    }
                    return answer;
                }
            }
        }

        return answer;
    }

    public static void main(String [] args){
        int [] numbers=new int[9];
        int r[];
        Scanner input= new Scanner(System.in);

        for (int i = 0; i < 9; i++) {
            numbers[i]=input.nextInt();
        }

        r = solution(numbers);
        for (int i = 0; i < 7; i++) {
            System.out.printf("%d ", r[i]);
        }


    }
}
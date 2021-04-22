import java.util.*;

public class p14888 {

    static int N;
    static int MIN = Integer.MAX_VALUE;
    static int MAX = Integer.MIN_VALUE;
    static int[] number, operator, expression, select;

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        N = input.nextInt();
        number = new int[N];
        operator = new int[4];
        expression = new int[N-1];
        select = new int[4];

        for(int i=0;i<N;i++) number[i] = input.nextInt();
        input.nextLine();
        for(int i=0;i<4;i++) operator[i] = input.nextInt();

        solution(0);
        System.out.println(MAX);
        System.out.println(MIN);

    }

    public static void solution(int num){
        if(num==N-1){
            calculate();
            return;
        }

        for(int i=0;i<4;i++){
            select[i]++;
            boolean check = true;
            for(int j=0;j<4;j++){
                if(operator[j] < select[j])
                    check = false;
            }
            if(check) {
                expression[num] = i;
                solution(num+1);
            }
            select[i]--;
        }
    }

    public static void calculate(){
        int val = number[0];
        for(int i=0; i<N-1;i++){
            switch(expression[i]){
                case 0:
                    val += number[i+1];
                    break;
                case 1:
                    val -= number[i+1];
                    break;
                case 2:
                    val *= number[i+1];
                    break;
                case 3:
                    val /= number[i+1];
                    break;
            }
        }

        if(MAX<val) MAX = val;
        if(MIN>val) MIN = val;
    }
}

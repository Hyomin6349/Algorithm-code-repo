import java.util.*;

class epper12_02 {
    public static void main(String[] args)  {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt() -1;

        int room_n = num/15 + 1;//방 번호
        int in_n = num%15+1; //방 안에서의 번호
        System.out.format("%d %d",room_n, in_n);
    }
}
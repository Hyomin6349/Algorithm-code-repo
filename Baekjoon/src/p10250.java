import java.util.*;

public class p10250 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int tc = input.nextInt();
        while(tc-->0){
            int h = input.nextInt();
            int w = input.nextInt();
            int n = input.nextInt();

            int floor = n%h;
            int room = n/h+1;
            if(floor == 0){
                floor = h;
                room--;
            }

            if(room<10) System.out.println(String.valueOf(floor)+"0"+String.valueOf(room));
            else System.out.println(String.valueOf(floor)+String.valueOf(room));

            input.nextLine();
        }
    }
}

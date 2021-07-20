import java.util.*;

public class p1100 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        char[][] map = new char[8][8];
        int answer = 0;

        for(int i=0;i<8;i++){
            String line = input.nextLine();
            map[i] = line.toCharArray();
            for(int j=0;j<8;j++){
                if(map[i][j]=='F' && (i+j)%2==0) answer ++;
            }
        }

        System.out.println(answer);
    }
}

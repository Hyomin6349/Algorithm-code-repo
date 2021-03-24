import java.util.*;

public class sm3 {
    public static class Pinut implements Comparable<Pinut>{
        int dir; //0:right, 1:left
        int dis;
        public Pinut(int dir, int dis){
            this.dir = dir;
            this.dis = dis;
        }
        @Override
        public int compareTo(Pinut o){
            return dis - o.dis;
        }
    }
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        int e = input.nextInt();
        input.nextLine();
        Pinut pinuts[] = new Pinut[n];

        for(int i=0;i<n;i++){
            int val = input.nextInt();
            int dir = val-e > 0 ? 0 :1;
            int dis = Math.abs(val-e);
            pinuts[i] = new Pinut(dir, dis);
        }

        Arrays.sort(pinuts);
        int dir = pinuts[m-1].dir;
        int dis = pinuts[m-1].dis;
        int i=0;
        while(pinuts[i].dir == dir && i<n) i++;

        System.out.println(Math.abs(dis) + Math.abs(pinuts[i].dis));
    }
}

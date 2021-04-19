import java.util.*;
import java.io.*;

public class p15686 {
    public static class Point{
        int x;
        int y;

        public Point(int x, int y){
          this.x = x;
          this.y = y;
        }
    }

    static int m, answer = Integer.MAX_VALUE;
    static ArrayList<Point> chicken;
    static ArrayList<Point> house;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        chicken = new ArrayList<>();
        house = new ArrayList<>();


        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int j=0;
            while(st.hasMoreTokens()){
                int p = Integer.parseInt(st.nextToken());
                if(p==1) house.add(new Point(i,j));
                if(p==2) chicken.add(new Point(i,j));
                j++;
            }
        }

        select(0,0);
        System.out.println(answer);
    }

    static Stack<Point> select = new Stack<>();

    public static void select(int start, int count){
        if(count == m){
            calcDist();
            return;
        }

        for(int i=start; i<chicken.size();i++){
            select.push(chicken.get(i));
            select(i+1, count+1);
            select.pop();
        }
    }

    public static void calcDist(){
        int sum = 0;
        for(Point h: house){
            int min = Integer.MAX_VALUE;
            for(Point c: select){
                int dis = Math.abs(h.x-c.x)+Math.abs(h.y-c.y);
                if(dis < min) min = dis;
            }
            sum += min;
            if(sum>answer) return;
        }
        if(sum < answer) answer = sum;
    }
}

import java.util.*;

public class p4386 {

    public static class Star implements Comparable<Star>{
        int idx;
        double dist;
        public Star (int i, double d){
            idx = i; dist = d;
        }
        public int compareTo(Star o){
            if(dist>o.dist) return 1;
            else return -1;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        double[][] stars = new double[n][2];
        for(int i=0;i<n;i++){
            stars[i][0] = input.nextDouble();
            stars[i][1] = input.nextDouble();
        }

        double[][] dist = new double[n][n];
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                dist[i][j] = dist[j][i] = getDist(stars[i], stars[j]);
            }
        }

        PriorityQueue<Star> pq = new PriorityQueue<>();
        boolean[] visit = new boolean[n];
        pq.add(new Star(0, 0.0));
        double answer = 0.0;
        int cnt = 0;

        while(!pq.isEmpty()){
            Star cur = pq.poll();
            if(visit[cur.idx]) continue;

            visit[cur.idx] = true;
            answer += cur.dist;
            cnt ++;
            if(cnt==n) break;

            for(int i=0;i<n;i++){
                if(!visit[i]) pq.add(new Star(i, dist[cur.idx][i]));
            }

        }
        System.out.println(answer);
    }

    public static double getDist(double[] s1, double[] s2){
        double width = Math.abs(s1[0]-s2[0]);
        double height = Math.abs(s1[1]-s2[1]);
        return Math.sqrt((width*width) + (height*height));
    }
}

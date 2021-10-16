import java.util.*;

public class p17140 {
    public static class Node implements Comparable<Node>{
        int val;
        int cnt;

        public Node(int v, int c){
            val = v; cnt = c;
        }

        public int compareTo(Node o){
            if(cnt==o.cnt) return val-o.val;
            else return cnt - o.cnt;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt()-1;
        int c = sc.nextInt()-1;
        int k = sc.nextInt();

        int[][] A = new int[200][200];
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++) A[i][j] = sc.nextInt();
        }

        int n = 3, m = 3;
        int time = -1;
        while(++time<=100){
            if(A[r][c] == k) break;

            if(n>=m){
                int maxN = 0;

                for(int i=0;i<n;i++){
                    int[] num = new int[101];
                    for(int j=0;j<m;j++){
                        num[A[i][j]]++;
                        A[i][j] = 0;
                    }

                    PriorityQueue<Node> pq = new PriorityQueue<>();
                    for(int j=1;j<=100;j++){
                        if(num[j]!=0){
                            pq.add(new Node(j, num[j]));
                        }
                    }

                    int idx = 0;
                    while(!pq.isEmpty()){
                        Node node = pq.poll();
                        A[i][idx++] = node.val;
                        A[i][idx++] = node.cnt;
                    }
                    if(maxN < idx) maxN = idx;
                }

                m = maxN;
            }
            else{
                int maxM = 0;

                for(int i=0;i<m;i++){
                    int[] num = new int[101];
                    for(int j=0;j<n;j++){
                        num[A[j][i]]++;
                        A[j][i] = 0;
                    }


                    PriorityQueue<Node> pq = new PriorityQueue<>();
                    for(int j=1;j<=100;j++){
                        if(num[j]!=0){
                            pq.add(new Node(j, num[j]));
                        }
                    }

                    int idx = 0;
                    while(!pq.isEmpty()){
                        Node node = pq.poll();
                        A[idx++][i] = node.val;
                        A[idx++][i] = node.cnt;
                    }
                    if(maxM < idx) maxM = idx;
                }

                n = maxM;
            }
        }

        if(time==101) System.out.println(-1);
        else System.out.println(time);
    }
}

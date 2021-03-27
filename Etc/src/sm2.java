import java.util.*;
import java.io.*;

public class sm2 {
    public static class Customer implements Comparable<Customer>{
        int com;
        int time;
        public Customer(int c, int t){
            com = c;
            time = t;
        }
        @Override
        public int compareTo(Customer o){
            if(com == o.com) return time-o.time;
            return com-o.com;
        }
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        ArrayList<Customer> customers = new ArrayList<>();
        int computers[][] = new int[p+1][h+1];

        while(n-->0){
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            customers.add(new Customer(c, t));
        }

        Collections.sort(customers);

        for(int i=1; i<=h;i++){

        }

        for(int i=1; i<=p;i++){
            System.out.format("%d %d\n", i, computers[i][h]);
        }
    }
}

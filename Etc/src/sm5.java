import java.util.*;
import java.io.*;

public class sm5 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> time = new HashMap<>();
        int score = 0;

        for(int i=0; i<Math.pow(n,2); i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            while(k-->0){
                int t = Integer.parseInt(st.nextToken());
                if(time.containsKey(t) && time.get(t) < s) time.replace(t,s);
                if(!time.containsKey(t)) time.put(t, s);
            }
        }

        for(int key: time.keySet()) score+=time.get(key);

        System.out.println(score);
    }
}

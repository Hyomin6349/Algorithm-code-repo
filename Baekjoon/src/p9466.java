import java.util.*;
import java.io.*;

/* 시간 초과로 에러.. */
public class p9466 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            int n = Integer.parseInt(br.readLine());
            int[] s = new int[n+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            int i=1;
            while(st.hasMoreTokens()){
                s[i]= Integer.parseInt(st.nextToken());
                i++;
            }
            sb.append(answer(s)).append('\n');
        }
        System.out.println(sb);
    }

    public static int answer(int[] s){
        int all = s.length-1;
        boolean[] check = new boolean[s.length];
        ArrayList<Integer> list = new ArrayList<>();
        int i =0;

        while(i<s.length-1 && !check[i]){
            int dst = i;
            list.add(dst);
            check[dst] = true;
            while(!check[s[dst]] && !list.contains(s[dst])){    //contains O(n)
                list.add(s[dst]);
                check[s[dst]] = true;
                dst = s[dst];
            }
            if(list.contains(s[dst])) {
                all -= list.size() - list.indexOf(s[dst]);  //indexOf O(n)
            }
            i++;
            list.clear();
        }
        return all;
    }

}

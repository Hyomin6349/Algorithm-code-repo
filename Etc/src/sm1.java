import java.util.*;
import java.io.*;

public class sm1 {
    public static int idx(String s){
        for(int i=0; i< skills.length; i++){
            if(skills[i].equals(s)) return i;
        }
        return -1;
    }

    public static void dfs(){
    }

    static String[] skills;
    static ArrayList<Integer> relation[];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        skills = input.split(" ");
        relation = new ArrayList[skills.length];
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<skills.length ;i++) relation[i] = new ArrayList<>();

        while(n-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String p = st.nextToken();
            String l = st.nextToken();
            relation[idx(l)].add(idx(p));
        }

        dfs();
    }
}

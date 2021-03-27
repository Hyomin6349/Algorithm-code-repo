import java.util.*;
import java.io.*;

public class sm1 {
    public static int idx(String s){
        for(int i=0; i< skills.length; i++){
            if(skills[i].equals(s)) return i;
        }
        return -1;
    }

    public static void dfs(int node){
        stack.push(skills[node]);
        if(relation[node].size() == 0){
            for(int i=0;i<stack.size();i++) System.out.print(stack.get(i)+" ");
            System.out.println();
        }
        else{
            for(int i=0;i<relation[node].size();i++) dfs(relation[node].get(i));
        }
        stack.pop();
    }

    static Stack stack = new Stack();
    static ArrayList<Integer> list = new ArrayList<>(); //root 찾기 위함
    static String[] skills;
    static ArrayList<Integer> relation[];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        skills = input.split(" ");
        for(int i=0;i<skills.length;i++) list.add(i);

        relation = new ArrayList[skills.length];
        int n = Integer.parseInt(br.readLine());
        for(int i=0;i<skills.length ;i++) relation[i] = new ArrayList<>();

        while(n-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String p = st.nextToken();
            String l = st.nextToken();
            relation[idx(p)].add(idx(l));

            if(list.contains(idx(l))) list.remove(Integer.valueOf(idx(l)));
        }

        for(int i=0;i<list.size();i++) dfs(list.get(i));

    }
}

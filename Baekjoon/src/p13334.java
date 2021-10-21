import java.util.*;
import java.io.*;

public class p13334 {
    public static class Group{
        int cnt, left, right;
        public Group(int c, int l, int r){
            cnt = c; left = l; right = r;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] info = new int[N][2];

        for(int i=0;i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            info[i][0] = Math.min(a,b);
            info[i][1] = Math.max(a,b);
        }

        int d = Integer.parseInt(br.readLine());
        ArrayList<Group> list = new ArrayList<>();
        for(int i=0;i<N;i++){
            if(info[i][1]-info[i][0]>d) continue;
            boolean find = false;
            for(int j=0;j<list.size();j++){
                Group group = list.get(j);
                if(group.left<=info[i][0] && info[i][1]<=group.right){
                    group.cnt++;
                    find = true;
                }
                if(group.left<=info[i][0] && group.right < info[i][1] && info[i][1]-group.left<=d){
                    group.right = info[i][1];
                    group.cnt++;
                    find = true;
                }
                if(info[i][0]<group.left && info[i][1]<=group.right && group.right-info[i][0]<=d){
                    group.left = info[i][0];
                    group.cnt++;
                    find = true;
                }
                if(info[i][0]<group.left && group.right<info[i][0]){
                    group.left = info[i][0];
                    group.right = info[i][1];
                    group.cnt++;
                    find = true;
                }
            }
            if(!find) list.add(new Group(1, info[i][0], info[i][1]));
        }

        int answer = 0;
        for(int i=0;i<list.size();i++){
            answer = Math.max(answer, list.get(i).cnt);
        }

        System.out.println(answer);
    }
}

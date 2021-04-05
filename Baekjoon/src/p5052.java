import java.util.*;

public class p5052 {
    static Node root = new Node();
    static boolean reasonable;

    public static class Node{
        Node next[] = new Node[10];
    }

    public static void insert(String s){
        char[] arr = s.toCharArray();
        Node cur = root;

        for(int i = 0 ;i<arr.length;i++){
            int val = (int)arr[i]-'0';
            if(cur.next[val] == null) cur.next[val] = new Node();
            else cur = cur.next[val];
        }
        for(int i=0;i<10;i++){
            if(cur.next[i]!=null) reasonable = false;
        }
    }



    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int t = Integer.parseInt(input.nextLine());
        while(t-->0){
            int n = Integer.parseInt(input.nextLine());
            root = new Node();
            reasonable = true;
            for(int i=0;i<n;i++){
                if(reasonable)insert(input.nextLine());
            }
            if(reasonable) System.out.println("YES");
            else System.out.println("NO");
        }
    }
}

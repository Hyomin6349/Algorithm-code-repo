import java.util.*;

public class p16916 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] s = sc.nextLine().toCharArray();
        char[] p = sc.nextLine().toCharArray();

        int[] pi = new int[p.length];

        for(int i=1,j=0; i<p.length;i++){
            while(j>0 && p[i]!=p[j]) j = pi[j-1];
            if(p[i] == p[j]) pi[i] = ++j;
            else pi[i] = 0;
        }

        for(int i=0,j=0 ;i<s.length;i++){
            while(j>0 && s[i]!=p[j]) j = pi[j-1];
            if(s[i]==p[j]){
                if(j== p.length-1){
                    System.out.println(1);
                    System.exit(0);
                } else j++;
            }
        }

        System.out.println(0);
    }
}

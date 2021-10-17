import java.util.*;

public class p16172 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] s = sc.nextLine().toCharArray();
        char[] k = sc.nextLine().toCharArray();

        int[] pi = new int[k.length];
        for(int i=1, j=0;i<k.length;i++){
            while(j>0 && k[i]!=k[j]) j = pi[j-1];
            if(k[i]==k[j]) pi[i] = ++j;
            else pi[i] = 0;
        }

        for(int i=0,j=0; i<s.length; i++){
            if(isNum(s[i])) continue;
            while(j>0 && s[i]!=k[j]) j = pi[j-1];

            if(s[i]==k[j]){
                if(j==k.length-1){
                    System.out.println(1);
                    System.exit(0);
                }
                else j++;
            }
        }


        System.out.println(0);
    }

    public static boolean isNum(char c){
        int i = c - '0';
        if(0<=i && i<=9) return true;
        else return false;
    }
}

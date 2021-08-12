import java.util.*;

public class p15927 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int n = str.length();

        int left = n/2+n%2-1, right = n/2;
        boolean palindrome = true;
        while(0<=left && right <n) {
            if(str.charAt(left--)!=str.charAt(right++)) {
                palindrome = false;
                break;
            }
        }
        if(!palindrome) System.out.println(n);
        else {
            boolean oneChar = true;
            for(int i=1;i<n;i++){
                if(str.charAt(0)!=str.charAt(i)){
                    oneChar = false;
                    break;
                }
            }
            if(oneChar) System.out.println(-1);
            else System.out.println(n-1);
        }
    }

}

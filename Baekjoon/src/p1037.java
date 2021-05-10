import java.util.*;

public class p1037 {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.nextLine();
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(input.nextLine());
        for(int i=0;i<n;i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        System.out.println(arr[0]*arr[n-1]);

    }
}

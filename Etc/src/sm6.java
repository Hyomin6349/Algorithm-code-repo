import java.util.*;

public class sm6 {

    public static void find(int start, int size){
        int max1=0, max2=0, idx1=0, idx2=0;
        if(size == 0) return;
        if(size == 2){
            answer += arr[start] > arr[start+1] ? arr[start] : arr[start+1];
        }
        else{
            int mid = start+size/2;
            for(int i= start;i<mid;i++){
                if(max1<arr[i]){
                    max1 = arr[i];
                    idx1 = i;
                }
            }
            for(int i=mid; i< start+size;i++){
                if(max2<arr[i]){
                    max2 = arr[i];
                    idx2 = i;
                }
            }
            if(max1 > max2){
                answer += max1;
                start = idx2 >= mid+size/4 ? mid+size/4:mid;
            }else{
                answer += max2;
                start = idx1 >= start+size/4 ? start+size/4: start;
            }
            find(start, size/4);
        }
    }

    static int arr[];
    static int answer=0;

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = Integer.parseInt(input.nextLine());
        arr = new int[n];

        for(int i=0;i<n;i++) arr[i] = input.nextInt();
        find(0, n);
        System.out.println(answer);
    }
}

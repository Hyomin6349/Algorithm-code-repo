import java.util.*;

public class p2981 {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int N = input.nextInt();
        int[] arr = new int[N];

        for(int i=0;i<N;i++) arr[i] = input.nextInt();
        Arrays.sort(arr);
        int val = arr[0];

        for(int i=0; i<N; i++){
            arr[i] -= val;
        }


        for(int i=arr[1];i>1;i--){
            boolean find = true;
            for(int j=1;j<N;j++){
                if(arr[j]%i!=0){
                    find = false;
                    break;
                }
            }
            if(find) get(i);
        }
    }

    public static void get(int num){
        ArrayList<Integer> list = new ArrayList<>();
        int p = 0;
        list.add(num);

        for(int i=2;i<=Math.sqrt(num);i++){
            if(num%i==0){
                list.add(p, num/i);
                if(num/i != i)list.add(p, i);
                p++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0;i<list.size();i++) sb.append(list.get(i)+" ");
        System.out.println(sb);
        System.exit(0);
    }
}

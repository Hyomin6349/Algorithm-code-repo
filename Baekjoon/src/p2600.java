import java.util.*;

//72% 틀렸습니다
public class p2600 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int b1 = sc.nextInt();
        int b2 = sc.nextInt();
        int b3 = sc.nextInt();

        int[] res = new int[501];

        res[b1] = b1;
        res[b2] = b2;
        res[b3] = b3;

        int[] arr = new int[501];
        Arrays.fill(arr,-1);
        arr[b1] = 0;

        for(int i=b1+1;i<=500;i++){

            if(res[i-b1]==0) {
                res[i] = b1;
            }
            if(i > b2 && res[i-b2]==0){
                res[i] = b2;
                if(arr[i-b2]==0) arr[i] = b2;
            }
            if(i > b3 && res[i-b3]==0){
                res[i] = b3;
                if(arr[i-b3]==0) arr[i] = b3;
            }

            if(res[i]!=0){
                arr[i] = 0;
                if(arr[i-b1]==0) arr[i] = b1;
                if(i>b2 && arr[i-b2]==0) arr[i] = b2;
                if(i>b3 && arr[i-b3]==0) arr[i] = b3;
            }
        }


        for(int i=0;i<5;i++){
            int k1 = sc.nextInt();
            int k2 = sc.nextInt();
            boolean order = true; //true:A 순서, false: B순서

            while(true){
                if(res[k1]==0 && res[k2]==0) break;
                else {
                    if(res[k1]!=0 && res[k2]!=0){
                        if(arr[k1]!=0) k1 -= arr[k1];
                        else if(arr[k2]!=0) k2 -= arr[k2];
                        else break;
                    }
                    else if(res[k1]!=0) k1 -= res[k1];
                    else k2-=res[k2];
                    order = !order;
                }
            }

            System.out.println(order?'B':'A');
        }
    }
}

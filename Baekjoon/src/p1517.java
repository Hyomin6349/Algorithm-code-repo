import java.util.*;

public class p1517 {
    static long[] sorted,A;
    static int answer = 0;

    public static void mergeSort(int low, int high){
        if(low!=high){
            int mid = (low+high)/2;
            mergeSort( low, mid);
            mergeSort(mid+1, high);
            merge(low, mid, high);
        }
    }

    public static void merge(int low, int mid, int high){
        int i = low;
        int j = mid +1;
        int idx = low;

        while(i<=mid && j<=high){
            if(A[i]<=A[j]){
                sorted[idx++] = A[i++];
            }
            else{
                //교환이 일어나는 곳
                sorted[idx++] = A[j++];
                answer += mid+1-i; //왼쪽 배열에 남아있는 원소만큼 스왑일어남
            }
        }

        //남은 배열 sorted에 넣기
        if(i<mid){
            while(i<=mid){
                sorted[idx++] = A[i++];
            }
        }
        else{
            while(j<=high){
                sorted[idx++] = A[j++];
            }
        }

        //배열 교체
        for(int k = low; k<= high; k++) A[k] = sorted[k];
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int n = Integer.valueOf(input.nextLine());
        A = new long[n];
        sorted = new long[n];
        for(int i=0; i<n;i++) A[i] = input.nextLong();
        mergeSort(0, n-1);
        System.out.println(answer);
    }
}

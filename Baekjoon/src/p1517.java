import java.util.*;

public class p1517 {
    static int[] sorted;
    static int answer = 0;

    public static void mergeSort(int[] A, int low, int high){
        if(low<high){
            int mid = (low+high)/2;
            mergeSort(A, low, mid);
            mergeSort(A,mid+1, high);
            merge(A, low, mid, high);
        }
    }

    public static void merge(int[] A, int low, int mid, int high){
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
        while(i<=mid){
            sorted[idx++] = A[i++];
        }
        while(j<=high){
            sorted[idx++] = A[j++];
        }

        //배열 교체
        for(int k = low; k<= high; k++) A[k] = sorted[k];
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int n = Integer.valueOf(input.nextLine());
        int[] A = new int[n];
        sorted = new int[n];
        for(int i=0; i<n;i++) A[i] = input.nextInt();
        mergeSort(A,0, n-1);
        System.out.println(answer);
    }
}

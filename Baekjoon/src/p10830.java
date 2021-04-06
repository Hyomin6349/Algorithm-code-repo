import java.util.*;

public class p10830 {

    static int unitMatrix[][], n;


    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        n = input.nextInt();
        long b = input.nextLong();
        input.nextLine();
        int matrix[][] = new int[n][n];
        unitMatrix = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j] = input.nextInt();
            }
            input.nextLine();
        }

        for(int i=0;i<n;i++) unitMatrix[i][i] = 1;

        matrix = pow(b, matrix);

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static int[][] pow(long b, int[][] matrix){
        if(b==0) return unitMatrix;
        if(b==1) return matrix;

        int[][] nMatrix = pow(b/2, matrix);
        nMatrix = mul(nMatrix, nMatrix);

        return b%2==0 ? nMatrix : mul(nMatrix, matrix);
    }

    public static int[][] mul(int[][] a, int[][] b){
        int[][] matrix = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++)
                    matrix[i][j] += (a[i][k] * b[k][j]) % 1000;
                matrix[i][j] %= 1000;
            }
        }
        return matrix;
    }
}

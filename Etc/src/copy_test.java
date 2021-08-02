public class copy_test {
    public static void main(String[] args){
        int[][] a = {{1,2,3}, {4,5,6}, {7,8,9}};
        int[][] b = new int[3][3];

        for(int i=0;i<3;i++){
            b[i] = a[i].clone();
        }

        b[0][2] = 9;

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
    }
}

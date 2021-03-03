import java.util.*;

public class dynamic1 {
    static int solution(int N, int number) {
        int answer = -1;

        ArrayList<Integer> list=new ArrayList<>();
        String temp="";
        String n=Integer.toString(N);
        int[] index=new int[9];


        for(int i=1;i<=8;i++) {
            for(int j=i-1;j>=i/2 && i>1 ;j--) {
                for(int k=index[j-1]+1;k<=index[j];k++) {
                    System.out.println(k);
                    int op1=list.get(k);
                    for(int m=1;m<=i/2;m++) {
                        for(int x=index[m-1]+1;x<=index[m];x++) {
                            int op2=list.get(x);

                            if(!list.contains(op1+op2))list.add(op1+op2);
                            if(!list.contains(op1*op2))list.add(op1*op2);
                            if(op2!=0 && !list.contains(op1/op2))list.add(op1/op2);
                            if(op1!=0 && !list.contains(op2/op1))list.add(op2/op1);
                        }
                    }
                }
            }

            temp+=n;
            list.add(Integer.parseInt(temp));
            index[i]=list.size()-1;	//i개로 만들수 있는 수의 마지막 인덱스 저장
            System.out.println(list);
            if(list.contains(number)) return answer=i;
        }


        return answer;
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int N=5;
        int number=12;
        System.out.println(solution(N,number));
    }

}

import java.util.*;

public class p20936 {
    public static class Cal implements Comparable<Cal>{
        Long val;
        int idx;

        public Cal(long val, int idx){
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Cal o){
            if(val > o.val) return 1;
            else return 0;
        }
    }

    public static long calculate(long a, long b ,char op){
        long result=0;
        switch(op){
            case '+':
                result= a+b;
                break;
            case '-':
                result = a-b;
                break;
            case '*':
                result = a*b;
                break;
            case '/':
                result = a/b;
                break;
        }
        return result;
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        String s = input.nextLine();
        String operations = "*/+-";
        ArrayList<Long> num = new ArrayList<>();
        ArrayList<Character> op = new ArrayList<>();

        int i=0;
        while(i<s.length()){
            String temp = "";
            while(!operations.contains(String.valueOf(s.charAt(i)))){
                temp += s.charAt(i++);
                if(i>=s.length()) break;
            }
            num.add(Long.valueOf(temp));
            if(i<s.length())op.add(s.charAt(i++));
        }

        PriorityQueue<Cal> pq = new PriorityQueue<>();
        for(i=0;i<op.size();i++){
            long val = calculate(num.get(i), num.get(i+1), op.get(i));
            pq.add(new Cal(val, i));
        }

        while(pq.size() >1){
            long max = 0;
            int idx = -1;
            for(i=0;i<op.size();i++){
                long val = calculate(num.get(i), num.get(i+1), op.get(i));
                if(val > max){
                    max = val;
                    idx = i;
                }
            }
            num.remove(idx);
            num.remove(idx);
            num.add(idx, max);
            op.remove(idx);
        }

        System.out.println(pq.poll().val);
    }
}

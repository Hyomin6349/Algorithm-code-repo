import java.util.*;

public class p1339 {
    public static class Word implements Comparable<Word>{
        char c;
        int weight;
        public Word(char c, int w){
            this.c=c;
            weight = w;
        }
        @Override
        public int compareTo(Word o){
            return o.weight-weight;
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        int n = Integer.valueOf(input.nextLine());
        ArrayList<Word> arr = new ArrayList<>();
        String check ="";   //중복체크위함

        for(int i=0; i<n;i++){
            String s = input.nextLine();
            for(int j=0;j<s.length();j++){
                char c = s.charAt(j);
                int w = (int)Math.pow(10, s.length()-j-1);
                if(check.indexOf(c)==-1){ //arr에 포함되지않았다면
                    check += c;
                    arr.add(new Word(c,w));
                }
                else{
                    Word word = arr.get(check.indexOf(c));
                    word.weight += w;
                    arr.set(check.indexOf(c), word);
                }
            }
        }

        Collections.sort(arr);  //weight 기준으로 내림차순
        int value = 9;
        int sum = 0;

        for(int i=0;i<arr.size();i++){
            Word word = arr.get(i);
            sum += word.weight * value;
            value--;
        }

        System.out.println(sum);
    }
}

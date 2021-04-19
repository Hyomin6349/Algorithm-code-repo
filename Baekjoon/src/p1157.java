import java.util.*;

public class p1157 {
    public static class Element implements Comparable<Element>{
        char letter;
        int count;

        public Element(char l, int c){
            letter = l;
            count = c;
        }

        @Override
        public int compareTo(Element o){
            return o.count - count;
        }
    }

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        char[] word= input.nextLine().toUpperCase().toCharArray();
        Arrays.sort(word);
        ArrayList<Element> list = new ArrayList<>();
        int count=1;

        for(int i=1; i<word.length; i++){
            if(word[i] != word[i-1]){
                list.add(new Element(word[i-1], count));
                count = 0;
            }
            count ++;
        }
        list.add(new Element(word[word.length-1],count));
        Collections.sort(list);

        if(list.size()>1 && list.get(0).count == list.get(1).count)
            System.out.println('?');
        else System.out.println(list.get(0).letter);

    }
}

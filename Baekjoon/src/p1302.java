import java.util.*;
import java.io.*;

public class p1302 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0;i<N;i++){
            String book = br.readLine();
            if(map.containsKey(book)){
                int val = map.get(book);
                map.put(book, val+1);
            }
            else map.put(book, 1);
        }

        int max = 0;
        String maxBook = "";

        Set<String> set = map.keySet();
        Iterator<String> it = set.iterator();
        while(it.hasNext()){
            String book = it.next();
            int val = map.get(book);
            if(max < val){
                max = val;
                maxBook = book;
            }
            if(max == val && book.compareTo(maxBook)<0){
                maxBook = book;
            }
        }

        System.out.println(maxBook);
    }


}

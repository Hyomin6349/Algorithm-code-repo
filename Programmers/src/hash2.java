
import java.util.*;

public class hash2 {
    static String result="";

    static int solution(String[][] clothes) {
        int answer = 0;

        HashMap<String,Character> typeMap=new HashMap<>();
        HashMap<Character,Integer> clothMap=new HashMap<>();

        int charnum=97;

        //초기화 부분
        for(int i=0;i<clothes.length;i++) {
            if(typeMap.containsKey(clothes[i][1])) {
                char key=typeMap.get(clothes[i][1]);
                int val=clothMap.get(key);
                clothMap.replace(key, val+1);
            }
            else {
                typeMap.put(clothes[i][1], (char)charnum);
                clothMap.put(typeMap.get(clothes[i][1]),1);
                charnum++;
            }
        }

        char[] arr=new char[typeMap.size()];
        boolean[] visited=new boolean[typeMap.size()];
        int index=0;

        //combination함수에 쓰일 arr 생성 함수
        Set<Character> keySet=clothMap.keySet();
        Iterator<Character> it=keySet.iterator();
        while(it.hasNext()) {
            arr[index++]=it.next();
        }


        return answer;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[][] clothes= {{"yellow_hat","headgear"},{"blue_sumglasses","eyewear"},{"green_turban","headgear"}};
        System.out.println(solution(clothes));
    }

}

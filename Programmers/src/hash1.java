
import java.util.*;

public class hash1 {
    static String solution(String[] participant, String[] completion) {
        String answer = "";
        /*
        ArrayList<String> p=new ArrayList<>();

        for(int i=0;i<participant.length;i++) p.add(participant[i]);


        for(int i=0;i<completion.length;i++) {
        	p.remove(completion[i]);
        }

        answer=p.get(0);
        */

        HashMap<String,Integer> map=new HashMap<>();

        //map초기화
        for(int i=0;i<participant.length;i++) {
            //중복 이름 value 늘리기
            if(map.containsKey(participant[i])) {
                int val=map.get(participant[i]);
                map.replace(participant[i], val+1);
            }
            else map.put(participant[i], 1);
        }

        for(int i=0;i<completion.length;i++) {
            String key=completion[i];
            if(map.get(key)==1) map.remove(key);
            else {
                int val=map.get(key);
                map.replace(key, val-1);
            }
        }

        Set<String> key=map.keySet();
        Iterator<String> it=key.iterator();
        answer=it.next();

        return answer;
    }

    public static void main(String[] args) {
        String[] participant= {"a","a","b"};
        String[] completion= {"a","b"};
        System.out.println(solution(participant,completion));
    }
}

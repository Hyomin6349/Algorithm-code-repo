import java.util.*;

public class _2021_메뉴리뉴얼 {

    static  HashMap<String, Integer> map;

    public static ArrayList<String> solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();

        for(int j=0;j<course.length; j++){
            int num = course[j];
            map = new HashMap<>();

            for(int i=0;i<orders.length; i++){
                char[] arr = orders[i].toCharArray();
                char[] select = new char[num];
                Arrays.sort(arr);
                if(arr.length>=num) comb(arr, num, select, 0, 0);
            }

            ArrayList<String> temp = new ArrayList<>();
            Set<String> keys = map.keySet();
            Iterator<String> it = keys.iterator();
            int maxVal = 2;
            while(it.hasNext()){
                String key = it.next();
                Integer val = map.get(key);
                if(maxVal<val){
                    maxVal = val;
                    temp.clear();
                    temp.add(key);
                }
                else if(maxVal == val) temp.add(key);
            }
            for(int i=0;i<temp.size();i++) answer.add(temp.get(i));
        }


        Collections.sort(answer);

        return answer;
    }

    public static void comb(char[] arr, int num, char[] select,int cnt, int start){
        if(cnt==num){
            String res = new String(select);
            if(map.containsKey(res)){
                Integer val = map.get(res);
                map.put(res, val+1);
            }
            else map.put(res, 1);
            return;
        }

        for(int i=start; i<arr.length; i++){
            select[cnt] = arr[i];
            comb(arr, num, select, cnt+1, i+1);
        }
    }

    public static void main(String[] args){
        String[] orders = {"XYZ", "XWY", "WXA"};
        int[] course = {2,3,4};
        ArrayList<String> answer = solution(orders, course);

        for(int i=0; i<answer.size(); i++){
            System.out.println(answer.get(i));
        }
    }
}

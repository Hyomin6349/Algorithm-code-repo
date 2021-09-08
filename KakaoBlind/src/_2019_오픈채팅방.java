import java.util.*;

public class _2019_오픈채팅방 {
    public static void main(String[] args) {
        String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
        String[] answer = solution(record);
        for(int i=0; i<answer.length;i++){
            System.out.println(answer[i]);
        }
    }

     public static String[] solution(String[] record) {
        

        HashMap<String, String> map = new HashMap<>();
        ArrayList<Status> list = new ArrayList<>();
        
        for(String cmd : record){
            String[] info = cmd.split(" ");
            if(!info[0].equals("Leave")) map.put(info[1], info[2]);
            if(info[0].equals("Enter")) list.add(new Status(info[1], true));
            if(info[0].equals("Leave")) list.add(new Status(info[1], false));
        }
        String[] answer = new String[list.size()];
        int idx = 0;
        for(Status st: list){
            if(st.enter){
                answer[idx] = map.get(st.id) + "님이 들어왔습니다.";
            }
            else answer[idx] = map.get(st.id) + "님이 나갔습니다.";
            
            idx++;
        }

        return answer;
    }
    
    public static class Status{
        String id;
        boolean enter;
        public Status(String id, boolean enter){
            this.id = id;
            this.enter = enter;
        }
    }
}

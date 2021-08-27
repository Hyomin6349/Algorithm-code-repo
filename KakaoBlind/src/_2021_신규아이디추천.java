

public class _2021_신규아이디추천 {

    public static String solution(String new_id){
        String temp = new_id.toLowerCase();
        String answer = "";
        int length = temp.length();
        String allow = "abcdefghijklmnopqrstuvwxyz0123456789-_.";
        boolean preDot = false;

        for(int i=0;i<length;i++){
            char c = temp.charAt(i);
            if(!allow.contains(String.valueOf(c))) continue;
            if(i>0 && preDot && c=='.') continue;

            answer += c;
            if(c=='.') preDot = true;
            else preDot = false;
        }

        if(answer.charAt(0)=='.') answer = answer.substring(1);
        if(answer.length()>0 && answer.charAt(answer.length()-1)=='.') answer = answer.substring(0, answer.length()-1);
        if(answer.length()==0) answer += 'a';
        if(answer.length()>=16){
            if(answer.charAt(14)=='.') answer = answer.substring(0, 14);
            else answer = answer.substring(0, 15);
        }
        if(answer.length()<=2){
            char last = answer.charAt(answer.length()-1);
            while(answer.length()<3) answer += last;
        }

        return answer;
    }

    public static void main(String[] args){
        String new_id = "=.=";
        System.out.println(solution(new_id));
    }
}

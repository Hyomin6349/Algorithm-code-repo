import java.io.*;

public class epper15_05 {
    static String solution(String input){
        String answer = "";
        int count = 0;

        if(input.charAt(0) == '1') answer += "1";

        for(int i=1; i<input.length(); i++){
            if(input.charAt(i-1) != input.charAt(i)){
                answer += (char)('A'+ count); //count = 연속된 문자열 개수 - 1
                count=0;
            }
            else count++;
        }

        answer += (char)('A'+ count);   // 형변환!!!! 잘 알아두기!!

        return answer;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String answer= solution(input);

        System.out.println(answer);
    }
}
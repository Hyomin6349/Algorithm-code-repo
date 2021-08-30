import java.util.*;

//61.3
public class _2021_광고삽입 {

    public static String solution(String play_time, String adv_time, String[] logs) {
        String answer = "";
        int[] ad = new int[360000];
        for(int i=0;i< logs.length;i++){
            String[] time = logs[i].split("-");
            for(int j=getTime(time[0]); j<getTime(time[1]);j++) ad[j]++;
        }

        int at = getTime(adv_time);
        int pt = getTime(play_time);
        long sum = 0, max =0;
        int startTime = 0;
        for(int i=0; i<at; i++) sum += ad[i];
        for(int i=at;i<pt;i++){
            sum += ad[i];
            sum -= ad[i-at];
            if(sum > max){
                max = sum;
                startTime = i-at+1;
            }
        }

        int[] t = new int[3];
        t[0] = startTime/3600;
        startTime %= 3600;
        t[1] = startTime/60;
        t[2] = startTime%60;

        for(int i=0;i<3;i++){
            if(t[i]<10) answer += '0';
            answer += String.valueOf(t[i]);
            if(i<2) answer += ':';
        }

        return answer;
    }

    public static int getTime(String stime){
        String[] splits = stime.split(":");
        int time = Integer.parseInt(splits[2]);
        time += 60 * Integer.parseInt(splits[1]);
        time += 60*60*Integer.parseInt(splits[0]);
        return time;
    }

    public static void main(String[] args){
        String pt = "02:03:55";
        String at = "00:14:15";
        String[] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};
        System.out.println(solution(pt, at, logs));
    }
}

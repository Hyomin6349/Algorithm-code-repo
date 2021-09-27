import java.util.*;

public class p1755 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        ArrayList<String> list = new ArrayList<>();
        for(int i=M; i<=N;i++){
            String convert = "";
            if(i>=10){
                convert += numToString(i/10);
                convert += " ";
            }
            convert += numToString(i%10);
            list.add(convert);
        }

        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        int cnt = 0;

        for(int i=0;i<list.size();i++){
            String str = list.get(i);
            String[] s = str.split(" ");
            int num = 0;
            if(s.length>1){
                num += 10 * stringToInt(s[0]);
                num += stringToInt(s[1]);
            }
           else num += stringToInt(s[0]);
           sb.append(num+" ");

           cnt++;
           if(cnt%10==0) sb.append('\n');
        }

        System.out.println(sb);
    }

    public static String numToString(int i){
        switch(i){
            case 0: return "zero";
            case 1: return "one";
            case 2: return "two";
            case 3: return "three";
            case 4: return "four";
            case 5: return "five";
            case 6: return "six";
            case 7: return "seven";
            case 8: return "eight";
            case 9: return "nine";
            default: return " ";
        }
    }

    public static int stringToInt(String s){
        switch(s){
            case "zero": return 0;
            case "one": return 1;
            case "two": return 2;
            case "three": return 3;
            case "four": return 4;
            case "five": return 5;
            case "six": return 6;
            case "seven": return 7;
            case "eight": return 8;
            case "nine": return 9;
            default: return -1;
        }
    }
}

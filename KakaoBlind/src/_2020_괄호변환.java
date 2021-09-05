public class _2020_괄호변환 {
    public static String solution(String p) {
        if(p.length()==0) return "";
        int open=0, close=0;
        for(int i=0; i<p.length();i++){
            if(p.charAt(i)=='(') open++;
            else close++;
            if(open==close){
                String u = p.substring(0, i+1);
                String v = p.substring(i+1);
                if(isCollect(u)) return u+solution(v);
                else{
                    String temp = "(";
                    temp += solution(v);
                    temp += ')';
                    for(int j=1;j<u.length()-1; j++){
                        if(u.charAt(j)=='(') temp += ')';
                        else temp += '(';
                    }
                    return temp;
                }
            }
        }
        return "";
    }

    public static boolean isCollect(String p){
        int open=0;
        for(int i=0;i<p.length();i++){
            if(p.charAt(i)=='(') open++;
            else{
                open--;
                if(open<0) return false;
            }
        }
        //if(open!=0) return false;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution("()))((()"));
    }
}

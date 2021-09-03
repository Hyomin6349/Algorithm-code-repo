class Solution {
    public int solution(String s) {
        int answer = 1001;
        int length = s.length();
        for(int i=1; i*2<=length;i++){
            String result = "";
            String pre = "";
            int cnt = 0;
            int j=0;
            for(j=0; j<=length-i; j+=i){
                String cur = s.substring(j, j+i);
                if(pre.equals(cur)){
                    cnt++;
                }else{
                    if(cnt>1) result += String.valueOf(cnt);
                    result += pre;
                    pre = cur;
                    cnt = 1;
                }
            }
            if(cnt>1) result += String.valueOf(cnt);
            result += pre;
            if(j!=length) result += s.substring(j, length);
            if(answer > result.length()) answer = result.length();
        }
        if(length==1) return 1;
        else return answer;
    }
}
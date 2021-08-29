import java.util.StringTokenizer;
// 정확도 100, 효율성 0
// 이진 탐색과, 4차원배열
public class _2021_순위검색 {

    public static int[] solution(String[] info, String[] query) {
        int ilength = info.length;
        int qlength = query.length;
        int[] answer = new int[qlength];
        for(int i=0;i<qlength;i++) answer[i] = ilength;

        for(int i=0;i<ilength;i++){
            String[] splits = info[i].split(" ");

            for(int j=0;j<qlength;j++){
                StringTokenizer st = new StringTokenizer(query[j]);
                int idx = 0;

                while(st.hasMoreTokens()){
                    String cond = st.nextToken();
                    if(cond.equals("and")) continue;
                    if(cond.equals("-")){
                        idx++;
                        continue;
                    }

                    if(idx==4){
                        if(Integer.parseInt(splits[idx])<Integer.parseInt(cond)) {
                            answer[j]--;
                        }
                        break;
                    }
                    if(!splits[idx].equals(cond)){
                        answer[j]--;
                        break;
                    }
                    idx++;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args){
        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
        int[] answer = solution(info, query);
        for(int i=0;i<answer.length;i++){
            System.out.println(answer[i]);
        }
    }
}

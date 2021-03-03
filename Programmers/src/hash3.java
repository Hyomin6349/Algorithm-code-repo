import java.util.*;

public class hash3 {

    static int[] solution(String[] genres, int[] plays) {
        ArrayList<Integer> list=new ArrayList<Integer>();

        HashMap<String,int[]> map=new HashMap<>();
        HashMap<Integer,Integer> numMap=new HashMap<>();	//고유번호 해시

        //map 초기화
        for(int i=0;i<genres.length;i++) {
            numMap.put(i, plays[i]);
            if(map.containsKey(genres[i])) {
                int[] genre_info=map.get(genres[i]);
                genre_info[0] += plays[i];	//total값 갱신

                //고유번호 갱신
                if(plays[i]>numMap.get(genre_info[1])) {
                    int temp=genre_info[1];
                    genre_info[1]=i;
                    genre_info[2]=temp;
                }
                else if(genre_info[2] == -1 || plays[i]>numMap.get(genre_info[2])) genre_info[2]=i;

                map.replace(genres[i], genre_info);
            }
            else {
                int[] info= {plays[i],i,-1}; // total, 첫번째 고유번호, 두번째 고유번호
                map.put(genres[i], info);
            }
        }

        //values를 2차원 배열로 변경
        int[][] values=new int[map.size()][3];
        int index=0;

        Set<String> keys=map.keySet();
        Iterator<String> it=keys.iterator();
        while(it.hasNext()) {
            values[index++]=map.get(it.next());
        }

        //total 값 기준 내림차순
        Arrays.sort(values, new Comparator<int[]>() {
            public int compare(int[] arr1,int[] arr2) {
                return arr2[0]-arr1[0];
            }
        });

        for(int i=0;i<values.length;i++) {
            System.out.println(values[i][0]);
            //장르의 곡이 하나인 경우
            if(values[i][2]==-1) list.add(values[i][1]);
            else {
                list.add(values[i][1]);
                list.add(values[i][2]);
            }
        }

        int[] answer= new int[list.size()];
        for(int i=0;i<answer.length;i++) {
            answer[i]=list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] genres= {"classic","pop","classic","pop","classic","classic","song"};
        int[] plays= {400,600,150,2500,500,500,100};
        int[] answer=solution(genres,plays);
        for(int i=0;i<answer.length;i++) System.out.println(answer[i]);;
    }
}

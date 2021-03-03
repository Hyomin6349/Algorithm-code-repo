public class dfsbfs2 {
    static int current=0;
    static int[] arr;
    static boolean[] check;
    static int size;
    static int answer;

    static void dfs(int idx, int target) {
        //마지막 레벨 노드인 경우 target과 current 비교
        if(idx>=Math.pow(2, size)-1)
        {
            if(current == target) answer++;
            current -= arr[idx];
            dfs((idx-1)/2,target);		//부모노드로 이동
        }
        //모든 자식 방문한 경우
        if(check[idx*2+1]==true && check[idx*2+2]==true) {
            current -= arr[idx];
            dfs((idx-1)/2,target);		//부모노드로 이동
        }
        current += arr[idx]; 		// 값 추가
        //왼쪽 자식 노드부터 방문
        if(check[idx*2+1]==false) dfs(idx*2+1,target);
        else dfs(idx*2+2,target);
    }

    static int solution(int[] numbers, int target) {
        answer = 0;

        arr=new int[(int)Math.pow(2, numbers.length+1)-1];
        check=new boolean[arr.length];
        size=numbers.length;

        for(int i=1;i<arr.length;i++) {
            check[i]=false; 	// check 초기화
            int num=numbers[(int)(Math.log(i+1)/Math.log(2))-1];
            if(i%2==0) arr[i]=num*-1;
            else arr[i]=num;
        }

        dfs(0,target);

        return answer;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] numbers= {1,1,1,1,1};
        int target=3;
        System.out.println(solution(numbers,target));
    }

}

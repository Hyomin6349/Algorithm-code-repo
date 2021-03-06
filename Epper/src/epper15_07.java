import java.util.*;

/*
* 학생들이 인기 많은 두 좌석에 대한 희망 시작 시간과 희망 종료 시간을 적어서 내어
* 최대한 많은 학생이 두 좌석에 앉을 수 있는 경우를 구하는 문제
*
* 1. 종료 시간이 빠른 순서대로 오름차순 정렬
* 2. seat1과 seat2를 별개의 두 자리로 보는 것이 아닌,
* sea1 위주로 비교하고 seat2는 seat1을 보존하는 것으로 사용한다.
*
*  */

public class epper15_07 {
    public static class Student implements Comparable<Student>{
        int start;
        int finish;
        public Student(int s, int f){
            this.start=s;
            this.finish=f;
        }

        @Override
        public int compareTo(Student target){
            if(this.finish == target.finish) return this.start-target.start;
            else return this.finish-target.finish; //this-target => 오름차순
        }
    }


    public static int solution(int[] s, int[]e, int N){
        int answer = 0;
        ArrayList<Student> students= new ArrayList<Student>();
        int seat1=0;
        int seat2=0;

        for(int i=0; i<N ; i++){
            Student p = new Student(s[i], e[i]);
            students.add(p);
        }

        Collections.sort(students);

        int n=0, m=0;

        for(int i=0;i<N;i++){
            int st = students.get(i).start;
            int f = students.get(i).finish;
            if(seat1<=st){
                seat1=f;
                answer++;
            }else if(seat2<=st){
                seat2 = seat1;
                seat1=f;
                answer++;
            }
        }


        return answer;
    }
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        int s[] = new int[1000];
        int e[] = new int[1000];
        int N;
        N = scan.nextInt();
        for(int i = 0; i < N; i++)
            s[i] = scan.nextInt();
        for(int i = 0; i < N; i++)
            e[i] = scan.nextInt();
        System.out.print(solution(s, e, N));
    }
}

import java.util.*;

class Player{
    Set<Integer> win=new HashSet<>();	//player한테 이긴사람
    Set<Integer> lose=new HashSet<>();	//player 진사람
}

public class graph2 {
    static int solution(int n, int[][] results) {
        int answer = 0;

        Player[] players=new Player[n+1];
        //player배열 초기화
        for(int i=0;i<n+1;i++) {
            players[i]=new Player();
        }

        for(int i=0;i<results.length;i++) {
            int winner=results[i][0];
            int loser=results[i][1];

            //결과를 추가
            players[loser].win.add(winner);
            players[winner].lose.add(loser);
            //winner를 이긴사람들을 players[loser].win에 추가
            players[loser].win.addAll(players[winner].win);
            //loser한테 진사람들을 players[winner].lose에 추가
            players[winner].lose.addAll(players[loser].lose);
        }

        for(int i=results.length-1;i>=0;i--) {
            int winner=results[i][0];
            int loser=results[i][1];

            //winner를 이긴사람들을 players[loser].win에 추가
            players[loser].win.addAll(players[winner].win);
            //loser한테 진사람들을 players[winner].lose에 추가
            players[winner].lose.addAll(players[loser].lose);
        }

        for(int i=0;i<=n;i++) {
            if(players[i].win.size()+players[i].lose.size() ==n-1)
                answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n=5;
        int[][] results= {{4,3},{4,2},{3,2},{1,2},{2,5}};
        System.out.println(solution(n,results));
    }

}

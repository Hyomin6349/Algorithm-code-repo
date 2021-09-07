import java.util.*;

public class _2020_블록이동하기 {


    public static class Pos{
        int row, col, dir;
        public Pos(int r, int c, int d){
            row = r; col = c; dir = d;
        }
    }

    public static int solution(int[][] board) {
        int n = board.length;
        boolean[][][] visit = new boolean[n][n][2];
        Queue<Pos> q = new LinkedList<>();
        q.add(new Pos(0, 0, 0));
        visit[0][0][0] = true;

        int answer = -1;
        loop: while(!q.isEmpty()){
            answer++;
            int size = q.size();
            for(int i=0;i<size;i++) {
                Pos cur = q.poll();
                int row = cur.row;
                int col = cur.col;
                int dir = cur.dir;
                if (row == n - 1 && col == n - 2 && dir == 0) break loop;
                if (row == n - 2 && col == n - 1 && dir == 1) break loop;

                if (dir == 0) {
                    if (col + 2 < n && board[row][col + 2] == 0 && !visit[row][col + 1][0]) {
                        q.add(new Pos(row, col + 1, 0));
                        visit[row][col + 1][0] = true;
                    }
                    if (col> 0 && board[row][col - 1] == 0 && !visit[row][col - 1][0]) {
                        q.add(new Pos(row, col - 1, 0));
                        visit[row][col - 1][0] = true;
                    }
                    if (row + 1 < n && board[row + 1][col] == 0 && board[row + 1][col + 1] == 0) {
                        if (!visit[row + 1][col][0]) {
                            q.add(new Pos(row + 1, col, 0));
                            visit[row + 1][col][0] = true;
                        }
                        if (!visit[row][col][1]) {
                            q.add(new Pos(row, col, 1));
                            visit[row][col][1] = true;
                        }
                        if (!visit[row][col + 1][1]) {
                            q.add(new Pos(row, col + 1, 1));
                            visit[row][col + 1][1] = true;
                        }
                    }
                    if (row > 0 && board[row - 1][col] == 0 && board[row - 1][col + 1] == 0) {
                        if (!visit[row - 1][col][0]) {
                            q.add(new Pos(row - 1, col, 0));
                            visit[row - 1][col][0] = true;
                        }
                        if (!visit[row - 1][col][1]) {
                            q.add(new Pos(row - 1, col, 1));
                            visit[row - 1][col][1] = true;
                        }
                        if (!visit[row - 1][col + 1][1]) {
                            q.add(new Pos(row - 1, col + 1, 1));
                            visit[row - 1][col + 1][1] = true;
                        }
                    }
                } else {
                    if (row > 0 && board[row - 1][col] == 0 && !visit[row - 1][col][1]) {
                        q.add(new Pos(row - 1, col, 1));
                        visit[row - 1][col][1] = true;
                    }
                    if (row + 2 < n && board[row + 2][col] == 0 && !visit[row + 1][col][1]) {
                        q.add(new Pos(row + 1, col, 1));
                        visit[row + 1][col][1] = true;
                    }
                    if (col + 1 < n && board[row][col + 1] == 0 && board[row + 1][col + 1] == 0) {
                        if (!visit[row][col + 1][1]) {
                            q.add(new Pos(row, col + 1, 1));
                            visit[row][col + 1][1] = true;
                        }
                        if (!visit[row][col][0]) {
                            q.add(new Pos(row, col, 0));
                            visit[row][col][0] = true;
                        }
                        if (!visit[row + 1][col][0]) {
                            q.add(new Pos(row + 1, col, 0));
                            visit[row + 1][col][0] = true;
                        }
                    }
                    if (col> 0 && board[row][col - 1] == 0 && board[row + 1][col - 1] == 0) {
                        if (!visit[row][col - 1][1]) {
                            q.add(new Pos(row, col - 1, 1));
                            visit[row][col - 1][1] = true;
                        }
                        if (!visit[row][col - 1][0]) {
                            q.add(new Pos(row, col - 1, 0));
                            visit[row][col - 1][0] = true;
                        }
                        if (!visit[row + 1][col - 1][0]) {
                            q.add(new Pos(row + 1, col - 1, 0));
                            visit[row + 1][col - 1][0] = true;
                        }
                    }
                }
            }
        }


        return answer;
    }

    public static void main(String[] args) {
        int[][] board = {{0, 0, 0, 1, 1}, {0, 0, 0, 1, 0}, {0, 1, 0, 1, 1}, {1, 1, 0, 0, 1}, {0, 0, 0, 0, 0}};
        System.out.println(solution(board));
    }

}

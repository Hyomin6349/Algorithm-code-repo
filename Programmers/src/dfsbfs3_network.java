public class dfsbfs3_network {
    static boolean[] visited;

    public static int solution(int n, int[][] computers) {
        visited = new boolean[n];
        int answer = 0;

        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfs(computers, n, i);
                answer++;
            }
        }

        return answer;
    }

    public static void dfs(int[][] c, int n, int i){
        visited[i] = true;

        for(int j=0; j<n;j++){
            if(c[i][j] == 1 && i!=j && !visited[j]) dfs(c, n, j);
        }
    }

    public static void main(String[] args){
        int n=3;
        int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};
        int answer = solution(n, computers);
        System.out.println(answer);
    }
}

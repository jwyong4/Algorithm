class Solution {
    static int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        dfs(dungeons, 0, k, visited);
        return answer;
    }
    
    public void dfs(int[][] dungeons, int depth, int k, boolean[] visited) {
        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i] == true || k < dungeons[i][0]) {
                continue;
            }
            
            visited[i] = true;
            dfs(dungeons, depth + 1, k - dungeons[i][1], visited);
            visited[i] = false;
        }
        
        answer = Math.max(answer, depth);
    }
}
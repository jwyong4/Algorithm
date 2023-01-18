import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < moves.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][moves[i] - 1] == 0) {
                    continue;
                    
                } else {
                    list.add(board[j][moves[i] - 1]);
                    board[j][moves[i] - 1] = 0;
                    break;
                }
            }
            
            for (int k = 0; k < list.size() - 1; k++) {
                if (list.get(k) == list.get(k + 1)) {
                    list.remove(k + 1);
                    list.remove(k);
                    answer += 2;
                    break;
                }
            }
        }
        return answer;
    }
}
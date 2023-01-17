import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n;
        
        for (int i = 0; i < lost.length; i++) {
            for (int k = 0; k < reserve.length; k++) {
                if (lost[i] == reserve[k]) {
                    reserve[k] = -1;
                    lost[i] = -1;
                }
            }
        }
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for (int i = 0; i < lost.length; i++) {
            if (lost[i] == -1) {
                continue;
            }
            
            for (int j = 1; j <= n; j++) {
                if (lost[i] == j) {
                    answer--;
                    
                    for (int k = 0; k < reserve.length; k++) {
                        if (lost[i] == reserve[k] - 1 || lost[i] == reserve[k] + 1) {
                            reserve[k] = -1;
                            answer++;
                            break;
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}
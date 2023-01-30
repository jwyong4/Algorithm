import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        
        // 0 1 3 5 6
        // 0 0 3 3 3 5 6
        
        for (int i = 0; i < citations.length; i++) {
            int end = citations.length - i;
            if (citations[i] >= end) {
                answer = end;
                break;
            }
        }
        
        return answer;
    }
}
import java.util.*;
class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], number[i]);
        }
        
        loop:
        for (int i = 0; i < discount.length - 9; i++) {
            Map<String, Integer> cloneMap = new HashMap<>(map);
            // System.out.println("loop i " + (i + 1));
            
            for (int j = i; j < i + 10; j++) {
                // System.out.println("day " + (j + 1));
                
                if (map.containsKey(discount[j])) {
                    cloneMap.put(discount[j], cloneMap.get(discount[j]) - 1);
                    // System.out.println(cloneMap);
                }
            }
            
            for (Map.Entry<String, Integer> entry : cloneMap.entrySet()) {
                if (entry.getValue() > 0) {
                    continue loop;
                }
            }
            
            answer++;
        }
        
        return answer;
    }
}
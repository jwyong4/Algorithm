import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("R", 0);
        map.put("T", 0);
        map.put("C", 0);
        map.put("F", 0);
        map.put("J", 0);
        map.put("M", 0);
        map.put("A", 0);
        map.put("N", 0);
        
        for (int i = 0; i < survey.length; i++) {
            String key1 = String.valueOf(survey[i].charAt(0));
            String key2 = String.valueOf(survey[i].charAt(1));
            
            switch (choices[i]) {
                case 1: map.put(key1, map.get(key1) + 3); break;
                case 2: map.put(key1, map.get(key1) + 2); break;
                case 3: map.put(key1, map.get(key1) + 1); break;
                case 5: map.put(key2, map.get(key2) + 1); break;
                case 6: map.put(key2, map.get(key2) + 2); break;
                case 7: map.put(key2, map.get(key2) + 3); break;
            }
        }
        
        String ch = "";
        int cnt = 0;
        int i = 0;
        for (String key : map.keySet()) {
            if (i == 0) {
                ch = key;
                cnt = map.get(key);
                i++;
                
            } else if (i == 1) {
                if (cnt >= map.get(key)) {
                    answer += ch;
                } else {
                    answer += key;
                }
                i = 0;
            }
        }
        
        return answer;
    }
}
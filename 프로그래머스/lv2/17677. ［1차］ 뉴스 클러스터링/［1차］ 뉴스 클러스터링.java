import java.util.*;
class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        if (str1.equals(str2)) return 65536;
        Map<String, Integer> map1 = toMap(str1);
        Map<String, Integer> map2 = toMap(str2);
        double inter = 0;
        double union = 0;
        
        for (Map.Entry<String, Integer> entry : map1.entrySet()) {
            String key = entry.getKey();
            if (map2.containsKey(key)) {
                int min = Math.min(map1.get(key), map2.get(key));
                int max = Math.max(map1.get(key), map2.get(key));
                inter += min;
                union += max;
                map2.remove(key);
            } else {
                union += entry.getValue();
            }
        }
        
        for (Map.Entry<String, Integer> entry : map2.entrySet()) {
            union += entry.getValue();
        }
        
        answer = (int) ((inter / union) * 65536);
        return answer;
    }
    
    public Map<String, Integer> toMap(String str) {
        List<String> strList = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < str.length() - 1; i++) {
            String str1 = Character.toString(str.charAt(i));
            String str2 = Character.toString(str.charAt(i + 1));
            if (str1.matches("[^A-Z]") || str2.matches("[^A-Z]")) {
                continue;
            }
            String twoStr = str1 + str2;
            map.put(twoStr, map.getOrDefault(twoStr, 0) + 1);
        }
        
        return map;
    }
}
import java.util.*;
class Solution {
    public int[] solution(String s) {
        Map<String, Integer> map = new HashMap<>();
        String[] temp = s.substring(2, s.length() - 2).replace("},{", " ").split(" ");
        int[] answer = new int[temp.length];
        
        for (int i = 0; i < temp.length; i++) {
            String[] tempArr = temp[i].split(",");
            
            for (int j = 0; j < tempArr.length; j++) {
                map.put(tempArr[j], map.getOrDefault(tempArr[j], 0) + 1);
            }
        }
        
        List<Map.Entry<String, Integer>> entry = new LinkedList<>(map.entrySet());
        entry.sort((o1, o2) -> map.get(o2.getKey()) - map.get(o1.getKey()));
        
        int i = 0;
        for (Map.Entry<String, Integer> e : entry) {
            answer[i] = Integer.parseInt(e.getKey());
            i++;
        }
        
        return answer;
    }
}
import java.util.*;
class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        LinkedList<String> list = new LinkedList<>();
        
        if (cacheSize == 0) {
            return cities.length * 5;
        }
        
        for (int i = 0; i < cities.length; i++) {
            String city = cities[i].toUpperCase();
            
            if (list.remove(city)) {
                list.add(0, city);
                answer += 1;
                
            } else {
                if (list.size() >= cacheSize) {
                    list.remove(list.size() - 1);
                }
                
                list.add(0, city);
                answer += 5;
            }
        }
        
        return answer;
    }
}
import java.util.*;
class Solution {
    public int[] solution(String msg) {
        char[] chArr = msg.toCharArray();
        Map<String, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int index = 1;
        
        for (int i = 65; i <= 90; i++) {
            map.put(String.valueOf((char) i), index);
            index++;
        }
        
        String word = String.valueOf(chArr[0]);
        for (int i = 0; i < chArr.length - 1; i++) {
            String s1 = String.valueOf(chArr[i]);
            String s2 = String.valueOf(chArr[i + 1]);
            word += s2;
            if (map.containsKey(word)) {
                list.add(map.get(word));
                System.out.println("있을때" + word);
                i++;
            } else {
                word = word.substring(0, word.length() - 1);
                list.add(map.get(word));
                map.put(word, index);
                System.out.println("없을때" + word);
                word = s2;
                index++;
            }
        }
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
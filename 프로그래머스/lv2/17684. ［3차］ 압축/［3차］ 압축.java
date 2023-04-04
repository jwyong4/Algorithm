import java.util.*;
class Solution {
    public int[] solution(String msg) {
        Queue<String> que = new LinkedList<>();
        List<String> dic = new ArrayList<>();
        List<Integer> ansList = new ArrayList<>();
        
        for (String s : msg.split("")) {
            que.offer(s);
        }
        
        for (int i = 65; i <= 90; i++) {
            dic.add(String.valueOf((char)i));
        }
        
        String word = "";
        while (!que.isEmpty() || !word.equals("")) {
            if (dic.contains(word + que.peek())) {
                word += que.poll();
            } else {
                dic.add(word + que.peek());
                ansList.add(dic.indexOf(word) + 1);
                word = "";
            }
        }
        
        int[] answer = new int[ansList.size()];
        for (int i = 0; i < ansList.size(); i++) {
            answer[i] = ansList.get(i);
        }
        
        return answer;
    }
}
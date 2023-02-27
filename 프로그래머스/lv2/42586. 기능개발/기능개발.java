import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] operDate = new int[progresses.length];
        
        for (int i = 0; i < progresses.length; i++) {
            int progress = progresses[i];
            int speed = speeds[i];
            int reProgress = 100 - progress;
            int reDate = reProgress / speed;
            if (reProgress % speed != 0) reDate++;
            operDate[i] = reDate;
        }
        List<Integer> list = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < operDate.length; i++) {
            if (operDate[i] == 0) continue;
            list.add(index, 1);
            for (int j = i + 1; j < operDate.length; j++) {
                if (operDate[j] == 0 || operDate[i] < operDate[j]) {
                    break;
                } else {
                    operDate[j] = 0;
                    list.set(index, list.get(index) + 1);
                }
            }
            index++;
        }
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        
        return answer;
    }
}
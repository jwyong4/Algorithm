import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, HashSet<String>> map = new HashMap<>();
        Map<String, Integer> cnt = new LinkedHashMap<>();

        for (String id : id_list) {
            map.put(id, new HashSet<>());
            cnt.put(id, 0);
        }

        for (String s : report) {
            String reporter = s.substring(0, s.indexOf(" "));
            String reported = s.substring(s.indexOf(" ") + 1, s.length());
            map.get(reported).add(reporter);
        }

        for (String reported : map.keySet()) {
            if (map.get(reported).size() >= k) {
                for (String reporter : map.get(reported)) {
                    cnt.put(reporter, cnt.get(reporter) + 1);
                }
            }
        }

        int i = 0;
        for (String str : cnt.keySet()) {
            answer[i] = cnt.get(str);
            i++;
        }

        return answer;
    }
}
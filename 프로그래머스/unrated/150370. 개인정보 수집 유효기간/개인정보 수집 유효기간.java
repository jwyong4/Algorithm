import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, Integer> rule = new HashMap<>();
        String[][] period = new String[privacies.length][2];
        int date = Integer.parseInt(today.replace(".", ""));
        List<Integer> list = new ArrayList<>();

        // rule에  k = "약관", v = 약관 일수로 담아줌
        for (String s : terms) {
            rule.put(s.substring(0, s.indexOf(" ")), Integer.parseInt(s.substring(s.indexOf(" ") + 1, s.length())));
        }

        // period에 ["날짜", 약관]으로 담아줌
        int i = 0;
        for (String s : privacies) {
            period[i][0] = s.substring(0, s.indexOf(" "));
            period[i][1] = s.substring(s.indexOf(" ") + 1, s.length());
            i++;
        }

        // period를 순회하며 day랑 비교
        for (int j = 0; j < period.length; j++) {
            String tempDate = period[j][0];
            String tempRule = period[j][1];
            int[] dateInt = new int[3];

            dateInt[0] = Integer.parseInt(tempDate.substring(0, 4)); // 년
            dateInt[1] = Integer.parseInt(tempDate.substring(5, 7)); // 월
            dateInt[2] = Integer.parseInt(tempDate.substring(8, 10)); // 일

            if (rule.get(tempRule) % 12 == 0) {
                dateInt[0] += rule.get(tempRule) / 12;
            } else {
                dateInt[1] += rule.get(tempRule);
                if (dateInt[1] % 12 == 0) {
                    dateInt[0] += dateInt[1] / 12 - 1;
                    dateInt[1] = 12;
                } else {
                    dateInt[0] += dateInt[1] / 12;
                    dateInt[1] %= 12;
                }
            }

            String month = "";
            String day = "";
            if (dateInt[2] < 10) {
                day = "0" + String.valueOf(dateInt[2]);
            } else {
                day = String.valueOf(dateInt[2]);
            }
            if (dateInt[1] < 10) {
                month = "0" + String.valueOf(dateInt[1]);
            } else {
                month = String.valueOf(dateInt[1]);
            }

            String dateStr = String.valueOf(dateInt[0]) + month + day;
            int validity = Integer.parseInt(dateStr);

            if (validity <= date) {
                list.add(j + 1);
            }
        }

        int[] answer = new int[list.size()];
        int j = 0;
        for (int n : list) {
            answer[j] = n;
            j++;
        }

        return answer;
    }
}
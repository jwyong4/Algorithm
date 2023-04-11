import java.util.*;
class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        
        // 구할 갯수 * 인원수
        for (int i = 0; i <= t * m; i++) {
            sb.append(Integer.toString(i, n));
        }
        
        // 순서가 올때 해당 수를 문자열에 추가, 
        for (int i = p - 1; temp.length() < t; i += m) {
            temp.append(sb.charAt(i));
        }
        
        answer = temp.toString().toUpperCase();
        
        return answer;
    }
}
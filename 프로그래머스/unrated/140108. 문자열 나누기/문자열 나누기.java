class Solution {
    public int solution(String s) {
        int answer = 0;
        char ch = ' ';
        int same = 0;
        int diff = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (ch == ' ') {
                ch = s.charAt(i);
            }
            
            if (ch == s.charAt(i)) {
                same++;
            } else {
                diff++;
            }
            
            if (same == diff) {
                same = 0;
                diff = 0;
                ch = ' ';
                answer++;
            }
        }
        
        if (ch != ' ') {
            answer++;
        }
        
        return answer;
    }
}
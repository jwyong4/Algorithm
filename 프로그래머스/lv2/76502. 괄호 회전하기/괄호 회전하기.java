import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = 0;
        
        for (int i = 0; i < s.length(); i++) {
            Stack<Character> stack = new Stack<>();
            String temp = s.substring(i, s.length()) + s.substring(0, i);
            
            for (int j = 0; j < temp.length(); j++) {
                char ch = temp.charAt(j);
                
                if (stack.isEmpty()) {
                    stack.push(ch);
                } else if (ch == ')' && stack.peek() == '(') {
                    stack.pop();
                } else if (ch == '}' && stack.peek() == '{') {
                    stack.pop();
                } else if (ch == ']' && stack.peek() == '[') {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
            
            if (stack.isEmpty()) {
                answer++;
            }
        }
        
        return answer;
    }
}
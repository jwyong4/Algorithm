class Solution {
    public String solution(String s) {
        String answer = "";
        char[] arr = s.toCharArray();
        boolean upper = true;
        
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != ' ' && upper) {
                answer += Character.toString(Character.toUpperCase(arr[i]));
                upper = false;
            } else if (arr[i] == ' ') {
                answer += " ";
                upper = true;
            } else {
                answer += Character.toString(Character.toLowerCase(arr[i]));
            }
        }
        
        return answer;
    }
}
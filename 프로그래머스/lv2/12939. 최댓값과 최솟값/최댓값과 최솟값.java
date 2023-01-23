import java.util.*;
class Solution {
    public String solution(String s) {
        String[] tempArr = s.split(" ");
        int[] arr = Arrays.stream(tempArr).mapToInt(Integer::parseInt).toArray();
        
        int max = arr[0];
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        String answer = String.valueOf(min) + " " + String.valueOf(max);
        
        
        return answer;
    }
}
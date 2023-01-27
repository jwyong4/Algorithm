class Solution {
    public int solution(int[] arr) {
        int answer = 0;
        answer = getLcm(arr[0], arr[1]);
        
        for (int i = 2; i < arr.length; i++) {
            answer = getLcm(answer, arr[i]);
        }
        
        return answer;
    }
    
    public static int getLcm(int num1, int num2) {
        int lcm = (num1 * num2) / getGcd(num1, num2);
        
        return lcm;
    }
    
    public static int getGcd(int num1, int num2) {
        if (num1 % num2 == 0) {
            return num2;
        }
        
        return getGcd(num2, num1 % num2);
    }
}
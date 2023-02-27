class Solution {
    public int[] solution(int n, long left, long right) {
        int length = (int)(right - left) + 1;
        int[] answer = new int[length];
        
        int index = 0;
        for (long i = left; i <= right; i++) {
            answer[index++] = Math.max((int)(i / n), (int)(i % n)) + 1;
        }
        
        return answer;
    }
}
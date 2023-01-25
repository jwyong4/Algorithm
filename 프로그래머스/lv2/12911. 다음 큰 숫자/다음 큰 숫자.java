class Solution {
    public int solution(int n) {
        int answer = 0;
        int nCnt = Integer.bitCount(n);
        
        for (int i = n + 1; i <= 1000000; i++) {
            int aCnt = Integer.bitCount(i);
            
            if (nCnt == aCnt) {
                answer = i;
                break;
            }
        }
        
        return answer;
    }
}
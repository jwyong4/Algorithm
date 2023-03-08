class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        long nn = n;
        String[] arr = Long.toString(nn, k).split("0");
        
        loop:
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("") || arr[i].equals("1")) continue;
            long num = Long.parseLong(arr[i]);
            
            for (int j = 2; j <= (int)Math.sqrt(num); j++) {
                if (num % j == 0) {
                    continue loop;
                }
            }
            
            answer++;
        }
        return answer;
    }
}
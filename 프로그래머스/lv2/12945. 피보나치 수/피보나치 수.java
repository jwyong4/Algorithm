class Solution {
    static int[] arr = new int[100001];
    public int solution(int n) {
        int answer = fibo(n);
        return answer;
    }
    
    public int fibo(int num) {
        if (num <= 1) {
            return num;
        } else if (arr[num] != 0) {
            return arr[num];
        } else {
            return arr[num] = (fibo(num - 1) + fibo(num - 2)) % 1234567;
        }
    }
}
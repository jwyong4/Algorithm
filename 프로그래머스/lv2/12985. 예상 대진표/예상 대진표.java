class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 0;
        
        // n, a, b
        // 8, 4, 7
        // 4, 2, 4
        // 2, 1, 2
        
        // n, a, b
        // 20, 2, 18
        // 10, 0, 2
        // 
        
//         if (a % 2 == 1) a = a + 1;
//         if (b % 2 == 1) b = b + 1;
        
        while (a != b) {
            answer++;
            
            a = a / 2 + a % 2;
            b = b / 2 + b % 2;
            
        }

        return answer;
    }
}
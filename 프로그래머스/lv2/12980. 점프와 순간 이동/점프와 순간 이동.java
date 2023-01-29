import java.util.*;

public class Solution {
    public int solution(int n) {
        int ans = 0;

        // 5000, 2500, 1250, 625, 312(1), 156, 78, 39, 19(1), 9(1), 4(1), 2, 0
        // 5, 2(1), 0
        // 6, 3, 1(1), 0
        // 34, 17, 8(1), 4, 2, 0
        // 규칙 : n % 2를 ans에 더하면
        
        while (n != 0) {
            ans += n % 2;
            n /= 2;
        }

        return ans;
    }
}
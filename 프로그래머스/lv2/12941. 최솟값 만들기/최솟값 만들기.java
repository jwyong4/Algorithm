import java.util.*;
class Solution
{
    public int solution(int []A, int []B)
    {
        int answer = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        // B = Arrays.stream(B).boxed().sorted(Collections.reverseOrder()).mapToInt(Integer::intValue).toArray();
        // Integer[] B2 = Arrays.stream(B).boxed().toArray(Integer[]::new);
        // Arrays.sort(B2, Collections.reverseOrder());
        
        for (int i = 0, j = B.length - 1; i < A.length; i++, j--) {
            answer += A[i] * B[j];
        }

        return answer;
    }
}
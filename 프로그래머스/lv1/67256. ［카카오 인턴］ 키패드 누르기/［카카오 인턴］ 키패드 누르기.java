class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int rHand = 12; // 오른손 시작위치 #
        int lHand = 10; // 왼손 시작위치 *
        int[][] phone = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {10, 11, 12}
        };
        
        for (int i = 0; i < numbers.length; i++) {
            // number가 0이면 11로 변경
            if (numbers[i] == 0) {
                numbers[i] = 11;
            }
            
            for (int j = 0; j < phone.length; j++) {
                // number의 y 좌표값이 0이면 왼손
                if (numbers[i] == phone[j][0]) {
                    lHand = numbers[i];
                    answer += "L";
                    break;
                    
                // number의 y 좌표값이 2이면 오른손
                } else if (numbers[i] == phone[j][2]) {
                    rHand = numbers[i];
                    answer += "R";
                    break;
                    
                // number의 y 좌표값이 1이면 비교 시작
                } else if (numbers[i] == phone[j][1]) {
                    // 각 손의 현재 좌표값 구하기
                    int[] indexL = xy(lHand, phone);
                    int[] indexR = xy(rHand, phone);
                    // 각 손의 좌표값과 number의 좌표값을 빼주어 거리값 계산
                    int lDistance = Math.abs(indexL[0] - j) + Math.abs(indexL[1] - 1);
                    int rDistance = Math.abs(indexR[0] - j) + Math.abs(indexR[1] - 1);
                    
                    if (lDistance < rDistance) {
                        lHand = numbers[i];
                        answer += "L";
                        break;
                        
                    } else if (lDistance > rDistance) {
                        rHand = numbers[i];
                        answer += "R";
                        break;
                        
                    } else {
                        if (hand.equals("left")) {
                            lHand = numbers[i];
                            answer += "L";
                            break;
                            
                        } else {
                            rHand = numbers[i];
                            answer += "R";
                            break;
                        }
                    }
                    
                }
                
            }
        }
        
        return answer;
    }
    
    // phone을 순회하며 입력받은 num의 좌표값을 찾아서 배열로 리턴
    public int[] xy(int num, int[][] phone) {
        for (int i = 0; i < phone.length; i++) {
            for (int j = 0; j < phone[i].length; j++) {
                if (num == phone[i][j]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int rHand = 12;
        int lHand = 10;
        int[][] phone = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {10, 11, 12}
        };
        
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                numbers[i] = 11;
            }
            
            for (int j = 0; j < phone.length; j++) {
                if (numbers[i] == phone[j][0]) {
                    lHand = numbers[i];
                    answer += "L";
                    break;
                    
                } else if (numbers[i] == phone[j][2]) {
                    rHand = numbers[i];
                    answer += "R";
                    break;
                    
                } else if (numbers[i] == phone[j][1]) {
                    int[] indexL = xy(lHand, phone);
                    int[] indexR = xy(rHand, phone);
                    
                    if (Math.abs(indexL[0] - j) + Math.abs(indexL[1] - 1) < Math.abs(indexR[0] - j) + Math.abs(indexR[1] - 1)) {
                        lHand = numbers[i];
                        answer += "L";
                        break;
                        
                    } else if (Math.abs(indexL[0] - j) + Math.abs(indexL[1] - 1) > Math.abs(indexR[0] - j) + Math.abs(indexR[1] - 1)) {
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
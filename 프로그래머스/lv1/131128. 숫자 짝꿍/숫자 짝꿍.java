class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        int[] arrX = new int[10];
        int[] arrY = new int[10];
        
        for (int i = 0; i < X.length(); i++) {
            arrX[X.charAt(i) - '0']++;
        }
        
        for (int i = 0; i < Y.length(); i++) {
            arrY[Y.charAt(i) - '0']++;
        }
        
//         for (String s : X.split("")) {
//             arrX[Integer.valueOf(s)]++;
//         }
                
//         for (String s : Y.split("")) {
//             arrY[Integer.valueOf(s)]++;
//         }
        
        for (int i = 9; i >= 0; i--) {
            for (int j = 0; j < Math.min(arrX[i], arrY[i]); j++) {
                sb.append(i);
            }
        }
        
        String answer = sb.toString();
        
        if (answer.isEmpty()) {
            answer = "-1";
        } else if (answer.replace("0", "").isEmpty()) {
            answer = "0";
        }
        
        return answer;
    }
}
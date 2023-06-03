import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        // 주차 시간 계산
        Map<String,Integer> timeMap = new HashMap<String,Integer>();
        
        for (int i = 0; i < records.length; i++) {
        	String[] record = records[i].split(" ");
        	int time = Integer.valueOf(record[0].substring(0, 2)) * 60 + Integer.valueOf(record[0].substring(3, 5));
        	
            if (record[2].equals("IN")) {
        		time*=-1;
        	}
            
        	if (timeMap.containsKey(record[1])) {
        		 time += timeMap.get(record[1]);
        	}
            
        	timeMap.put(record[1], time);
        }
        
        // 요금 계산
        Map<String,Integer> feeMap = new HashMap<String,Integer>();
        for (String key : timeMap.keySet()) {
        	int time = timeMap.get(key);
            
        	if (time <= 0) { // 출차 내역 없을때
        		time += 1439;
        	}

        	int fee = fees[1] +(int) Math.ceil(Math.max(0, time - fees[0])/(double)fees[2]) * fees[3];
        	feeMap.put(key, fee);
        }
        
        // 차 번호 작은 순
        Object[] mapKey  = feeMap.keySet().toArray();
		Arrays.sort(mapKey);
		
		int[] answer = new int[feeMap.size()];
		int j = 0;
        
		for (Object key : mapKey) answer[j++] = feeMap.get(key);

        return answer;
    }
}
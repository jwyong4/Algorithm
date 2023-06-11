import java.util.*;
class Solution {
    public String[] solution(String[] record) {
        HashMap<String, String> info = new HashMap<>();
        ArrayList<String> log = new ArrayList<>();
        
        for(String s : record){
            // 상태, 아이디, 닉네임 스플릿
            StringTokenizer st = new StringTokenizer(s);
            String status = st.nextToken();
            String id = st.nextToken();
            String name = status.equals("Leave") ? "" : st.nextToken(); // Leave이면 id만 저장
            
            // 상태값에 따라 log 내용 저장
            switch(status){
                case "Enter":
                    info.put(id, name);
                    log.add(id + "님이 들어왔습니다.");
                    break;
                case "Change":
                    info.put(id, name);
                    break;
                case "Leave":
                    log.add(id + "님이 나갔습니다.");
                    break;
            }
        }
        
        // 바뀐 아이디 수정
        String[] answer = new String[log.size()];
        for(int i = 0; i < answer.length; i++){
            String id = log.get(i).substring(0, log.get(i).indexOf("님"));
            answer[i] = log.get(i).replace(id, info.get(id));
        }
        
        return answer;
    }
}
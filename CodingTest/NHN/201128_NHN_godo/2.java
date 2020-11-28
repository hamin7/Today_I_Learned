//핵심 소스코드의 설명을 주석으로 작성하면 평가에 큰 도움이 됩니다.
public class Solution{
    static boolean[] brokenBool;
    static int target, error, limit, ans;
    
    public int solution(int page, int[] broken) {
        target = page;
        error = broken.length;      // 고장난 버튼의 갯수.
        
        brokenBool = new boolean[10];
        
        for (int i = 0; i < error; i++) {
            brokenBool[broken[i]] = true;       // 고장 났으면 true
        }
        
        limit = ("" + page).length() + 1;       // 채널의 최대 자릿수
        ans = Math.abs(page - 100);     // + , - 버튼만으로 이동하는 경우
        
        for (int i = 0; i < 10; ++i) {
            // 입력 채널 첫 번째 자릿수 결정
            if (!brokenBool[i]) {
                click(1, i);
            }
        }
        
        return ans;
    }
    
    public static void click(int length, int channel) {
        if (limit < length) {
            return;
        }
        
        int cur = Math.abs(target - channel) + length;        // 현재 채널에서 목표 채널로 가기 위한 횟수.
        ans = ans > cur ? cur : ans;    // 최소값 갱신
        
        for (int i = 0; i < 10; i++) {
            if(!brokenBool[i]) {
                click(length + 1, (channel * 10) + i);  // 스트링 사용하지 않고 10 곱하고 더함으로써 해결.
            }
        }
    }
    
    public static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
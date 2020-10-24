class exan1 {
    public String solution(String new_id) {
        String answer = "";

//      step1. 대문자를 소문자로 변환
        String step1 = convertCapital(new_id);
//      step2. 특수문자 제거
        String step2 = removeCertainChar(step1);
//      step3. ... 줄이기
        String step3 = abbreviateComma(step2);
//      step4. 아이디의 처음이나 끝에 위치한 '.' 제거.
        String step4 = firstLocatedComma(step3);
//      step5. 빈 문자열이라면 a 대입.
        String step5 = replaceEmptyToA(step4);
//      step6. 아이디의 길이가 16자 이상이면, 처음 15자 뺴고 제거.
        String step6 = removeOver16(step5);
        step6 = firstLocatedComma(step6);
//      step7. 길이가 2자 이하라면 마지막 문자를 길이가 3이 될 때 까지 반복해서 끝에 붙이기.
        String step7 = repeatWhile3(step6);

        answer = step7;
        
        return answer;
    }
    
//  step1 대문자롤 소문자로 변환하는 함수.
    static String convertCapital(String new_id) {
        String output = "";     // 최종적으로 출력할 문자열을 저장하는 output 선언
        int tmp;
        
//      문자열을 검사하기 위해서 new_id의 길이만큼 반복문 실행 (한글자씩 tmp에 옮겨서 검사)
        for (int i = 0; i < new_id.length(); i++) {
            
//          문자열은 아스키코드 (숫자)로 저장되기 때문에 int형으로 변환.
            tmp = (int)new_id.charAt(i);
            
//          문자가 65 <= tmp <= 90인 경우 (대문자인 경우)
            if((65 <= tmp) && (tmp <= 90)) {
                output += (char)(tmp + 32);     // 32 더해서 소문자로 변환
            } else if((97 <= tmp) && (tmp <= 122)) {        // 문자가 97 <= tmp <= 122인 경우 (소문자인 경우)
                output += (char)(tmp);         // 그대로 넣기
            } else {
                output += (char)tmp;    // 그대로 넣기
            }
        }
        
        return output;
    }
    
//  step2 특수문자를 제거하는 함수.
    static String removeCertainChar(String new_id) {
        String match = "[^xfe0-9a-z-_.]";
        new_id = new_id.replaceAll(match, "");
        return new_id;
    }
    
//  step3 점을 줄이는 함수.
    static String abbreviateComma(String new_id) {
        int flag = 0;       // 앞에 콤마가 있는지 여부.
        String result = "";     // 연속 콤마를 제거한 String을 저장할 문자열.
        
        for (int i = 0; i < new_id.length(); i++) {
            if((new_id.charAt(i) == '.') && (flag == 0) ) {
                // 앞에 콤마가 아니고 이번이 콤마라면 (첫 콤마라면)
                flag = 1;
                result += String.valueOf(new_id.charAt(i));     // 이번 문자를 result에 추가.
            } else if ((new_id.charAt(i) == '.') && (flag == 1)) {
                // 앞에 콤마가 있고 이번이 콤마라면
                continue;
            } else if (new_id.charAt(i) != '.') {
                flag = 0;
                result += String.valueOf(new_id.charAt(i));     // 이번 문자를 result에 추가.
            }
        }
        return result;
    }
    
//  step4 아이디 처음에 위치한 '.' 제거
    static String firstLocatedComma(String new_id) {
        if (new_id.charAt(0) == '.') {
            // 처음에 .이 있다면
            new_id = new_id.substring(1);       // 첫 글자 제거.
        } else if (new_id.charAt(new_id.length() - 1) == '.'){
            // 마지막에 .이 있다면
            new_id = new_id.substring(0, new_id.length() - 1);      // 마지막 글자 제거.
        }
        return new_id;
    }
    
//  step5 빈 문자열이라면, 'a' 대입
    static String replaceEmptyToA(String new_id) {
        if (new_id == null || new_id.equals("")) {
            new_id += 'a';
        }
        return new_id;
    }
    
//  step6. 아이디의 길이가 16자 이상이면, 처음 15자 뺴고 제거.
    static String removeOver16(String new_id) {
        String result = "";
        if (new_id.length() > 15) {
            for (int i = 0; i < 15; i++) {
                result += String.valueOf(new_id.charAt(i));
            }
        } else {
            result = new_id;
        }
        
        return result;
    }
    
//  step7. 길이가 2자 이하라면 마지막 문자를 길이가 3이 될 때 까지 반복해서 끝에 붙이기.
    static String repeatWhile3(String new_id) {
        if (new_id.length() < 3) {
            while (new_id.length() < 3) {
                new_id += String.valueOf(new_id.charAt(new_id.length()-1));
            }
        }
        return new_id;
    }
}
package Week5;

public class NewIDRecommend {
    public static void main(String[] args) {
        System.out.println(solution2("...abc..."));
    }
    public static String solution2(String new_id){
        String answer;
        while(true){
            //1
            new_id = new_id.toLowerCase();
            System.out.println("1: " + new_id);

            //2
            StringBuilder sb = new StringBuilder();
            String allowedSpecial = "-_.";
            for (int i = 0; i < new_id.length(); i++) {
                char letter = new_id.charAt(i);
                if ((97 <= letter && letter <= 122) || (49 <= letter && letter < 58)
                        || allowedSpecial.contains(String.valueOf(letter))) {
                    sb.append(letter);
                }
            }
            new_id = sb.toString();
            System.out.println("2: " + new_id);
            //3
            sb.setLength(0);
            for(int i = 0; i < new_id.length(); i++){
                if( i != 0 && new_id.charAt(i) == '.' && new_id.charAt(i-1) == '.')
                    continue;
                sb.append(new_id.charAt(i));
            }
            answer = sb.toString();
            System.out.println("3: " + answer);
            //4
            if (answer.length() > 0 && answer.charAt(0) == '.')
                answer = answer.substring(1);
            if (answer.length() > 0 && answer.charAt(answer.length()-1) == '.')
                answer = answer.substring(0, answer.length() - 1);
            System.out.println("4: " + answer);
            // 5
            if(answer.length() == 0)  answer = new String("a");
            System.out.println("5: " + answer);
            // 6
            if(answer.length() > 15) answer = answer.substring(0, 15);
            System.out.println("6: " + answer);
            // 7
            if(answer.length() < 3){
                sb.setLength(0);
                sb.append(answer);
                while (sb.length() < 3)
                    sb.append(answer.charAt(answer.length() - 1));
                answer = sb.toString();
            }
            System.out.println("7: " + answer);
            System.out.println();
            if (new_id.equals(answer)) break;
            new_id = new String(answer);
            answer = null;
        }
        return answer;
    }

    public static String solution(String new_id) {
        String answer = new String(new_id);
        String preAnswer = new String(answer);

        while(true) {
            preAnswer = new String(answer);

            // 1단계
            answer = answer.toLowerCase();
            System.out.println("1: " + answer);
            // 2단계
            StringBuilder sb = new StringBuilder();
            String allowedSpecial = "-_.";
            for (int i = 0; i < answer.length(); i++) {
                char letter = answer.charAt(i);
                if ((97 <= letter && letter <= 122) || (49 <= letter && letter < 58)
                        || allowedSpecial.contains(String.valueOf(letter))) {
                    sb.append(letter);
                }
            }
            answer = sb.toString();
            System.out.println("2: " + answer);

            // 3단계
            sb.setLength(0);
            for (int i = 0; i < answer.length() - 1; i++) {
                if (answer.charAt(i) == '.' && answer.charAt(i + 1) == '.')
                    continue;
                sb.append(answer.charAt(i));
            }
            sb.append(answer.charAt(answer.length() - 1));
            answer = sb.toString();
            System.out.println("3: " + answer);
            // 4단계
            if (answer.charAt(0) == '.') {
                if (answer.length() > 1)
                    answer = answer.substring(1, answer.length());
                else
                    answer = "";
            }
            if (answer.length() > 0 && answer.charAt(answer.length() - 1) == '.')
                answer = answer.substring(0, answer.length() - 1);
            System.out.println("4: " + answer);
            // 5단계
            if (answer.length() == 0) answer = "a";
            System.out.println("5: " + answer);
            // 6단계
            if (answer.length() > 15) answer = answer.substring(0, 15);
            System.out.println("6: " + answer);
            // 7단계
            if (answer.length() <= 2) {
                sb.setLength(0);
                sb.append(answer);
                while (sb.length() < 3)
                    sb.append(answer.charAt(answer.length() - 1));
                answer = sb.toString();
            }
            System.out.println("7: " + answer);

            if(preAnswer.equals(answer))
                break;
        }
        return answer;
    }
}

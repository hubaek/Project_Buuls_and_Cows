import java.util.*;

public class BaseballGame {

    // 인스턴스 변수 선언(필드) - 다른 메서드에서 정답을 비교하기 위함
    private final int answer;

    // 객체 생성시 정답을 만들기
    public BaseballGame() {
        // 1~9의 숫자를 리스트에 넣음
        // 단점? List 배열사이즈가 1~9까지 만들어야함 거기서 앞에서 3개의 값을 꺼내는 것.
        List<Integer> numbers = new ArrayList<>();
        for (int i=1; i <= 9; i++){
            numbers.add(i);
        }

        Collections.shuffle(numbers);

        int digit1 = numbers.get(0);
        int digit2 = numbers.get(1);
        int digit3 = numbers.get(2);

        // 3자리 수 만드는 법? 1,2,3 만들고 이어 붙일 수있을까?
        this.answer = digit1*100 + digit2 * 10 + digit3;
        System.out.println(answer);

        System.out.println("<게임을 시작합니다>");

    }

    public int play() {
        while (true) {
            // 입력값 받기
            Scanner sc = new Scanner(System.in);
            String inputAnswer = sc.next();

            // 입력값 유효성 검사
            if (validateInput(inputAnswer)) {
//                System.out.println("3자리수, 중복 검증 완");

                // 정답 일치하는지 확인
                int parseAnswer = Integer.parseInt(inputAnswer);
                if (parseAnswer == answer) {
                    System.out.println("정답일치");
                    break;
                }
            } else {
                System.out.println("다시 정답 입력");
            }

        }
        return 0;
    }

    // 입력값 유효성 검사 메서드
    private boolean validateInput(String inputAnswer) {
        // 정답 길이가 3인지 확인
        if(inputAnswer.length() == 3) {
//            System.out.println("3글자 입력확인");

            // 입력한 값이 모두 숫자인지 확인하는 로직
            try {
                // 입력한 값 int 타입으로 변환
                Integer.parseInt(inputAnswer);
//                System.out.println("3자리 모두 숫자 확인");

            } catch (NumberFormatException e) {
                System.out.println("3자리 숫자만 입력해주세요.");
                return false;
            }

            // 입력한 값에 숫자가 중복인지 체크
            Set<Character> duplicateAnswer = new HashSet<>();
            for (int i = 0; i < inputAnswer.length(); i++) {
                char digit = inputAnswer.charAt(i);
                if (!(duplicateAnswer.add(digit))) {
                    System.out.println("중복입니다.");
                    return false;
                }

            }
            return true;
        }
        System.out.println("3자리 아님");
        return false;
    }


    // 정답과 입력값이 같은 자리에 같은 수인 갯수를 count하는 메서드
    private int countStrike(String inputAnswer) {
        // answer(int)와 inputAnswer(String) 같은 숫자와 자리수 일치하면 strike

        // 비교하기 위해 int타입의 정답을 String타입으로 변환
        String answerStr = String.valueOf(answer);

        int strikeCount = 0;

        for (int i=0; i < answerStr.length(); i++) {
            // 각 자리의 값이 같으면 count 증가
            if (answerStr.charAt(i) == inputAnswer.charAt(i)) {
                strikeCount++;  // 같은 자리에 같은 숫자가 있으면 카운트 증가;
            }
        }

        return strikeCount;
    }

    // 정답과 입력값이 자리는 다르나, 값이 같은 갯수를 반환하는 메서드
    private int countBall(String inputAnswer) {
        // 자리가 같지 않고, 값만 같은 루프 돌기?
        int ballCount = 0;
        String answerStr = String.valueOf(answer);

        for (int i = 0; i < answerStr.length(); i++) {
            for (int j = 0; j < answerStr.length(); j++) {
                // i != j 자리가 다를 때, 같은 수가 있는지 찾는 로직
                if (i != j && answerStr.charAt(i)==inputAnswer.charAt(j)) {
                    ballCount++;
                }
            }
        }

        return ballCount;

        /*
        // 해당 로직은 중복 값이 있을 경우 나올 수 있는 로직이라 복잡하고 지금 필요없는 로직
        boolean[] strike = new boolean[answerStr.length()];

        // strike인 자리를 파악하기 위한 로직
        for (int i=0; i < answerStr.length(); i++) {
            if (answerStr.charAt(i) == inputAnswer.charAt(i)) {
                strike[i] = true; // strike 경우 true값 저장
            }
        }

        for (int i =0; i<answerStr.length(); i++) {
            // strike로 선언된 자리는 제외하고 count하기 위한 로직
            if (!(strike[i])) {
                for (int j=0; j < answerStr.length(); j++) {
                    // i != j 자리수가 같지 않을때 같은 값을 찾기
                    if (i != j && answerStr.charAt(i)==inputAnswer.charAt(j)) {
                        ballCount++;

                    }
                }
            }
        }

         */
    }



}

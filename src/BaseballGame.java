import java.util.*;

public class BaseballGame {

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
        int threeDigitNumber = digit1*100 + digit2 * 10 + digit3;
        System.out.println(threeDigitNumber);

        System.out.println("<게임을 시작합니다>");

    }

    public int play() {
        while (true) {
            // 입력값 받기
            Scanner sc = new Scanner(System.in);
            String inputAnswer = sc.next();

            // 입력값 유효성 검사
            if (validateInput(inputAnswer)) {
                System.out.println("3자리수 검증 완");

                break;
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
            System.out.println("3글자 입력확인");

            // 입력한 값이 모두 숫자인지 확인하는 로직
            try {
                // 입력한 값 int 타입으로 변환
                Integer.parseInt(inputAnswer);
                System.out.println("3자리 모두 숫자 확인");

            } catch (NumberFormatException e) {
                System.out.println("3자리 숫자만 입력해주세요.");
                return false;
            }

            return true;
        }
        System.out.println("3자리 아님");
        return false;
    }


}

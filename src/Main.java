import java.util.*;

public class Main {
    public static void main(String[] args) {

        BaseballGameDisplay baseballGameDisplay = new BaseballGameDisplay();

        Scanner sc = new Scanner(System.in);
        // 환영문구
        System.out.println("숫자야구 게임에 오신걸 환영합니다. ");

        while (true) {
            System.out.println("원하시는 번호를 입력해 주세요");
            System.out.println("1. 게임시작하기 2. 게임기록보기 3. 종료하기");

            // 베이스볼 객체 생성시, 정답생성
            BaseballGame baseballGame = new BaseballGame();

            int menuSelection = sc.nextInt();

            // 1. 게임시작하기 2. 게임기록보기 3. 종료하기
            if (menuSelection == 1) {
                System.out.println("<게임을 시작합니다>");
                // 게임시작
                baseballGame.play();
            } else if (menuSelection == 2) {
                // 인스턴스 변수일때 사용
                //  baseballGameDisplay.gameLog(baseballGame.gameLogMap);

                // static 정적변수일때, 객체를 생성안하고 접근 가능
                baseballGameDisplay.gameLog(BaseballGame.gameLogMap);

            } else if (menuSelection == 3) {
//                System.out.println(baseballGame.gameLogMap);
                System.out.println("게임을 종료합니다.");
                break;
            }

        }






    }
}
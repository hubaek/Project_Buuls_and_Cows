import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        // 환영문구
        System.out.println("숫자야구 게임에 오신걸 환영합니다. ");

        while (true) {
            System.out.println("원하시는 번호를 입력해 주세요");
            System.out.println("1. 게임시작하기 2. 게임기록보기 3. 종료하기");

            int menuSelection = sc.nextInt();
            // 1. 게임시작하기 2. 게임기록보기 3. 종료하기
            if (menuSelection == 1) {
                System.out.println("<게임을 시작합니다>");
                // 베이스볼 객체 생성시, 게임시작 - 정답생성
                BaseballGame baseballGame = new BaseballGame();
                // 게임시작 (정답 입력)
                baseballGame.play();
            } else if (menuSelection == 2) {
                // 게임 기록 보기 로직
                System.out.println("게임기록 보기");
            } else if (menuSelection == 3) {
                System.out.println("게임을 종료합니다.");
                break;
            }

        }






    }
}
public class BaseballGameDisplay {

    public void displayHint(int strike, int ball) {

        // strike, ball이 없을때 아웃
        if (strike == 0 && ball == 0) {
            System.out.println("아웃");
        } else if (strike != 0 && ball != 0) { // 둘다 값이 있을땐 n스트라이크 n볼
            System.out.println(strike + "스트라이크" + ball + "볼");
        } else if (strike !=0 && ball == 0 && strike !=3) {   // 스트라이크만 있을때
            System.out.println(strike + "스트라이크");
        } else if (strike ==0 && ball != 0) {
            System.out.println(ball + "볼");
        } else if (strike == 3) {   // 3스트라이크는 정답이므로 축하메시지 출력
            System.out.println("정답입니다!");
        }
    }
}

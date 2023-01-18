package numberbaseballgame;

public enum ResultEnum {
    BALL("볼")
    , STRIKE("스트라이크")
    , NOTHING("낫싱")
    , NOTICE_END("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.")
    ;

    private String result;

    ResultEnum(String result) {
        this.result = result;
    }

    public String result() {
        return result;
    }
}

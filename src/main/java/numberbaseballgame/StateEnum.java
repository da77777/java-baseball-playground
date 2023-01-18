package numberbaseballgame;

public enum StateEnum {

    KEEP_GOING(0)
    , NEW_GAME(1)
    , END_GAME(2)
    ;

    private int state;

    StateEnum(int state) {
        this.state = state;
    }

    public int state() {
        return state;
    }
}

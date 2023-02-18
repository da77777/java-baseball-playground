package numberbaseballgame;

public class Result {

  private int strike;
  private int ball;

  public int getStrike() {
    return strike;
  }

  public int getBall() {
    return ball;
  }

  public Result(int strike, int ball) {
    this.strike = strike;
    this.ball = ball;
  }
}

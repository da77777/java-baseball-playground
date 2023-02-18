package numberbaseballgame;

public class ResultVIew {

  private final String NOTHING = "낫싱";
  private final String BALL = "볼";
  private final String STRIKE = "스트라이크";

  public void printResult(Result result) {
    if(result.getStrike() == 0 && result.getBall() == 0) {
      System.out.println(NOTHING);
      return;
    }
    if(result.getStrike() != 0 && result.getBall() != 0) {
      System.out.println(result.getStrike() + STRIKE
      + result.getBall() + BALL);
      return;
    }
    if(result.getStrike() != 0) {
      System.out.println(result.getStrike() + STRIKE);
      return;
    }
    if(result.getBall() != 0) {
      System.out.println(result.getBall() + BALL);
      return;
    }

  }
}


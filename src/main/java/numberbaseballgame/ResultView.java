package numberbaseballgame;

public class ResultView {

  private final String NOTHING = "낫싱";
  private final String BALL = "볼";
  private final String STRIKE = "스트라이크";

  public void printResult(Result result) {
    if(result.getStrike() == 0 && result.getBall() == 0) {
      System.out.print(NOTHING);
    }
    if(result.getStrike() != 0) {
      System.out.print(result.getStrike() + STRIKE + " ");
    }
    if(result.getBall() != 0) {
      System.out.print(result.getBall() + BALL);
    }
    System.out.println();
    return;
  }
}


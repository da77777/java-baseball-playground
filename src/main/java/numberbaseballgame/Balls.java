package numberbaseballgame;

import java.util.ArrayList;
import java.util.List;

public class Balls {

  private List<Ball> balls;

  public Balls(List<Integer> nums) {
    this.balls = makeBalls(nums);
  }

  private List<Ball> makeBalls(List<Integer> nums) {
    List<Ball> balls = new ArrayList<>();
    for(int i = 0; i < nums.size(); i++) {
      balls.add(new Ball(i+1, nums.get(i)));
    }
    return balls;
  }

  public Result playResult(Balls ballList) {
    int strikeCount = 0;
    int ballCount = 0;
    for(int i = 0; i < ballList.balls.size(); i++) {
      strikeCount += isStrike(ballList.balls.get(i));
      ballCount += isBall(ballList.balls.get(i));
    }
    return new Result(strikeCount, ballCount);
  }

  private int isBall(Ball ball) {
    int ballCount = 0;
    int index = 0;
    while(ballCount == 0 && index < this.balls.size()) {
      ballCount = this.balls.get(index).isBall(ball);
      index += 1;
    }
    return ballCount;
  }

  private int isStrike(Ball ball) {
    int ballCount = 0;
    int index = 0;
    while(ballCount == 0 && index < this.balls.size()) {
      ballCount = this.balls.get(index).isStrike(ball);
      index += 1;
    }
    return ballCount;
  }



}

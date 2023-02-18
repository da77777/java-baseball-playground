package study.numberbaseballgame2;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import numberbaseballgame.Ball;
import numberbaseballgame.Balls;
import numberbaseballgame.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallsTest {

  private Balls comBalls;

  @BeforeEach
  void setUp() {
    comBalls = new Balls(Arrays.asList(1, 2, 3));
  }

  @Test
  @DisplayName("낫싱_검증")
  void playNothingTest() {
    Balls playerBalls = new Balls(Arrays.asList(4, 5, 6));
    Result result = comBalls.playResult(playerBalls);
    assertThat(result.getStrike()).isEqualTo(0);
    assertThat(result.getBall()).isEqualTo(0);
  }

  @Test
  @DisplayName("볼_검증")
  void playBallTest() {
    Balls playerBalls = new Balls(Arrays.asList(2, 5, 6));
    Result result = comBalls.playResult(playerBalls);
    assertThat(result.getStrike()).isEqualTo(0);
    assertThat(result.getBall()).isEqualTo(1);
  }

  @Test
  @DisplayName("스트라이크_검증")
  void playStrikeTest() {
    Balls playerBalls = new Balls(Arrays.asList(1, 2, 3));
    Result result = comBalls.playResult(playerBalls);
    assertThat(result.getStrike()).isEqualTo(3);
    assertThat(result.getBall()).isEqualTo(0);
  }
  
  @Test
  @DisplayName("equals_검증")
  void overrideEquals() {
    Ball ball1 = new Ball(1, 3);
    Ball ball2 = new Ball(1, 3);
    Ball ball3 = new Ball(1, 3);

    //일관성 : null이 아닌 모든 참조 값 x,y에 대해 x.equals(y)를 반복 호출 시 항상 참이거나 항상 참이 아님

    //반사성 : null이 아닌 모든 참조 값 x에 대해 x.equals(x)는 참
    boolean result1 = ball1.equals(ball1);

    //대칭성 : null이 아닌 모든 참조값 x, y에 대해 x.equals(y)가 참이면 y.equals(x)도 참
    boolean result2 = (ball1.equals(ball2) && ball2.equals(ball1));

    //추이성 : null이 아닌 모든 참조 값 x,y,z에 대해, x.equals(y)가 참이고, y.equals(z)도 참이면, x.equals(z)도 참
    boolean result3 = (ball1.equals(ball2) && ball2.equals(ball3) && ball1.equals(ball3));

    //null-false : null이 아닌 모든 참조 값 x에 대해 x.equals(null)은 false
    boolean result4 = ball1.equals(null);

    assertThat(result1).isTrue();
    assertThat(result2).isTrue();
    assertThat(result3).isTrue();
    assertThat(result4).isFalse();
  }

  @Test
  @DisplayName("hashCode_검증")
  void temp() {
    Ball ball1 = new Ball(1, 3);
    Ball ball2 = new Ball(1, 3);

    assertThat(ball1.hashCode() == ball2.hashCode()).isTrue();


  }


}

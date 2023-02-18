package study.numberbaseballgame2;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import numberbaseballgame.Balls;
import numberbaseballgame.Game;
import numberbaseballgame.StateEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class GameTest {

  private Game game = new Game();

  @DisplayName("랜덤숫자_생성")
  @ParameterizedTest
  @MethodSource("randomNumberData")
  void getRandomNumbers(StateEnum state, boolean expect) {
    Balls before = new Balls(Arrays.asList(1, 2, 3));
    Balls after = game.getRandomNumbers(state, before);
    assertThat(before.equals(after)).isEqualTo(expect);
  }

  static Stream<Arguments> randomNumberData() {
    return Stream.of(
        Arguments.of(StateEnum.NEW, false)
        ,Arguments.of(StateEnum.END, true)
        ,Arguments.of(StateEnum.KEEP, true)
    );
  }

}

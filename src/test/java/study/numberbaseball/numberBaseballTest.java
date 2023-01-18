package study.numberbaseball;

import numberbaseballgame.Computer;
import numberbaseballgame.Game;
import numberbaseballgame.Player;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class numberBaseballTest {

  Game game = new Game();
  Player player = new Player();
  Computer computer = new Computer();

  @DisplayName("숫자만 입력 여부 테스트")
  @ParameterizedTest
  @CsvSource(value = {"048:숫자만", "1f3:숫자만", "&15:숫자만", "(15:숫자만"}, delimiter = ':')
  void validOnlyNumberTest(String input, String expected) {
    String kind = "number";
    assertThatThrownBy(() ->
        player.validOnlyNumber(input, kind)
    ).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(expected);
  }

  @DisplayName("입력값 길이 테스트")
  @ParameterizedTest
  @CsvSource(value = {"'':3개", "18:3개", "1852:3개"}, delimiter = ':')
  void validValueLengthTest(String input, String expected) {
    String kind = "number";
    assertThatThrownBy(() ->
        player.validLength(input, kind)
    ).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(expected);
  }

  @DisplayName("입력값 중복 체크 테스트")
  @ParameterizedTest
  @CsvSource(value = {"141:중복", "988:중복"}, delimiter = ':')
  void validDuplicateValue(String input, String expected) {
    assertThatThrownBy(() ->
        player.validDuplicate(input)
    ).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(expected);
  }

  @DisplayName("게임 지속 의견 숫자만 입력 여부 테스트")
  @ParameterizedTest
  @CsvSource(value = {"ㅇ:숫자만", "$:숫자만"}, delimiter = ':')
  void validOpinionOnlyNumberTest(String input, String expected) {
    String kind = "opinion";
    assertThatThrownBy(() ->
        player.validOnlyNumber(input, kind)
    ).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(expected);
  }

  @DisplayName("게임 지속 의견 입력값 길이 테스트")
  @ParameterizedTest
  @CsvSource(value = {"'':하나만", "18:하나만"}, delimiter = ':')
  void validOpinionLengthTest(String input, String expected) {
    String kind = "opinion";
    assertThatThrownBy(() ->
        player.validLength(input, kind)
    ).isInstanceOf(IllegalArgumentException.class)
        .hasMessageContaining(expected);
  }

  @DisplayName("컴퓨터가 생성하는 랜덤 숫자 valid 테스트")
  @Test
  void makeRandomNumbersTest() {
    List<Integer> randomNumbers = computer.makeRandomNumbers();
    String computerNumbers = randomNumbers.toString().replaceAll("[^0-9]", "");
    player.validValue(computerNumbers);
  }

  @DisplayName("컴퓨터가 경우에 따라 신규 숫자열을 생성하는지 기존 숫자열을 유지하는지 테스트")
  @ParameterizedTest
  @CsvSource(value = {"1:false", "2:true", "0:true"}, delimiter = ':')
  void getRandomNumberTest(int gameState, boolean expected) {
    List<Integer> preRandomNumbers = computer.makeRandomNumbers();
    List<Integer> nextRandomNumbers = computer.getRandomNumbers(gameState, preRandomNumbers);

    assertThat(preRandomNumbers.equals(nextRandomNumbers)).isEqualTo(expected);
  }

  @DisplayName("스트라이크 카운트 테스트")
  @ParameterizedTest
  @MethodSource("generateData")
  void checkResultTest(List<Integer> randomNumbers, List<Integer> playerNumbers, int expected) {
    assertThat(game.checkResult(randomNumbers, playerNumbers)).isEqualTo(expected);
  }

  static Stream<Arguments> generateData() {
    return Stream.of(
        Arguments.of(Arrays.asList(1, 3, 5), Arrays.asList(1, 3, 5), 3),
        Arguments.of(Arrays.asList(1, 3, 5), Arrays.asList(1, 3, 8), 2),
        Arguments.of(Arrays.asList(1, 3, 5), Arrays.asList(4, 5, 3), 0)
    );
  }
}

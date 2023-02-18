package study.numberbaseballgame2;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import numberbaseballgame.ValidationUtils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class ValidationUtilsTest {
  ValidationUtils validationUtils = new ValidationUtils();

  @DisplayName("숫자_검증")
  @ParameterizedTest
  @CsvSource(value = {"0:false", "1234:false", "112:false", "q12:false" ,"123:true"}, delimiter = ':')
  void validNumberTest(String number, boolean expected) {
    boolean result = validationUtils.validNumber(number);
    assertThat(result).isEqualTo(expected);
  }

  @DisplayName("의견_검증")
  @ParameterizedTest
  @CsvSource(value = {"0:false", "가:false", "1:true" ,"2:true"}, delimiter = ':')
  void validPlayerOpinion(String number, boolean expected) {
    boolean result = validationUtils.validPlayerOpinion(number);
    assertThat(result).isEqualTo(expected);
  }

}

package study.calculator;

import calculator.StringCalculatorVer2;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class StringCalculatorTestVer2 {

    /*
     * 다음 요구사항을 JUnit을 활용해 단위 테스트 코드를 추가해 구현한다.
     * - 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
     * - 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
     * - 예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.
     * 문자열을 입력 받은 후(scanner의 nextLine() 메소드 활용) 빈 공백 문자열을 기준으로 문자들을 분리해야 한다.
     */

    StringCalculatorVer2 calculator = new StringCalculatorVer2();
    String inputValue = "2 + 3 * 4 / 2";

    @Test
    @DisplayName("문자열 공백 제거")
    void splitInputValue() {
        String[] value = calculator.splitInputValue(inputValue, " ");
        assertThat(value).containsExactly("2", "+", "3", "*", "4", "/", "2");
    }

    @Test
    @DisplayName("문자열 입력받고 공백 기준으로 분리해서 숫자 배열에 넣기")
    void inputValueList() {
        List<Integer> valueList = calculator.setValueList(inputValue);
        assertThat(valueList).containsExactly(2, 3, 4, 2);
    }

    @Test
    @DisplayName("문자열 입력받고 공백 기준으로 분리해서 연산자 배열에 넣기")
    void inputOperatorList() {
        List<String> operatorList = calculator.setOperatorList(inputValue);

        assertThat(operatorList).containsExactly("+", "*", "/");
    }

    @ParameterizedTest
    @DisplayName("숫자 외 문자 체크")
    @ValueSource(strings = {"Q", "*", "A"})
    void checkNumber(String number) {
        assertThatThrownBy( () ->
                calculator.checkNumber(number)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("숫자만 가능합니다.");
    }

    @ParameterizedTest
    @DisplayName("사칙연산자 외 문자 체크")
    @ValueSource(strings = {"&", "@", "$", "10", "A"})
    void operatorValidateTest(String operator) {
        assertThatThrownBy( () ->
                calculator.checkOperator(operator)
        ).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("사칙연산자만 가능합니다.");
    }

    @Test
    @DisplayName("더하기")
    void addTest() {
        int totalValue = calculator.add(2, 3);
        assertThat(totalValue).isEqualTo(5);
    }

    @Test
    @DisplayName("빼기")
    void minusTest() {
        int totalValue = calculator.minus(2, 3);
        assertThat(totalValue).isEqualTo(-1);
    }

    @Test
    @DisplayName("곱하기")
    void multiplicationTest() {
        int totalValue = calculator.multiplication(2, 3);
        assertThat(totalValue).isEqualTo(6);
    }

    @Test
    @DisplayName("나누기")
    void divisionTest() {
        int totalValue = calculator.division(4, 2);
        assertThat(totalValue).isEqualTo(2);
    }

    @ParameterizedTest
    @DisplayName("계산2")
    @CsvSource(value = {"2 + 3 * 4 / 2:10", "2 / 2 + 10 - 20:-9", "7 - 3 + 10 * 3 / 2:21"}, delimiter = ':')
    void 어쩌라는(String inputValue, int expected) {
        int totalValue = calculator.cal(inputValue);
        assertThat(totalValue).isEqualTo(expected);
    }




    /*
    * @ParameterizedTest
    * - 여러 매개변수를 이용해 테스트를 여러 번 돌릴 수 있게 한다.
    * - @Test 대신 @ParameterizedTest 를 부착하면 된다.
    * - 최소 하나의 source 어노테이션을 부착해야 한다. (@ValueSource, @NullAndEmptySource 등)
    *
    * @ValueSource(배열이름 = {1, 2, 3, ...})
    * - 배열 내 값을 하나씩 매개변수로 넣어준다.
    * - short, byte, int, long, float, double, char, boolean, String, Class
    *
    * @NullSource
    * - null 을 반환한다.
    *
    * @EmptySource
    * - 비어 있는 배열, 컬렉션, 문자열 등을 반환한다.
    *
    * @NullAndEmptySource
    * - null, 비어 있는 배열, 컬렉션, 문자열 등을 반환한다.
    *
    * @CsvSource
    * - , 를 기준으로 문자열을 분리해 매개변수로 넣어준다.
    * - delimiter = ':' 를 사용하면 ,로 분리된 문자열을 다시 :를 기준으로 분리해준다.
    *
    * 참고
    * https://lannstark.tistory.com/52
     * */



}

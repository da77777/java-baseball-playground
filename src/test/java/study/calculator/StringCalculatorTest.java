package study.calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {

    /*
     * 다음 요구사항을 JUnit을 활용해 단위 테스트 코드를 추가해 구현한다.
     * - 사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
     * - 문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다. 즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
     * - 예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.
     * 문자열을 입력 받은 후(scanner의 nextLine() 메소드 활용) 빈 공백 문자열을 기준으로 문자들을 분리해야 한다.
     */

    public class StringCalculator {

        public int add(int totalValue, int value) {
            return totalValue + value;
        }

        public int minus(int totalValue, int value) {
            return totalValue - value;
        }

        public int multiplication(int totalValue, int value) {
            return totalValue * value;
        }

        public int division(int totalValue, int value) {
            return totalValue / value;
        }

        public int cal(int totalValue, String operator, int value) {
            switch (operator) {
                case "+" :
                    totalValue = add(totalValue, value);
                    break;
                case "-" :
                    totalValue = minus(totalValue, value);
                    break;
                case "*" :
                    totalValue = multiplication(totalValue, value);
                    break;
                case "/" :
                    totalValue = division(totalValue, value);
                    break;
            }

            return totalValue;
        }

        public List<Integer> setValueList(String value) {
            String[] values = value.split(" ");
            List<Integer> intList = new ArrayList<>();
            for(int i = 0; i < values.length; i++) {
                if(i % 2 == 0) {
                    intList.add(Integer.valueOf(values[i]));
                }
            }
            return intList;
        }

        public List<String> setOperatorList(String value) {
            String[] values = value.split(" ");
            List<String> operatorList = new ArrayList<>();
            for(int i = 0; i < values.length; i++) {
                if(i % 2 != 0) {
                    operatorList.add(values[i]);
                }
            }
            return operatorList;
        }
    }

    StringCalculator calculator;
    String inputValue = null;

    //ByteArrayInputStream

    @BeforeEach
    void setUp() {
        calculator = new StringCalculator();
        inputValue = "2 + 3 * 4 / 2";
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

    @Test
    @DisplayName("계산 테스트")
    void 어쩌라느뇽() {
        List<Integer> valueList = calculator.setValueList(inputValue);
        List<String> operatorList = calculator.setOperatorList(inputValue);
        int totalValue = valueList.get(0);
        
        for(int i = 0; i < valueList.size()-1; i++) {
            totalValue = calculator.cal(totalValue, operatorList.get(i), valueList.get(i+1));
        }

        assertThat(totalValue).isEqualTo(10);
    }

}

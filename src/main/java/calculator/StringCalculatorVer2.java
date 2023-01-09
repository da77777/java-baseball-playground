package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class StringCalculatorVer2 {

    private static final String WORD_SPACING = " ";
    private static final String NUMBER_REG = "^[0-9]*$";

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

    public int arithmetic(int totalValue, String operator, int value) {
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

    public int cal(String inputValue) {
        List<Integer> valueList = setValueList(inputValue);
        List<String> operatorList = setOperatorList(inputValue);
        int totalValue = valueList.get(0);

        for(int i = 0; i < valueList.size()-1; i++) {
            totalValue = arithmetic(totalValue, operatorList.get(i), valueList.get(i+1));
        }
        return totalValue;
    }

    public String[] splitInputValue(String value, String reg) {
        return value.split(reg);
    }

    public void checkNumber(String number) {
        if(!Pattern.matches(NUMBER_REG, number)) {
            throw new IllegalArgumentException("숫자만 가능합니다.");
        }
    }

    public void checkOperator(String operator) {
        String[] operatorList = {"+", "-", "*", "/"};
        if(!Arrays.asList(operatorList).contains(operator)) {
            throw new IllegalArgumentException("사칙연산자만 가능합니다.");
        }
    }

    public List<Integer> setValueList(String value) {
        String[] values = splitInputValue(value, WORD_SPACING);
        List<Integer> intList = new ArrayList<>();
        for(int i = 0; i < values.length; i++) {
            if(i % 2 == 0) {
                checkNumber(values[i]);
                intList.add(Integer.valueOf(values[i]));
            }
        }
        return intList;
    }

    public List<String> setOperatorList(String value) {
        String[] values = splitInputValue(value, WORD_SPACING);
        List<String> operatorList = new ArrayList<>();
        for(int i = 0; i < values.length; i++) {
            if(i % 2 != 0) {
                checkOperator(values[i]);
                operatorList.add(values[i]);
            }
        }
        return operatorList;
    }
}

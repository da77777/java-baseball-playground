package numberbaseballgame;

import java.util.ArrayList;
import java.util.List;

public class ValidationUtils {
  private static final int NUMBER_LENGTH = 3;

  public static boolean validNumber(String number) {
    try {
      List<Integer> numbers = numberSplit(number);
      return validNumber(numbers);
    } catch (Exception e) {
      return false;
    }
  }

  private static List<Integer> numberSplit(String number) {
    List<Integer> numbers = new ArrayList<>();
    String[] splitNumber = number.split("");
    for(int i = 0; i < splitNumber.length; i++) {
      numbers.add(Integer.valueOf(splitNumber[i]));
    }
    return numbers;
  }

  private static boolean validNumber(List<Integer> numbers) {
    if(validNumberLength(numbers)
        && validNumberRange(numbers)
        && validNumberNotDuplicate(numbers)) {
      return true;
    }
    return false;
  }

  private static boolean validNumberRange(List<Integer> numbers) {
    int count = (int) numbers.stream()
        .filter(num -> (num >= 1 && num <= 9))
        .count();
    if(count < NUMBER_LENGTH) {
      System.out.println("1부터 9까지의 숫자만 입력해주세요.");
      return false;
    }
    return true;
  }

  private static boolean validNumberLength(List<Integer> numbers) {
    if(numbers.size() != NUMBER_LENGTH) {
      System.out.println("숫자 " + NUMBER_LENGTH + "개를 입력해주세요.");
      return false;
    }
    return true;
  }

  private static boolean validNumberNotDuplicate(List<Integer> numbers) {
    if(numbers.size() != numbers.stream().distinct().count()) {
      System.out.println("숫자가 중복되지 않도록 입력해주세요.");
      return false;
    }
    return true;
  }

  public static boolean validPlayerOpinion(String opinion) {
    if(!(opinion.equals("1") || opinion.equals("2"))) {
      return false;
    }
    return true;
  }


}

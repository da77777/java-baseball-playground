package numberbaseballgame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
  private ValidationUtils validationUtils = new ValidationUtils();
  private final static InputView instance = new InputView();
  private final Scanner sc = new Scanner(System.in);

  private InputView() {}

  public static InputView getInstance() {
    return instance;
  }

  public String inputAnswer() {
    return sc.nextLine();
  }

  public void closeAnswer() {
    sc.close();
  }

  public List<Integer> playerNumber() {
    String number = null;
    boolean flag = false;
    while(!flag) {
      System.out.print("숫자를 입력해 주세요 : ");
      number = inputAnswer();
      flag = validationUtils.validNumber(number);
    }

    String[] numbers = number.split("");
    List<Integer> playerNumbers = new ArrayList<>();
    for (String n : numbers) {
      playerNumbers.add(Integer.valueOf(n));
    }

    return playerNumbers;
  }

  public StateEnum playerOpinion() {
    String opinion = null;
    boolean flag = false;
    while(!flag) {
      System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
      opinion = inputAnswer();
      flag = validationUtils.validPlayerOpinion(opinion);
    }
    if(opinion.equals("1")) {
      return StateEnum.NEW;
    }
    return StateEnum.END;
  }

}

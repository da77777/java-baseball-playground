package numberbaseballgame;

import java.util.Scanner;

public class InputView {

    //Scanner sc = new Scanner(System.in);


    private final static InputView instance = new InputView();
    private final Scanner sc = new Scanner(System.in);

    private InputView() {}

    public static InputView getInstance() {
        return instance;
    }

    public void inputNumber() {
        System.out.print("숫자를 입력해 주세요 : ");
    }

    public String inputAnswer() {
        return sc.nextLine();
    }

    public void closeAnswer() {
        sc.close();
    }
}
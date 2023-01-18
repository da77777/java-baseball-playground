package numberbaseballgame;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Player {
    final InputView inputView = InputView.getInstance();

    private static final int NUMBER_LENGTH = 3;
    private static final int PLAYER_OPINION_LENGTH = 1;
    private static final String NUMBER = "number";
    private static final String OPINION = "opinion";

    public List<Integer> playerNumbers() {
        String inputNumber = null;
        boolean flag = false;
        while(flag == false) {
            inputView.inputNumber();
            inputNumber = inputView.inputAnswer();
            flag = validValue(inputNumber);
        }
        return generateNumbers(inputNumber);
    }

    public int checkPlayerOpinion() {
        String opinion = null;
        boolean flag = false;
        while(flag == false) {
            opinion = inputView.inputAnswer();
            flag = validOpinion(opinion);
        }
        if(opinion.equals("1")) {
            return StateEnum.NEW_GAME.state();
        }
        return StateEnum.END_GAME.state();
    }

    public List<Integer> generateNumbers(String inputNumber) {
        List<Integer> numbers = new ArrayList();
        String[] splitNumbers = inputNumber.split("");
        for(String number : splitNumbers) {
            numbers.add(Integer.valueOf(number));
        }
        return numbers;
    }

    public boolean validValue(String inputNumber) {
        String kind = NUMBER;
        try {
            validOnlyNumber(inputNumber, kind);
            validLength(inputNumber, kind);
            validDuplicate(inputNumber);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean validOpinion(String opinion) {
        String kind = OPINION;
        try {
            validOnlyNumber(opinion, kind);
            validLength(opinion, kind);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void validOnlyNumber(String input, String kind) {
        if(kind.equals(NUMBER) && !Pattern.matches("^[1-9]*$", input)) {
            throw new IllegalArgumentException("1부터 9까지의 숫자만 입력해주세요.");
        }
        if(kind.equals(OPINION) && !Pattern.matches("^[1-2]*$", input)) {
            throw new IllegalArgumentException("1부터 2까지의 숫자만 입력해주세요.");
        }
    }

    public void validLength(String input, String kind) {
        if(kind.equals(NUMBER) && input.length() != NUMBER_LENGTH) {
            throw new IllegalArgumentException("숫자 3개를 입력해주세요.");
        }
        if(kind.equals(OPINION) && input.length() != PLAYER_OPINION_LENGTH) {
            throw new IllegalArgumentException("1혹은 2 중 하나만 입력해주세요.");
        }
    }

    public void validDuplicate(String inputNumber) {
        Set<String> numbers = new HashSet<>();
        String[] splitNumbers = inputNumber.split("");
        for (String number : splitNumbers) {
            numbers.add(number);
        }
        if(numbers.size() != NUMBER_LENGTH) {
            throw new IllegalArgumentException("숫자가 중복되지 않도록 입력해주세요.");
        }
    }

}

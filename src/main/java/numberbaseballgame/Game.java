package numberbaseballgame;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Game {

  private ResultView resultView = new ResultView();
  private InputView inputView = InputView.getInstance();

  public void play() {
    StateEnum state = StateEnum.NEW;
    Balls comBalls = null;
    Result result = null;
    while(state != StateEnum.END) {
      comBalls = getRandomNumbers(state, comBalls);
      result = comBalls.playResult(new Balls(inputView.playerNumber()));
      resultView.printResult(result);
      state = gameState(result);
    }
    inputView.closeAnswer();
  }

  private StateEnum gameState(Result result) {
    if(result.getStrike() == 3) {
      return inputView.playerOpinion();
    }
    return StateEnum.KEEP;
  }

  public Balls getRandomNumbers(StateEnum state, Balls preNumbers) {
    if(state.equals(StateEnum.NEW)) {
      return makeRandomNumbers();
    }
    return preNumbers;
  }

  private Balls makeRandomNumbers() {
    Set<Integer> randomNumbers = new HashSet<>();
    while (randomNumbers.size() < 3) {
      int number = (int) (Math.random() * 9 + 1);
      randomNumbers.add(number);
    }

    List<Integer> numbers = new ArrayList<>();
    for (Integer randomNumber : randomNumbers) {
      numbers.add(randomNumber);
    }

    System.out.println("테스트용 출력 " + numbers);

    Balls balls = new Balls(numbers);
    return balls;
  }

}

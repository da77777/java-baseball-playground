package numberbaseballgame;

import java.util.List;

public class Game {

    private final InputView inputView = InputView.getInstance();
    private ResultVIew resultVIew = new ResultVIew();
    private Computer computer = new Computer();
    private Player player = new Player();

    private static final int NUMBER_LENGTH = 3;

    public void play() {
        List<Integer> randomNumbers = null;
        int gameState = StateEnum.NEW_GAME.state();
        while(!(gameState == StateEnum.END_GAME.state())) {
            randomNumbers = computer.getRandomNumbers(gameState, randomNumbers);
            List<Integer> playerNumbers = player.playerNumbers();
            gameState = checkGameState(checkResult(randomNumbers, playerNumbers));
        }
        inputView.closeAnswer();
    }

    public int checkResult(List<Integer> randomNumbers, List<Integer> playerNumbers) {

        int ballCount = 0;
        for(int i = 0; i < NUMBER_LENGTH; i++) {
            ballCount = ballCount + checkBall(randomNumbers, playerNumbers.get(i));
        }

        int strikeCount = 0;
        for(int i = 0; i < NUMBER_LENGTH; i++) {
            strikeCount = strikeCount + checkStrike(randomNumbers, playerNumbers.get(i), i);
        }

        resultVIew.outputValueBallStrike(ballCount, strikeCount);

        return strikeCount;
    }

    public int checkGameState(int strikeCount) {
        int gameState = StateEnum.KEEP_GOING.state();
        if(strikeCount == 3) {
            gameState = player.checkPlayerOpinion();
        }
        return gameState;
    }

    private int checkBall(List<Integer> randomNumbers, int number) {
        if(randomNumbers.contains(number)) {
            return 1;
        }
        return 0;
    }

    private int checkStrike(List<Integer> randomNumbers, int number, int numberIndex) {
        if(randomNumbers.get(numberIndex) == number) {
            return 1;
        }
        return 0;
    }

}

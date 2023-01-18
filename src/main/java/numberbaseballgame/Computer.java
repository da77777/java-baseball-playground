package numberbaseballgame;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Computer {
    private static final int NEW_GAME = 1;

    public List<Integer> getRandomNumbers(int make, List<Integer> preNumbers) {
        if(make == NEW_GAME) {
            return makeRandomNumbers();
        }
        return preNumbers;
    }

    public List<Integer> makeRandomNumbers() {
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

        return numbers;
    }
}

package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

public class MediumBot extends HAL9000 {
  public MediumBot(Choice playerChoice) {
    super(new RandomStrategy(), Difficulty.MEDIUM, playerChoice);
  }

  @Override
  public int play() {
    roundCount++;
    if (roundCount == 4) {
      setStrategy(new TopStrategy(evenCount, oddCount, playerChoice));
    }
    return strategy.getFingers();
  }
}

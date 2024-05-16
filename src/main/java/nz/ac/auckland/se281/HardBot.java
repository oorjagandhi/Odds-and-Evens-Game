package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

public class HardBot extends HAL9000 {
  public HardBot(Choice playerChoice) {
    super(new RandomStrategy(), Difficulty.HARD, playerChoice);
  }

  @Override
  public int play() {
    roundCount++;
    if (roundCount > 3) {
      if (!lastRoundWon) {
        if (this.strategy instanceof TopStrategy) {
          setStrategy(new RandomStrategy());
        } else {
          setStrategy(new TopStrategy(evenCount, oddCount, playerChoice));
        }
      }
    }
    return strategy.getFingers();
  }
}

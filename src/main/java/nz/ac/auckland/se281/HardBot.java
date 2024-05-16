package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the HardBot in the game. */
public class HardBot extends HAL9000 {
  public HardBot(Choice playerChoice) {
    super(new RandomStrategy(), Difficulty.HARD, playerChoice);
  }

  /**
   * Play a round of the game.
   *
   * @return The number of fingers played.
   */
  @Override
  public int play() {
    roundCount++;

    // After three rounds, check if the last round was lost. If it was, change the strategy.
    if (roundCount > 3) {
      if (!lastRoundWon) {
        if (this.strategy instanceof TopStrategy) {
          // If the last strategy was TopStrategy, change to RandomStrategy
          setStrategy(new RandomStrategy());
        } else {
          // If the last strategy was RandomStrategy, change to TopStrategy
          setStrategy(new TopStrategy(evenCount, oddCount, playerChoice));
        }
      }
    }
    return strategy.getFingers();
  }
}

package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

public class HAL9000 {
  private Strategy strategy;
  private Strategy randomStrategy = new RandomStrategy();
  private int evenCount;
  private int oddCount;
  private int roundCount;
  private Difficulty difficulty;
  private Choice playerChoice;
  private boolean lastRoundWon;

  public HAL9000(Strategy strategy, Difficulty difficulty, Choice playerChoice) {
    this.strategy = strategy;
    this.evenCount = 0;
    this.oddCount = 0;
    this.roundCount = 0;
    this.difficulty = difficulty;
    this.playerChoice = playerChoice;
    this.lastRoundWon = false;
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  public int play() {
    this.roundCount++;
    switch (this.difficulty) {
      case MEDIUM:
        if (this.roundCount == 4) { // Switch to TopStrategy on the fourth round
          this.strategy = new TopStrategy(evenCount, oddCount, playerChoice);
        }
        break;
      case HARD:
        if (this.roundCount > 3) { // After the third round, decide based on the last round
          if (!lastRoundWon) { // Switch strategy if HAL9000 lost the last round
            if (this.strategy instanceof TopStrategy) {
              // If the current strategy is TopStrategy, switch to RandomStrategy
              this.strategy = randomStrategy;
            } else {
              // If the current strategy is not TopStrategy, switch to a new instance of TopStrategy
              this.strategy = new TopStrategy(evenCount, oddCount, playerChoice);
            }
          }
        }
        break;
      case EASY:
      default:
        // EASY always uses RandomStrategy, no change needed
        break;
    }
    return strategy.getFingers();
  }

  public void updateCounts(int fingers, boolean won) {
    if (fingers % 2 == 0) {
      evenCount++;
    } else {
      oddCount++;
    }

    this.lastRoundWon = won;
  }

  public void reset() {
    evenCount = 0;
    oddCount = 0;
    roundCount = 0;
    this.strategy = new RandomStrategy();
  }

  public boolean shouldSwitchStrategy() {
    return roundCount == 4;
  }
}

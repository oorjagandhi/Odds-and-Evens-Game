package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class HAL9000 {
  private Strategy strategy;
  private int evenCount;
  private int oddCount;
  private int roundCount;
  private Difficulty difficulty;

  public HAL9000(Strategy strategy, Difficulty difficulty) {
    this.strategy = strategy;
    this.evenCount = 0;
    this.oddCount = 0;
    this.roundCount = 0;
    this.difficulty = difficulty;
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  public int play() {
    this.roundCount++;
    if (difficulty == Difficulty.MEDIUM && roundCount == 4) {
      setStrategy(new TopStrategy(evenCount, oddCount));
    }
    return strategy.getFingers();
  }

  public void updateCounts(int fingers) {
    if (fingers % 2 == 0) {
      evenCount++;
    } else {
      oddCount++;
    }
  }

  public void reset() {
    evenCount = 0;
    oddCount = 0;
    roundCount = 0;
  }

  public boolean shouldSwitchStrategy() {
    return roundCount == 4;
  }
}

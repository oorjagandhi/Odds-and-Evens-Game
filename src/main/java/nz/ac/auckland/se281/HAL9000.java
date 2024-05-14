package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the AI in the game. It uses a strategy to play the game. */
public class HAL9000 implements GameParticipant {
  private Strategy strategy;
  private Strategy randomStrategy = new RandomStrategy();
  private int evenCount;
  private int oddCount;
  private int roundCount;
  private int winCount;
  private Difficulty difficulty;
  private Choice playerChoice;
  private boolean lastRoundWon;

  /**
   * Create a new instance of HAL9000.
   *
   * @param strategy The strategy to use.
   * @param difficulty The difficulty of the AI.
   * @param playerChoice The player's choice.
   */
  public HAL9000(Strategy strategy, Difficulty difficulty, Choice playerChoice) {
    this.strategy = strategy;
    this.evenCount = 0;
    this.oddCount = 0;
    this.roundCount = 0;
    this.winCount = 0;
    this.difficulty = difficulty;
    this.playerChoice = playerChoice;
    this.lastRoundWon = false;
  }

  /**
   * Set the strategy to use.
   *
   * @param strategy The strategy to use.
   */
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  /**
   * Get the strategy being used.
   *
   * @return The strategy being used.
   */
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

  /**
   * Update the counts based on the result of the last round.
   *
   * @param fingers The number of fingers played.
   * @param won Whether the AI won the last round.
   */
  public void updateCounts(int fingers, boolean won) {
    if (fingers % 2 == 0) {
      evenCount++;
    } else {
      oddCount++;
    }

    this.lastRoundWon = won;
    if (won) {
      this.winCount++; // Increment win counter if HAL9000 won the round
    }
  }

  /** Reset the counts and round number. */
  public void reset() {
    evenCount = 0;
    oddCount = 0;
    roundCount = 0;
    winCount = 0;
    this.strategy = new RandomStrategy();
  }

  /**
   * Check if the strategy should be switched.
   *
   * @return Whether the strategy should be switched.
   */
  public boolean shouldSwitchStrategy() {
    return roundCount == 4;
  }

  /**
   * Get the number of wins.
   *
   * @return The number of wins.
   */
  public int getWinCount() {
    return this.winCount;
  }
}

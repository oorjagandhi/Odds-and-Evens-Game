package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the AI in the game. It uses a strategy to play the game. */
public abstract class HAL9000 implements GameParticipant, Bot {
  protected Strategy strategy;
  protected Strategy randomStrategy = new RandomStrategy();
  protected int evenCount;
  protected int oddCount;
  protected int roundCount;
  protected int winCount;
  protected Difficulty difficulty;
  protected Choice playerChoice;
  protected boolean lastRoundWon;

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
  @Override
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

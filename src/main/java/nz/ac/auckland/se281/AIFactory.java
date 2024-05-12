package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

public class AIFactory {

  /**
   * Create an AI based on the difficulty and player choice.
   *
   * @param difficulty The difficulty of the AI.
   * @param playerChoice The player's choice.
   * @return The AI.
   */
  public static HAL9000 createAi(Difficulty difficulty, Choice playerChoice) {
    switch (difficulty) {
      case MEDIUM:
        return new HAL9000(new RandomStrategy(), Difficulty.MEDIUM, playerChoice);
      case HARD:
        return new HAL9000(new RandomStrategy(), Difficulty.HARD, playerChoice);
      case EASY:
        // Default to EASY
      default:
        return new HAL9000(new RandomStrategy(), Difficulty.EASY, playerChoice);
    }
  }
}

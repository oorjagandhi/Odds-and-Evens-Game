package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/**
 * This class represents the AI Factory that creates an AI based on the difficulty and player
 * choice.
 */
public class AIFactory {

  /**
   * Create an AI based on the difficulty and player choice.
   *
   * @param difficulty The difficulty of the AI.
   * @param playerChoice The player's choice.
   * @return The AI.
   */
  public static Bot createAi(Difficulty difficulty, Choice playerChoice) {
    switch (difficulty) {
      case MEDIUM:
        return new MediumBot(playerChoice);
      case HARD:
        return new HardBot(playerChoice);
      case EASY:
        // Default to EASY
      default:
        return new EasyBot(playerChoice);
    }
  }
}

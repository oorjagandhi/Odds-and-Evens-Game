package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

public class AIFactory {

  public static HAL9000 createAI(Difficulty difficulty, Choice playerChoice) {
    switch (difficulty) {
      case MEDIUM:
        return new HAL9000(new RandomStrategy(), Difficulty.MEDIUM, playerChoice);
      case HARD:
        return new HAL9000(new RandomStrategy(), Difficulty.HARD, playerChoice);
      case EASY:
      default:
        return new HAL9000(new RandomStrategy(), Difficulty.EASY, playerChoice);
    }
  }
}

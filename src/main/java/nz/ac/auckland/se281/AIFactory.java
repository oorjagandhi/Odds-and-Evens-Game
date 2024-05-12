package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class AIFactory {

  public static HAL9000 createAI(Difficulty difficulty) {
    switch (difficulty) {
      case MEDIUM:
        return new HAL9000(new RandomStrategy(), Difficulty.MEDIUM);
      case HARD:
        return new HAL9000(new RandomStrategy(), Difficulty.HARD);
      case EASY:
      default:
        return new HAL9000(new RandomStrategy(), Difficulty.EASY);
    }
  }
}

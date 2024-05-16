package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

public class EasyBot extends HAL9000 {

  public EasyBot(Choice playerChoice) {
    super(new RandomStrategy(), Difficulty.EASY, playerChoice);
  }

  @Override
  public int play() {
    roundCount++;
    // Easy AI logic, possibly simplistic or random
    return strategy.getFingers();
  }
}

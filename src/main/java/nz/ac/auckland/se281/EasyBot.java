package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the EasyBot in the game. */
public class EasyBot extends HAL9000 {

  /**
   * The constructor for the EasyBot class.
   *
   * @param playerChoice The player's choice.
   */
  public EasyBot(Choice playerChoice) {
    super(new RandomStrategy(), Difficulty.EASY, playerChoice);
  }

  /**
   * Play a round of the game.
   *
   * @return The number of fingers played.
   */
  @Override
  public int play() {
    roundCount++;
    // Easy AI logic, possibly simplistic or random
    return strategy.getFingers();
  }
}

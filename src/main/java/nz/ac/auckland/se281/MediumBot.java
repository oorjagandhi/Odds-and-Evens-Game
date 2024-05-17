package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the MediumBot in the game. */
public class MediumBot extends HAL9000 {

  /**
   * The constructor for the MediumBot class.
   *
   * @param playerChoice The player's choice.
   */
  public MediumBot(Choice playerChoice) {
    super(new RandomStrategy(), Difficulty.MEDIUM, playerChoice);
  }

  /**
   * Play a round of the game.
   *
   * @return The number of fingers played.
   */
  @Override
  public int play() {
    roundCount++;
    if (roundCount > 3) {
      setStrategy(new TopStrategy(evenCount, oddCount, playerChoice));
    }
    return strategy.getFingers();
  }
}

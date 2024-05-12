package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

/** This class represents the TopStrategy that implements the Strategy interface. */
public class TopStrategy implements Strategy {
  private int evenCount;
  private int oddCount;
  private Choice playerChoice;

  /**
   * Create a new instance of TopStrategy.
   *
   * @param evenCount The number of even numbers played.
   * @param oddCount The number of odd numbers played.
   * @param choice The player's choice.
   */
  public TopStrategy(int evenCount, int oddCount, Choice choice) {
    this.evenCount = evenCount;
    this.oddCount = oddCount;
    this.playerChoice = choice;
  }

  /**
   * Get the number of fingers to play.
   *
   * @return The number of fingers to play.
   */
  @Override
  public int getFingers() {
    // Generate a random even or odd number based on historical data
    if (playerChoice == Choice.EVEN) {
      if (evenCount > oddCount) {
        return 1 + Utils.getRandomNumberRange(0, 2) * 2; // 1, 3, or 5
      } else if (oddCount > evenCount) {
        return Utils.getRandomNumberRange(0, 2) * 2; // 0, 2, or 4
      } else {
        return Utils.getRandomNumberRange(0, 5); // No clear trend, pick any
      }
    } else {
      if (oddCount > evenCount) {
        return 1 + Utils.getRandomNumberRange(0, 2) * 2; // 1, 3, or 5
      } else if (evenCount > oddCount) {
        return Utils.getRandomNumberRange(0, 2) * 2; // 0, 2, or 4
      } else {
        return Utils.getRandomNumberRange(0, 5); // No clear trend, pick any
      }
    }
  }
}

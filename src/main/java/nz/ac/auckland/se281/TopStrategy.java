package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;

public class TopStrategy implements Strategy {
  private int evenCount;
  private int oddCount;
  private Choice playerChoice;

  public TopStrategy(int evenCount, int oddCount, Choice choice) {
    this.evenCount = evenCount;
    this.oddCount = oddCount;
    this.playerChoice = choice;
  }

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
        return Utils.getRandomNumberRange(0, 2) * 2; // 1, 3, or 5
      } else if (evenCount > oddCount) {
        return Utils.getRandomNumberRange(0, 2) * 2; // 0, 2, or 4
      } else {
        return Utils.getRandomNumberRange(0, 5); // No clear trend, pick any
      }
    }
  }
}

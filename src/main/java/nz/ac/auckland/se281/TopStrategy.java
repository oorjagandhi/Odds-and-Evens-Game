package nz.ac.auckland.se281;

public class TopStrategy implements Strategy {
  private int evenCount;
  private int oddCount;

  public TopStrategy(int evenCount, int oddCount) {
    this.evenCount = evenCount;
    this.oddCount = oddCount;
  }

  @Override
  public int getFingers() {
    // Generate a random even or odd number based on historical data
    if (evenCount > oddCount) {
      return Utils.getRandomNumberRange(0, 2) * 2; // 0, 2, or 4
    } else if (oddCount > evenCount) {
      return 1 + Utils.getRandomNumberRange(0, 2) * 2; // 1, 3, or 5
    } else {
      return Utils.getRandomNumberRange(0, 5); // No clear trend, pick any
    }
  }
}

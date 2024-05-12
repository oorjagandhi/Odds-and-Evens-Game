package nz.ac.auckland.se281;

/** This class represents the RandomStrategy that implements the Strategy interface. */
public class RandomStrategy implements Strategy {

  /**
   * Get the number of fingers to play.
   *
   * @return The number of fingers to play.
   */
  @Override
  public int getFingers() {
    int randomNum;
    randomNum = Utils.getRandomNumberRange(0, 5);
    return randomNum;
  }
}

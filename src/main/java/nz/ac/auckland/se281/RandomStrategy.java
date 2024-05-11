package nz.ac.auckland.se281;

public class RandomStrategy implements Strategy {

  @Override
  public int getAction() {
    int randomNum;
    randomNum = Utils.getRandomNumberRange(0, 5);
    return randomNum;
  }
}

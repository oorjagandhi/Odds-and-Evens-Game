package nz.ac.auckland.se281;

public class HAL9000 {
  private Strategy strategy;

  public HAL9000(Strategy strategy) {
    this.strategy = strategy;
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }

  public int play() {
    return strategy.getAction();
  }
}

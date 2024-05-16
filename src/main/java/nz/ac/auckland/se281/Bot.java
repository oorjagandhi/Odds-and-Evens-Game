package nz.ac.auckland.se281;

public interface Bot {
  // Define methods here

  /**
   * Get the difficulty level.
   *
   * @return The difficulty level.
   */
  public int play();

  public void reset();

  public int getWinCount();

  public void updateCounts(int fingers, boolean won);
}

package nz.ac.auckland.se281;

/** This interface represents the Bot in the game. */
public interface Bot {
  // Define methods here

  /**
   * Play a round of the game.
   *
   * @return The number of fingers played.
   */
  public int play();

  /** Reset the bot. */
  public void reset();

  /**
   * Get the win count.
   *
   * @return The number of wins.
   */
  public int getWinCount();

  /**
   * Update the counts.
   *
   * @param fingers The number of fingers played.
   * @param won Whether the bot won or not.
   */
  public void updateCounts(int fingers, boolean won);
}

package nz.ac.auckland.se281;

/** This interface represents the Bot in the game. */
public interface Bot {
  // Define methods here

  /**
   * Play a round of the game, returning the number of fingers played.
   *
   * @return The number of fingers played.
   */
  public int play();

  /** This method resets the bot by setting all counts to zero and the strategy to Random. */
  public void reset();

  /**
   * Get the win count of the bot, based on the fingers played and whether the bot won or not.
   *
   * @return The number of wins.
   */
  public int getWinCount();

  /**
   * Update the counts of the bot, based on the fingers played and whether the bot won or not.
   *
   * @param fingers The number of fingers played.
   * @param won Whether the bot won or not.
   */
  public void updateCounts(int fingers, boolean won);
}

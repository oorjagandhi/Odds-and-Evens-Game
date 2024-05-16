package nz.ac.auckland.se281;

/** This interface represents the GameParticipant in the game. */
public interface GameParticipant {

  /**
   * Play a round of the game.
   *
   * @return The number of fingers played.
   */
  public int play();
}

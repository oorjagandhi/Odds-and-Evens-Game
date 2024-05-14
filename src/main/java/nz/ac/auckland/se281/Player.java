package nz.ac.auckland.se281;

/** This class represents the player in the game. */
public class Player implements GameParticipant {

  /**
   * Play a round of the game.
   *
   * @return The player's choice.
   */
  public int play() {
    MessageCli.ASK_INPUT.printMessage();

    int input = Utils.scanner.nextInt();

    while (input < 0 || input > 5) {
      MessageCli.INVALID_INPUT.printMessage();
      input = Utils.scanner.nextInt();
    }

    return input;
  }
}

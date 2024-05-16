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

    int input = getInput();

    while (input < 0 || input > 5) {
      MessageCli.INVALID_INPUT.printMessage();
      input = getInput();
    }

    return input;
  }

  /**
   * Get the player's input.
   *
   * @return The player's input.
   */
  private int getInput() {
    String input = Utils.scanner.nextLine();

    // Check if the input is an integer
    if (Utils.isInteger(input)) {
      return Integer.parseInt(input);
    } else {
      return -1; // Invalid input
    }
  }
}

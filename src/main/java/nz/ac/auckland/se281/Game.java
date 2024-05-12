package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  private int roundNumber;
  private String playerName;
  private Choice playerChoice;
  private HAL9000 hal9000;

  /**
   * Start a new game.
   *
   * @param difficulty
   * @param choice
   * @param options
   */
  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // Reset the game
    this.roundNumber = 0;

    this.playerChoice = choice;
    this.playerName = options[0];

    // Create the AI based on the difficulty and choice
    this.hal9000 = AIFactory.createAi(difficulty, choice);
    this.hal9000.reset();

    // Welcome the player
    MessageCli.WELCOME_PLAYER.printMessage(playerName);
  }

  /** Play a round of the game. */
  public void play() {
    this.roundNumber++;
    MessageCli.START_ROUND.printMessage(String.valueOf(this.roundNumber));

    Player player = new Player();

    int playerAction = player.play();
    int hal9000Action = hal9000.play();

    MessageCli.PRINT_INFO_HAND.printMessage(playerName, Integer.toString(playerAction));
    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", Integer.toString(hal9000Action));

    // Determine the winner
    int sum = playerAction + hal9000Action;
    Choice sumOddOrEven = (sum % 2 == 0) ? Choice.EVEN : Choice.ODD;

    boolean playerWins = (playerChoice == sumOddOrEven);
    hal9000.updateCounts(playerAction, !playerWins);

    if (playerChoice == sumOddOrEven) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(
          Integer.toString(sum), sumOddOrEven.name(), playerName);
    } else {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage(
          Integer.toString(sum), sumOddOrEven.name(), "HAL-9000");
    }
  }

  public void endGame() {}

  public void showStats() {}
}

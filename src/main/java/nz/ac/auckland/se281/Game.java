package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  private int roundNumber;
  private String playerName;
  private Choice playerChoice;
  private HAL9000 hal9000;
  private boolean gameHasStarted;
  private int playerWinCount;

  /**
   * The new game method is called to start a new game of Odds and Evens.
   *
   * @param difficulty The difficulty of the AI.
   * @param choice The player's choice (even or odd).
   * @param options The player's name and other options.
   */
  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // Reset the game
    this.roundNumber = 0;

    this.playerChoice = choice;
    this.playerName = options[0];

    gameHasStarted = true;
    playerWinCount = 0;

    // Create the AI based on the difficulty and choice
    this.hal9000 = AIFactory.createAi(difficulty, choice);
    this.hal9000.reset();

    // Welcome the player
    MessageCli.WELCOME_PLAYER.printMessage(playerName);
  }

  /** Play a round of the game. */
  public void play() {
    if (gameHasStarted) {
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

      if (playerWins) {
        playerWinCount++;
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(
            Integer.toString(sum), sumOddOrEven.name(), playerName);
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(
            Integer.toString(sum), sumOddOrEven.name(), "HAL-9000");
      }
    } else {
      MessageCli.GAME_NOT_STARTED.printMessage();
    }
  }

  public void endGame() {
    showStats();
    if (playerWinCount > hal9000.getWinCount()) {
      MessageCli.PRINT_END_GAME.printMessage(playerName);
    } else {
      MessageCli.PRINT_END_GAME.printMessage("HAL-9000");
    }
    gameHasStarted = false;
  }

  public void showStats() {
    int hal9000WinCount = hal9000.getWinCount();

    if (gameHasStarted) {
      MessageCli.PRINT_PLAYER_WINS.printMessage(
          playerName,
          Integer.toString(playerWinCount),
          Integer.toString(roundNumber - playerWinCount));

      MessageCli.PRINT_PLAYER_WINS.printMessage(
          "HAL-9000",
          Integer.toString(hal9000WinCount),
          Integer.toString(roundNumber - hal9000WinCount));
    } else {
      MessageCli.GAME_NOT_STARTED.printMessage();
    }
  }
}

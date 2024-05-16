package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  private int roundNumber;
  private String playerName;
  private Choice playerChoice;
  private Bot bot;
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
    this.bot = AIFactory.createAi(difficulty, choice);
    this.bot.reset();

    // Welcome the player
    MessageCli.WELCOME_PLAYER.printMessage(playerName);
  }

  /** Play a round of the game. */
  public void play() {
    // Check if the game has started
    if (gameHasStarted) {
      // Increment the round number
      this.roundNumber++;
      MessageCli.START_ROUND.printMessage(String.valueOf(this.roundNumber));

      // Create the player
      Player player = new Player();

      // Play the moves for the player and HAL-9000
      int playerAction = player.play();
      int hal9000Action = bot.play();

      // Print the moves
      MessageCli.PRINT_INFO_HAND.printMessage(playerName, Integer.toString(playerAction));
      MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", Integer.toString(hal9000Action));

      // Determine the winner
      int sum = playerAction + hal9000Action;
      Choice sumOddOrEven = (sum % 2 == 0) ? Choice.EVEN : Choice.ODD;

      boolean playerWins = (playerChoice == sumOddOrEven);
      bot.updateCounts(playerAction, !playerWins);

      // Print the outcome of the round
      if (playerWins) {
        playerWinCount++;
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(
            Integer.toString(sum), sumOddOrEven.name(), playerName);
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(
            Integer.toString(sum), sumOddOrEven.name(), "HAL-9000");
      }
    } else {
      // Print that the game has not started
      MessageCli.GAME_NOT_STARTED.printMessage();
    }
  }

  /** This method will the game. */
  public void endGame() {
    // Show the statistics of the game
    showStats();
    // Print the winner of the game
    if (playerWinCount > bot.getWinCount()) {
      MessageCli.PRINT_END_GAME.printMessage(playerName);
    } else if (bot.getWinCount() > playerWinCount) {
      MessageCli.PRINT_END_GAME.printMessage("HAL-9000");
    } else {
      MessageCli.PRINT_END_GAME_TIE.printMessage();
    }

    // Reset the game
    gameHasStarted = false;
  }

  /** Show the statistics of the game. */
  public void showStats() {
    // Show the statistics of the game if it has started
    if (gameHasStarted) {
      int hal9000WinCount = bot.getWinCount();
      MessageCli.PRINT_PLAYER_WINS.printMessage(
          playerName,
          Integer.toString(playerWinCount),
          Integer.toString(roundNumber - playerWinCount));

      MessageCli.PRINT_PLAYER_WINS.printMessage(
          "HAL-9000",
          Integer.toString(hal9000WinCount),
          Integer.toString(roundNumber - hal9000WinCount));
    } else {
      // Otherwise, show that the game has not started
      MessageCli.GAME_NOT_STARTED.printMessage();
    }
  }
}

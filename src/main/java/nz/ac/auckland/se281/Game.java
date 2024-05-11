package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  private int roundNumber;
  private String playerName;
  private Choice playerChoice;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    this.roundNumber = 0;
    this.playerChoice = choice;
    this.playerName = options[0];

    // Welcome the player
    MessageCli.WELCOME_PLAYER.printMessage(playerName);
  }

  public void play() {
    this.roundNumber++;
    MessageCli.START_ROUND.printMessage(String.valueOf(this.roundNumber));

    Player player = new Player();
    HAL9000 hal9000 = new HAL9000(new RandomStrategy());

    int playerAction = player.play();
    int hal9000Action = hal9000.play();

    MessageCli.PRINT_INFO_HAND.printMessage(playerName, Integer.toString(playerAction));
    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", Integer.toString(hal9000Action));

    int sum = playerAction + hal9000Action;

    Choice sumOddOrEven;
  }

  public void endGame() {}

  public void showStats() {}
}

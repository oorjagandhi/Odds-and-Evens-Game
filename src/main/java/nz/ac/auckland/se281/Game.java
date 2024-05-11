package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  private int roundNumber;
  private String playerName;
  private Difficulty difficulty;
  private Choice playerChoice;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    this.playerName = options[0];
    this.difficulty = difficulty;
    this.playerChoice = choice;
    this.roundNumber = 0;

    // Welcome the player
    MessageCli.WELCOME_PLAYER.printMessage(playerName);
  }

  public void play() {
    this.roundNumber++;
    MessageCli.START_ROUND.printMessage(String.valueOf(this.roundNumber));
    askForFingers();
  }

  private void askForFingers() {
    MessageCli.ASK_INPUT.printMessage();

    while (true) {
      String input = Utils.scanner.nextLine();
      try {
        int fingers = Integer.parseInt(input);
        if (fingers >= 0 && fingers <= 5) {
          MessageCli.PRINT_INFO_HAND.printMessage(this.playerName, Integer.toString(fingers));
          break;
        } else {
          MessageCli.INVALID_INPUT.printMessage();
        }
      } catch (NumberFormatException e) {
        MessageCli.INVALID_INPUT.printMessage();
      }
    }
  }

  public void endGame() {}

  public void showStats() {}
}

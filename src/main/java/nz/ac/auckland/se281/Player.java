package nz.ac.auckland.se281;

public class Player {

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

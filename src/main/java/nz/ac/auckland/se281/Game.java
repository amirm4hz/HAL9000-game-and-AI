package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  private int roundNumber = 1;
  private String playerName;
  private String choice;
  private Levels level;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    LevelsFactory levelsFactory = new LevelsFactory();
    this.choice = choice.toString();
    this.level =
        levelsFactory.createLevel(difficulty.toString()); // Pass the difficulty as a string
    this.playerName = options[0];
  }

  public void play() {
    MessageCli.START_ROUND.printMessage(Integer.toString(roundNumber));
    roundNumber++;
    int fingers = -1;
    while (fingers < 0 || fingers > 5) {
      System.out.println("Give <fingers> and press enter");
      String input = Utils.scanner.nextLine();
      try {
        fingers = Integer.parseInt(input);
        if (fingers < 0 || fingers > 5) {
          MessageCli.INVALID_INPUT.printMessage();
          fingers = -1;
        }
      } catch (NumberFormatException e) {
        MessageCli.INVALID_INPUT.printMessage();
      }
    }
    MessageCli.PRINT_INFO_HAND.printMessage(playerName, Integer.toString(fingers));
    level.play(fingers, choice, playerName); // Pass the Choice object to the play() method
  }

  public void endGame() {}

  public void showStats() {}
}

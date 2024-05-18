package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {

  private int roundNumber = 1;
  private String playerName;
  private String choice;
  private Levels level;
  private boolean gameCreated = false;
  private int aiWins = 0;
  private int playerWins = 0;

  /**
   * Starts a new game with the specified difficulty, choice, and options.
   *
   * @param difficulty the difficulty of the game
   * @param choice the choice of the player
   * @param options the options for the game
   */
  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    gameCreated = true;
    roundNumber = 1;
    MessageCli.WELCOME_PLAYER.printMessage(options[0]); // Print the welcome message
    this.choice = choice.toString();
    this.playerName = options[0];
    // Create the level based on the difficulty
    this.level = LevelsFactory.createLevel(difficulty.toString());
    // reset the games for medium and hard levels
    if (this.level instanceof MediumLevel) {
      ((MediumLevel) this.level).resetGame();
    } else if (this.level instanceof HardLevel) {
      ((HardLevel) this.level).resetGame();
    }
  }

  /**
   * Plays a round of the game. This method gets the number of fingers from the player and passes
   * the choice object to the play() method of the level.
   */
  public void play() {
    // check if the game has been created
    if (!gameCreated) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
    // Print the start round message
    MessageCli.START_ROUND.printMessage(Integer.toString(roundNumber));
    roundNumber++;
    int fingers = -1;
    // Get the number of fingers from the player
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
    // Print the player's choice
    MessageCli.PRINT_INFO_HAND.printMessage(playerName, Integer.toString(fingers));
    level.play(fingers, choice, playerName); // Pass the Choice object to the play() method
    if (level.getWinner().equals("AI")) {
      aiWins++;
    } else if (level.getWinner().equals("Player")) {
      playerWins++;
    }
  }

  /**
   * Ends the game and prints the final scores. This method is called when the game is over. It
   * prints the final scores and determines the winner.
   */
  public void endGame() {
    if (!gameCreated) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    // Print the end game message
    gameCreated = false;
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        playerName, Integer.toString(playerWins), Integer.toString(aiWins));
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        "HAL-9000", Integer.toString(aiWins), Integer.toString(playerWins));

    if (playerWins > aiWins) {
      MessageCli.PRINT_END_GAME.printMessage(playerName);
    } else if (aiWins > playerWins) {
      MessageCli.PRINT_END_GAME.printMessage("HAL-9000");
    } else {
      MessageCli.PRINT_END_GAME_TIE.printMessage();
    }
  }

  /**
   * Shows the current game statistics. This method prints the current scores of the player and the
   * AI. If the game has not started yet, it prints a message indicating that the game has not
   * started.
   */
  public void showStats() {
    // Print the player wins
    if (!gameCreated) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
    // Print the player wins
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        playerName, Integer.toString(playerWins), Integer.toString(aiWins));
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        "HAL-9000", Integer.toString(aiWins), Integer.toString(playerWins));
  }
}

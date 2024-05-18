package nz.ac.auckland.se281;

public class EasyLevel implements Levels {
  // The EasyLevel class is a concrete class that implements the Levels interface.
  private Ai ai;
  private int total;
  private String winner;

  /**
   * Constructs a new EasyLevel. The constructor of the EasyLevel class initializes the ai object
   * with a RandomStrategy object.
   */
  public EasyLevel() {
    // The constructor of the EasyLevel class initializes the ai object with a RandomStrategy
    // object.
    this.ai = new Ai(new RandomStrategy());
  }

  /**
   * Returns the winner of the round.
   *
   * @return the winner of the round
   */
  public String getWinner() {
    // The getWinner method returns the winner of the round.
    return winner;
  }

  /**
   * Plays a round of the game. The aiFingers variable stores the number of fingers that the AI will
   * show in the round.
   *
   * @param playerFingers the number of fingers that the player shows in the round
   * @param oddOrEven the game condition, which should be either "ODD" or "EVEN"
   * @param playerName the name of the player
   */
  public void play(int playerFingers, String oddOrEven, String playerName) {
    // The play method plays a round of the game.
    int aiFingers = ai.getFinger();
    // The aiFingers variable stores the number of fingers that the AI will show in the round.
    MessageCli.PRINT_INFO_HAND.printMessage(ai.getAiName(), Integer.toString(aiFingers));
    total = playerFingers + aiFingers;
    // If the total is even
    if (total % 2 == 0) {
      if (oddOrEven.equals("EVEN")) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(total), "EVEN", playerName);
        winner = "Player";
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(
            Integer.toString(total), "EVEN", ai.getAiName());
        winner = "AI";
      }
    }
    // if the total is uneven
    if (total % 2 != 0) {
      if (oddOrEven.equals("ODD")) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(total), "ODD", playerName);
        winner = "Player";
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(total), "ODD", ai.getAiName());
        winner = "AI";
      }
    }
  }
}

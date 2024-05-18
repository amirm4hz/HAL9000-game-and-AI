package nz.ac.auckland.se281;

public class MediumLevel implements Levels {

  private Ai ai;
  private int roundNumber = 0;
  private int total = 0;
  private EasyLevel easyLevel = new EasyLevel();
  private String winner;

  /** Constructs a new MediumLevel object. The AI starts with a TopStrategy. */
  public MediumLevel() {
    this.ai = new Ai(new TopStrategy()); // create a new AI with a TopStrategy
  }

  /**
   * Returns the winner of the round.
   *
   * @return the winner of the round
   */
  public String getWinner() {
    return winner; // return the winner of the round
  }

  /**
   * Sets the winner of the round.
   *
   * @param winner the winner of the round
   */
  public void setWinner(String winner) {
    this.winner = winner; // set the winner of the round
  }

  /** Resets the game. The round number is reset to 0 and the counts of the AI are reset. */
  public void resetGame() {
    roundNumber = 0;
    ai.resetCounts(); // reset the counts of the AI
  }

  /**
   * Plays a round of the game. The AI plays in easy mode for the first 3 rounds and in medium mode
   * for the rest of the rounds.
   *
   * @param playerFingers the number of fingers shown by the player
   * @param oddOrEven the choice of the player (odd or even)
   * @param playerName the name of the player
   */
  public void play(int playerFingers, String oddOrEven, String playerName) {
    roundNumber++;
    // for the first 3 rounds, the AI will play in easy mode
    if (roundNumber <= 3) {
      easyLevel.play(playerFingers, oddOrEven, playerName);
      String result = easyLevel.getWinner();
      setWinner(result);
      ai.updateCounts(playerFingers);
      return;
    }
    // for the rest of the rounds, the AI will play in medium mode
    ai.setGameCondition(oddOrEven);
    int aiFingers = ai.getFinger();
    MessageCli.PRINT_INFO_HAND.printMessage(ai.getAiName(), Integer.toString(aiFingers));
    total = playerFingers + aiFingers;
    if (Utils.isEven(total)) {
      if (oddOrEven.equals("EVEN")) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(total), "EVEN", playerName);
        winner = "Player";
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(
            Integer.toString(total), "EVEN", ai.getAiName());
        winner = "AI";
      }
    } else {
      if (oddOrEven.equals("ODD")) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(total), "ODD", playerName);
        winner = "Player";
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(total), "ODD", ai.getAiName());
        winner = "AI";
      }
    }
    ai.updateCounts(playerFingers);
  }
}

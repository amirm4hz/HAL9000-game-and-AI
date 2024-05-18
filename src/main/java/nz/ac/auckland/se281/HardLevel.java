package nz.ac.auckland.se281;

public class HardLevel implements Levels {
  private int roundNumber = 0;
  private boolean wonRound = false;
  private Strategy strategy;
  private EasyLevel easyLevel = new EasyLevel();
  private Ai ai;
  private int total = 0;
  private String winner;

  /** Constructs a new HardLevel object. The AI starts with a TopStrategy. */
  public HardLevel() {
    this.ai = new Ai(new TopStrategy());
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
   * Plays a round of the game. The AI plays in easy mode for the first 3 rounds and in hard mode
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
      winOrNot(playerFingers, playerFingers, oddOrEven);
      strategy = ai.getStrategy();
      return;
    }
    // for the rest of the rounds, the AI will play in hard mode
    if (ai.getStrategy() instanceof TopStrategy) {
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
          MessageCli.PRINT_OUTCOME_ROUND.printMessage(
              Integer.toString(total), "ODD", ai.getAiName());
          winner = "AI";
        }
      }
      ai.updateCounts(playerFingers);
    } else if (ai.getStrategy() instanceof RandomStrategy) {
      easyLevel.play(playerFingers, oddOrEven, playerName);
      String result = easyLevel.getWinner();
      setWinner(result);
      ai.updateCounts(playerFingers);
      winOrNot(playerFingers, playerFingers, oddOrEven);
      strategy = ai.getStrategy();
    }
    if (wonRound) {
      ai.setStrategy(strategy);
    } else if (!wonRound) {
      if (strategy instanceof TopStrategy) {
        ai.setStrategy(new RandomStrategy());
      } else if (strategy instanceof RandomStrategy) {
        ai.setStrategy(new RandomStrategy());
      }
    }
  }

  /**
   * Determines if the player or the AI won the round. The winner is determined based on the total
   * number of fingers and the choice of the player (odd or even).
   *
   * @param playerFingers the number of fingers shown by the player
   * @param aiFingers the number of fingers shown by the AI
   * @param oddOrEven the choice of the player (odd or even)
   */
  public void winOrNot(int playerFingers, int aiFingers, String oddOrEven) {
    // check if the player or the AI won the round
    int totalFingers = playerFingers + aiFingers;
    if ((totalFingers % 2 != 0 && oddOrEven.equals("EVEN"))
        || (totalFingers % 2 == 0 && oddOrEven.equals("ODD"))) {
      wonRound = true;
      // AI won the round
    } else {
      wonRound = false;
      // AI lost the round
    }
  }
}

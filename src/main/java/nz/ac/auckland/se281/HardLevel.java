package nz.ac.auckland.se281;

public class HardLevel implements Levels {
  private int roundNumber = 0;
  private boolean wonRound = false;
  private Strategy strategy;
  private EasyLevel easyLevel = new EasyLevel();
  private Ai ai;
  private int total = 0;

  public HardLevel() {
    this.ai = new Ai(new TopStrategy());
  }

  public void resetGame() {
    roundNumber = 0;
    ai.resetCounts();
  }

  public void play(int playerFingers, String oddOrEven, String playerName) {
    roundNumber++;
    if (roundNumber <= 3) {
      easyLevel.play(playerFingers, oddOrEven, playerName);
      ai.updateCounts(playerFingers);
      winOrNot(playerFingers, playerFingers, oddOrEven);
      strategy = ai.getStrategy();
      return;
    }
    if (ai.getStrategy() instanceof TopStrategy) {
      ai.setGameCondition(oddOrEven);
      int aiFingers = ai.getFinger();
      MessageCli.PRINT_INFO_HAND.printMessage(ai.getAiName(), Integer.toString(aiFingers));
      total = playerFingers + aiFingers;
      if (Utils.isEven(total)) {
        if (oddOrEven.equals("EVEN")) {
          MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(total), "EVEN", playerName);
        } else {
          MessageCli.PRINT_OUTCOME_ROUND.printMessage(
              Integer.toString(total), "EVEN", ai.getAiName());
        }
      } else {
        if (oddOrEven.equals("ODD")) {
          MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(total), "ODD", playerName);
        } else {
          MessageCli.PRINT_OUTCOME_ROUND.printMessage(
              Integer.toString(total), "ODD", ai.getAiName());
        }
      }
      ai.updateCounts(playerFingers);
    } else if (ai.getStrategy() instanceof RandomStrategy) {
      easyLevel.play(playerFingers, oddOrEven, playerName);
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

  public void winOrNot(int playerFingers, int aiFingers, String oddOrEven) {
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

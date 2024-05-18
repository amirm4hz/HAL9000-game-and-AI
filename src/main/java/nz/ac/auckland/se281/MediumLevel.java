package nz.ac.auckland.se281;

public class MediumLevel implements Levels {

  private Ai ai;
  private int roundNumber = 0;
  private int total = 0;
  private EasyLevel easyLevel = new EasyLevel();
  private TopStrategy topStrategy = new TopStrategy();

  public MediumLevel() {
    this.ai = new Ai(new TopStrategy());
  }

  public void resetGame() {
    roundNumber = 0;
    topStrategy.resetCounts();
  }

  public void play(int playerFingers, String oddOrEven, String playerName) {
    roundNumber++;
    if (roundNumber <= 3) {
      easyLevel.play(playerFingers, oddOrEven, playerName);
      topStrategy.updateCounts(playerFingers);
      return;
    }

    topStrategy.setGameCondition(oddOrEven);
    int aiFingers = topStrategy.getFinger();
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
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(total), "ODD", ai.getAiName());
      }
    }
    topStrategy.updateCounts(playerFingers);
  }
}

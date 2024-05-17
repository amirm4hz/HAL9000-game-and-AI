package nz.ac.auckland.se281;

public class EasyLevel implements Levels {
  private Ai ai;
  private int total;

  public EasyLevel() {
    this.ai = new Ai(new RandomStrategy());
  }

  public void play(int playerFingers, String oddOrEven, String playerName) {
    int aiFingers = ai.getFinger();
    MessageCli.PRINT_INFO_HAND.printMessage(ai.getAiName(), Integer.toString(aiFingers));
    total = playerFingers + aiFingers;
    if (total % 2 == 0) {
      if (oddOrEven.equals("EVEN")) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(total), "EVEN", playerName);
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(
            Integer.toString(total), "EVEN", ai.getAiName());
      }
    }
    if (total % 2 != 0) {
      if (oddOrEven.equals("ODD")) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(total), "ODD", playerName);
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(total), "ODD", ai.getAiName());
      }
    }
  }
}

package nz.ac.auckland.se281;


public class MediumLevel implements Levels {

  private Ai ai;
  private int roundNumber = 0;
  private int total = 0;
  private RandomStrategy randomStrategy = new RandomStrategy();
  private TopStrategy topStrategy = new TopStrategy();

  public MediumLevel() {
    this.ai = new Ai(new TopStrategy());
  }

  public void play(int playerFingers, String oddOrEven, String playerName) {
    roundNumber++;
    if (roundNumber <= 3) {
      ai.setStrategy(randomStrategy);
      topStrategy.updateCounts(playerFingers);
      return;
    } else {
      ai.setStrategy(topStrategy);
      topStrategy.updateCounts(playerFingers);
    }

    int aiFingers = ai.getStrategy().getFinger();
    MessageCli.PRINT_INFO_HAND.printMessage(ai.getAiName(), Integer.toString(aiFingers));
    total = playerFingers + aiFingers;
    if (Utils.isEven(total)) {
      if (oddOrEven.equals("EVEN")) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(total), "EVEN", playerName);
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(
            Integer.toString(total), "EVEN", ai.getAiName());
      }
    }
    if (Utils.isOdd(total)) {
      if (oddOrEven.equals("ODD")) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(total), "ODD", playerName);
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(Integer.toString(total), "ODD", ai.getAiName());
      }
    }
  }

  public void newgame() {
    roundNumber = 0;
    topStrategy.resetCounts();
  }
}

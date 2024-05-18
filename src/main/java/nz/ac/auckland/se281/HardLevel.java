package nz.ac.auckland.se281;

public class HardLevel implements Levels {
  private int roundNumber = 0;
  private boolean wonRound = false;
  private EasyLevel easyLevel = new EasyLevel();
  private RandomStrategy randomStrategy = new RandomStrategy();
  private TopStrategy topStrategy = new TopStrategy();
  private Ai ai;

  public HardLevel() {
    this.ai = new Ai(new TopStrategy());
  }

  public void play(int playerFingers, String oddOrEven, String playerName) {
    if (roundNumber <= 3) {
      easyLevel.play(playerFingers, oddOrEven, playerName);
      topStrategy.updateCounts(playerFingers);
      winOrNot(playerFingers, playerFingers, oddOrEven);
      return;
    }
    if (wonRound) {}
  }

  public void winOrNot(int playerFingers, int aiFingers, String oddOrEven) {
    int totalFingers = playerFingers + aiFingers;
    if ((totalFingers % 2 == 0 && oddOrEven.equals("EVEN"))
        || (totalFingers % 2 != 0 && oddOrEven.equals("ODD"))) {
      wonRound = true;
      // AI won the round
    } else {
      wonRound = false;
      // AI lost the round
    }
  }
}

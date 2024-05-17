package nz.ac.auckland.se281;

public class EasyLevel implements Levels {
  private Ai ai;
  private int total;

  public EasyLevel() {
    this.ai = new Ai(new RandomStrategy());
  }

  public void play(int playerFingers) {
    int aiFingers = ai.getFinger();
    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", Integer.toString(aiFingers));
  }
}

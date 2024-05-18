package nz.ac.auckland.se281;

public class Ai {

  private Strategy strategy;
  private String aiName = "HAL-9000";

  public Ai(Strategy strategy) {
    this.strategy = strategy;
  }

  public String getAiName() {
    return aiName;
  }

  public int getFinger() {
    return strategy.getFinger();
  }

  public Strategy getStrategy() {
    return this.strategy;
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }
}

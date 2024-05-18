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

  public void setGameCondition(String oddOrEven) {
    if (strategy instanceof TopStrategy) {
      TopStrategy topStrategy = (TopStrategy) strategy;
      topStrategy.setGameCondition(oddOrEven);
    }
  }

  public void resetCounts() {
    if (strategy instanceof TopStrategy) {
      TopStrategy topStrategy = (TopStrategy) strategy;
      topStrategy.resetCounts();
    }
  }

  public void updateCounts(int playerFinger) {
    if (strategy instanceof TopStrategy) {
      TopStrategy topStrategy = (TopStrategy) strategy;
      topStrategy.updateCounts(playerFinger);
    }
  }

  public Strategy getStrategy() {
    return this.strategy;
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }
}

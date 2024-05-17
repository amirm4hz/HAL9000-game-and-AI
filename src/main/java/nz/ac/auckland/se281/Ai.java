package nz.ac.auckland.se281;

public class Ai {

  private Strategy strategy;

  public Ai(Strategy strategy) {
    this.strategy = strategy;
  }

  public int getFinger() {
    return strategy.getFinger();
  }

  public void setStrategy(Strategy strategy) {
    this.strategy = strategy;
  }
}

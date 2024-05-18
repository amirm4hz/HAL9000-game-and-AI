package nz.ac.auckland.se281;

public class Ai {

  private Strategy strategy;
  private String aiName = "HAL-9000"; // default AI name

  /**
   * Constructs a new Ai with the given strategy.
   *
   * @param strategy the strategy that the Ai will use to play the game
   */
  public Ai(Strategy strategy) {
    this.strategy = strategy; // set the strategy
  }

  /**
   * Returns the name of the Ai.
   *
   * @return the name of the Ai
   */
  public String getAiName() {
    return aiName; // return the AI name
  }

  /**
   * Returns the number of fingers that the Ai will show in the next round.
   *
   * @return the number of fingers that the Ai will show
   */
  public int getFinger() {
    return strategy.getFinger(); // get the finger from the strategy
  }

  /**
   * Sets the game condition for the Ai's strategy, if the strategy is a TopStrategy.
   *
   * @param oddOrEven the game condition, which should be either "ODD" or "EVEN"
   */
  public void setGameCondition(String oddOrEven) {
    if (strategy instanceof TopStrategy) {
      TopStrategy topStrategy = (TopStrategy) strategy;
      topStrategy.setGameCondition(oddOrEven); // set the game condition for the top strategy
    }
  }

  /** Resets the counts for the Ai's strategy, if the strategy is a TopStrategy. */
  public void resetCounts() {
    if (strategy instanceof TopStrategy) {
      TopStrategy topStrategy = (TopStrategy) strategy;
      topStrategy.resetCounts(); // reset the counts for the top strategy
    }
  }

  /**
   * Updates the counts for the Ai's strategy, if the strategy is a TopStrategy.
   *
   * @param playerFinger the number of fingers that the player showed in the last round
   */
  public void updateCounts(int playerFinger) {
    if (strategy instanceof TopStrategy) {
      TopStrategy topStrategy = (TopStrategy) strategy;
      topStrategy.updateCounts(playerFinger); // update the counts for the top strategy
    }
  }

  /**
   * Returns the strategy of the Ai.
   *
   * @return the strategy of the Ai
   */
  public Strategy getStrategy() {
    return this.strategy; // return the strategy
  }

  /**
   * Sets the strategy of the Ai.
   *
   * @param strategy the new strategy for the Ai
   */
  public void setStrategy(Strategy strategy) {
    this.strategy = strategy; // set the strategy
  }
}

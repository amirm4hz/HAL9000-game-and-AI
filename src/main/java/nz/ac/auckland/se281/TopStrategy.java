package nz.ac.auckland.se281;

public class TopStrategy implements Strategy {

  private int oddCount = 0;
  private int evenCount = 0;
  private String gameCondition;

  /**
   * Sets the game condition.
   *
   * <p>The game condition determines the strategy that the AI will use to play the game. If the
   * game condition is "ODD", the AI will try to make the total number of fingers shown odd. If the
   * game condition is "EVEN", the AI will try to make the total number of fingers shown even.
   *
   * @param gameCondition the game condition, which should be either "ODD" or "EVEN"
   */
  public void setGameCondition(String gameCondition) {
    this.gameCondition = gameCondition; // set the game condition
  }

  /**
   * Updates the counts of the player based on the number of fingers shown.
   *
   * @param playerFingers the number of fingers shown by the player
   */
  public void updateCounts(int playerFingers) {
    // update the counts of the player based on the number of fingers shown
    if (Utils.isEven(playerFingers)) {
      evenCount++;
    } else {
      oddCount++;
    }
  }

  /** Resets the counts of the player. */
  public void resetCounts() {
    // reset the counts of the player
    oddCount = 0;
    evenCount = 0;
  }

  /**
   * Returns the number of fingers to show in the game. The AI will play an odd number if the game
   * condition is ODD and the count of odd numbers is greater than the count of even numbers, and
   * vice versa.
   *
   * @return the number of fingers to show
   */
  @Override
  public int getFinger() {
    int aiFingers = 0;
    // if the game condition is ODD, the AI will play an odd number
    // if the count of odd numbers is greater than the count of even numbers and vice versa
    if (gameCondition.equals("ODD")) {
      if (oddCount > evenCount) {
        aiFingers = Utils.getRandomOddNumber();
      } else if (evenCount > oddCount) {
        aiFingers = Utils.getRandomEvenNumber();
      } else {
        aiFingers = Utils.getRandomNumberRange(0, 5);
      }
    } else if (gameCondition.equals("EVEN")) {
      if (oddCount > evenCount) {
        aiFingers = Utils.getRandomEvenNumber();
      } else if (evenCount > oddCount) {
        aiFingers = Utils.getRandomOddNumber();
      } else {
        aiFingers = Utils.getRandomNumberRange(0, 5);
      }
    }
    return aiFingers;
  }
}

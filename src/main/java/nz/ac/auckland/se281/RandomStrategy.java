package nz.ac.auckland.se281;

public class RandomStrategy implements Strategy {

  /**
   * Returns a random number between 0 and 5.
   *
   * @return a random number between 0 and 5
   */
  public int getFinger() {
    // return a random number between 0 and 5
    int randomResult = Utils.getRandomNumberRange(0, 5);
    return randomResult;
  }
}

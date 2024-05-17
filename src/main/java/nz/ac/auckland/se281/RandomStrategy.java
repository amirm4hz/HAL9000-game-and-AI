package nz.ac.auckland.se281;

public class RandomStrategy implements Strategy {
  public int getFinger() {
    int randomResult = Utils.getRandomNumberRange(0, 5);
    return randomResult;
  }
}

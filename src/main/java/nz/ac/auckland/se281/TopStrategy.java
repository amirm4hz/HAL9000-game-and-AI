package nz.ac.auckland.se281;

public class TopStrategy implements Strategy {

  private int oddCount = 0;
  private int evenCount = 0;

  public void updateCounts(int playerFingers) {
    if (Utils.isEven(playerFingers)) {
      evenCount++;
    } else {
      oddCount++;
    }
  }

  public void resetCounts() {
    oddCount = 0;
    evenCount = 0;
  }

  @Override
  public int getFinger() {
    int aiFingers = 0;
    if (oddCount > evenCount) {
      aiFingers = Utils.getRandomEvenNumber();
    } else if (evenCount > oddCount) {
      aiFingers = Utils.getRandomOddNumber();
    } else {
      Utils.getRandomNumberRange(0, 5);
    }
    return aiFingers;
  }
}

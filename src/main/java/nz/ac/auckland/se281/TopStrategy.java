package nz.ac.auckland.se281;

public class TopStrategy implements Strategy {

  private int oddCount = 0;
  private int evenCount = 0;
  private String gameCondition;

  public void setGameCondition(String gameCondition) {
    this.gameCondition = gameCondition;
  }

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

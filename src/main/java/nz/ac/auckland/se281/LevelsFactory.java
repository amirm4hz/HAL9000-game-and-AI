package nz.ac.auckland.se281;

public class LevelsFactory {

  /**
   * Creates a new level of the specified type. The level type can be "EASY", "MEDIUM", or "HARD".
   * If the level type is not recognized, this method returns null.
   *
   * @param levelType the type of the level to create
   * @return the created level, or null if the level type is not recognized
   */
  public static Levels createLevel(String levelType) {
    switch (levelType.toUpperCase()) {
      case "EASY": // If the level type is "EASY", create a new EasyLevel object
        return new EasyLevel();
      case "MEDIUM": // If the level type is "MEDIUM", create a new MediumLevel object
        return new MediumLevel();
      case "HARD": // If the level type is "HARD", create a new HardLevel object
        return new HardLevel();
      default:
        return null;
    }
  }
}

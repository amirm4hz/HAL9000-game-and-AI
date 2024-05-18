package nz.ac.auckland.se281;

public class LevelsFactory {
  public static Levels createLevel(String levelType) {
    switch (levelType.toUpperCase()) {
      case "EASY":
        return new EasyLevel();
      case "MEDIUM":
        return new MediumLevel();
      case "HARD":
        return new HardLevel();
      default:
        return null;
    }
  }
}

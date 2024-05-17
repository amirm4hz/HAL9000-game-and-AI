package nz.ac.auckland.se281;

public class LevelsFactory {
  public Levels createLevel(String levelType) {
    switch (levelType.toUpperCase()) {
      case "EASY":
        return new EasyLevel();
      case "MEDIUM":
        return new MediumLevel();
      default:
        return null;
    }
  }
}

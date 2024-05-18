package nz.ac.auckland.se281;

public interface Levels {

  /**
   * Plays a round of the game.
   *
   * @param playerFingers the number of fingers shown by the player
   * @param oddOrEven the choice of the player (odd or even)
   * @param playerName the name of the player
   */
  void play(int playerFingers, String oddOrEven, String playerName);

  /**
   * Returns the winner of the round.
   *
   * @return the winner of the round
   */
  String getWinner();
}

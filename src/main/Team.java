import java.util.List;

/**
 * Defines the core functionality for managing a soccer team in the British Columbia Soccer Club's U10 program.
 * This interface outlines methods for adding and removing players, assigning jersey numbers, creating a starting lineup,
 * and retrieving team information in a formatted string. Implementations must adhere to the 7v7 formation (1 Goalie,
 * 2 Defenders, 3 Midfielders, 1 Forward) and manage team sizes between 10 and 20 players.
 */
public interface Team {
  /**
   * Adds a new player to the team, ensuring the team size does not exceed the maximum limit of 20 players.
   * The player’s details, such as name, date of birth, and skill level, are assumed to be valid upon addition.
   *
   * @param p The player object to be added to the team
   */
  void addPlayer(Player p);

  /**
   * Removes an existing player from the team, ensuring the team size does not fall below the minimum requirement of 10 players.
   * The player’s jersey number and assigned position may be affected upon removal.
   *
   * @param p The player object to be removed from the team
   */
  void removePlayer(Player p);

  /**
   * Assigns unique jersey numbers to all players in the team, ranging from 1 to 20 inclusive.
   * Numbers are randomly generated and must not be duplicated within the team.
   */
  void assignJerseyNumber();

  /**
   * Creates a starting lineup of 7 players based on their skill levels and preferred positions, following the 2-3-1 formation.
   * The lineup includes 1 Goalie, 2 Defenders, 3 Midfielders, and 1 Forward, prioritizing higher-skilled players where possible.
   */
  void createStartingLineup();

  /**
   * Retrieves a formatted string listing all players in the team, sorted alphabetically by last name.
   * Each entry includes the player’s first name, last name, and jersey number, separated by newlines for readability.
   *
   * @return A string representation of all players in the team
   */
  String getAllPlayersSorted();

  /**
   * Retrieves a formatted string listing the starting lineup, sorted by position (Goalie, Defender, Midfielder, Forward)
   * and then alphabetically by last name within each position. Each entry includes the player’s first name, last name,
   * jersey number, and assigned position.
   *
   * @return A string representation of the starting lineup
   */
  String getStartingLineup();
}
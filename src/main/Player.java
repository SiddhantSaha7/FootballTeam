import java.util.Date;

/**
 * Interface representing a Player in a sports team.
 * Defines common methods for player information and attributes.
 */
 public interface Player {
    /**
     * Gets the first name of the player.
     * @return String containing the player's first name
     */
     String getFirstName();
    /**
     * Sets the player's first  name.
     * @param firstName The player's first name*/
     void setFirstName(String firstName);
    /**
     * Gets the first name of the player.
     * @return String containing the player's first name
     */
     String getLastName();
    /**
     * Sets the player's first and last name.
     * @param lastName The player's last name
     */
     void setLastName(String lastName);
    /**
     * Gets the player's date of birth.
     * @return Date object representing the player's birth date
     */
     Date getDOB();
    /**
     * Gets the player's preferred playing position.
     * @return Position enum representing the preferred position
     */
     Position getPreferredPosition();
    /**
     * Sets the player's preferred playing position.
     * @param position Position enum to set as preferred
     */
     void setPreferredPosition(Position position);

    /**
     * Gets the player's assigned playing position.
     * If player is not in starting lineup, it will be stored as null
     * @return Position enum representing the preferred position
     */
    Position getAssignedPosition();
    /**
     * Sets the player's preferred playing position.
     * @param position Position enum to set as preferred
     */
    void setAssignedPosition(Position position);
    /**
     * Gets the player's skill level.
     * @return int representing skill level (higher is better)
     */
     int getSkillLevel();
    /**
     * Sets the player's skill level.
     * @param skillLevel int representing skill level (higher is better)
     */
     void setSkillLevel(int skillLevel);
    /**
     * Gets the player's jersey number.
     * @return jerseyNumber int representing jersey Number
     */
     int getJerseyNumber();
    /**
     * Sets the player's jersey number.
     * @param jerseyNumber int representing jersey Number, its value will lie between 1-20
     */
     void setJerseyNumber(int jerseyNumber);

    
}

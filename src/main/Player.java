package main;

import java.util.Date;

/**
 * Interface representing a Player in a sports team.
 * Defines common methods for player information and attributes.
 */
public interface Player {
    /**
     * Gets the full name of the player.
     * @return String containing the player's full name
     */
    public String getName();
    /**
     * Sets the player's first and last name.
     * @param firstName The player's first name
     * @param lastName The player's last name
     */
    public void setName(String firstName,String lastName);
    /**
     * Gets the player's date of birth.
     * @return Date object representing the player's birth date
     */
    public Date getDOB();
    /**
     * Gets the player's preferred playing position.
     * @return Position enum representing the preferred position
     */
    public Position getPreferredPosition();
    /**
     * Sets the player's preferred playing position.
     * @param position Position enum to set as preferred
     */
    public void setPreferredPosition(Position position);
    /**
     * Gets the player's skill level.
     * @return int representing skill level (higher is better)
     */
    public int getSkillLevel();
    /**
     * Sets the player's skill level.
     * @param skillLevel int representing skill level (higher is better)
     */
    public void setSkillLevel(int skillLevel);
}

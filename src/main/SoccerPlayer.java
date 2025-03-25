package main;

import java.util.Date;

/**
 * Concrete implementation of a soccer player.
 * Represents a player with name, birth date, position and skill level.
 */
public class SoccerPlayer implements Player {
  /** The player's first name */
  private String FirstName;
  /** The player's last name */
  private String LastName;
  /** The player's date of birth */
  private Date dateOfBirth;
  /** The player's preferred position on the field */
  private Position position;
  /** The player's skill level (higher is better) */
  private int skillLevel;
  /** The player's jersey number */
  private final int jerseyNumber = 0;

    /**
     * Creates a SoccerPlayer with basic information.
     * @param firstName The player's first name
     * @param lastName The player's last name
     * @param DOB The player's date of birth
     */
    public SoccerPlayer(String firstName, String lastName, Date DOB) {
        this.FirstName = firstName;
        this.LastName = lastName;
        this.dateOfBirth = DOB;
    }

    /**
     * Creates a SoccerPlayer with basic information and preferred position.
     * @param firstName The player's first name
     * @param lastName The player's last name
     * @param DOB The player's date of birth
     * @param preferredPosition The player's preferred position
     */
    public SoccerPlayer(String firstName, String lastName, Date DOB, Position preferredPosition) {
        this.FirstName = firstName;
        this.LastName = lastName;
        this.dateOfBirth = DOB;
        this.position = preferredPosition;
    }

    /**
     * Creates a SoccerPlayer with complete information.
     * @param firstName The player's first name
     * @param lastName The player's last name
     * @param DOB The player's date of birth
     * @param preferredPosition The player's preferred position
     * @param skillLevel The player's skill level (higher is better)
     */
    public SoccerPlayer(String firstName, String lastName, Date DOB, Position preferredPosition, int skillLevel) {
        this.FirstName = firstName;
        this.LastName = lastName;
        this.dateOfBirth = DOB;
        this.position = preferredPosition;
        this.skillLevel = skillLevel;
    }

    /**
     * Gets the player's current position.
     * @return Position enum representing current position
     */
    public Position getPosition() {
        return position;
    }

    /**
     * Sets the player's current position.
     * @param position Position enum to set as current
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    @Override
    public String getName() {
        return String.format("%s %s", FirstName, LastName);
    }

    @Override
    public void setName(String firstName, String lastName) {
        this.FirstName = firstName;
        this.LastName = lastName;
    }

    @Override
    public Date getDOB() {
        return this.dateOfBirth;
    }

    @Override
    public Position getPreferredPosition() {
        return this.position;
    }

    @Override
    public void setPreferredPosition(Position position) {
        this.position = position;
    }

    @Override
    public int getSkillLevel() {
        return this.skillLevel;
    }

    @Override
    public void setSkillLevel(int skillLevel) {
        this.skillLevel = skillLevel;
    }
}

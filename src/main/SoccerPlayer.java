import java.util.Date;

/**
 * Concrete implementation of a soccer player.
 * Represents a player with name, birthdate, position and skill level.
 */
public class SoccerPlayer implements Player {
    /**
     * The player's first name
     */
    private String firstName;
    /**
     * The player's last name
     */
    private String lastName;
    /**
     * The player's date of birth
     */
    private Date dateOfBirth;
    /**
     * The player's preferred position on the field
     */
    private Position preferredPosition;
    /**
     * The player's skill level (higher is better)
     */
    private int skillLevel;
    /**
     * The player's jersey number, set to default 0 and handled once he is assigned to a team
     */
    private int jerseyNumber=0;
    /**
     * The player's assigned Position in the squad/team
     */
    private Position assignedPosition;

    /**
     * Creates a SoccerPlayer with basic information.
     *
     * @param firstName The player's first name
     * @param lastName  The player's last name
     * @param DOB       The player's date of birth
     */
    public SoccerPlayer(String firstName, String lastName, Date DOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = DOB;
    }

    /**
     * Creates a SoccerPlayer with basic information and preferred position.
     *
     * @param firstName         The player's first name
     * @param lastName          The player's last name
     * @param DOB               The player's date of birth
     * @param preferredPosition The player's preferred position
     */
    public SoccerPlayer(String firstName, String lastName, Date DOB, Position preferredPosition) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = DOB;
        this.preferredPosition = preferredPosition;
    }

    /**
     * Creates a SoccerPlayer with complete information.
     *
     * @param firstName         The player's first name
     * @param lastName          The player's last name
     * @param DOB               The player's date of birth
     * @param preferredPosition The player's preferred position
     * @param skillLevel        The player's skill level (higher is better)
     */
    public SoccerPlayer(String firstName, String lastName, Date DOB, Position preferredPosition, int skillLevel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = DOB;
        this.preferredPosition = preferredPosition;
        this.skillLevel = skillLevel;
    }

    /**
     * Gets the player's preferred position.
     * @return the preferred position
     */
    @Override
    public Position getPreferredPosition() {
        return preferredPosition;
    }

    /**
     * Sets the player's preferred position.
     * @param preferredPosition the position to set
     */
    @Override
    public void setPreferredPosition(Position preferredPosition) {
        this.preferredPosition = preferredPosition;
    }

    /**
     * Gets the player's first name.
     * @return the first name
     */
    @Override
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Sets the player's first name.
     * @param firstName the first name to set
     */
    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets the player's last name.
     * @return the last name
     */
    @Override
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Sets the player's last name.
     * @param lastName the last name to set
     */
    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets the player's date of birth.
     * @return the date of birth
     */
    @Override
    public Date getDOB() {
        return this.dateOfBirth;
    }

    /**
     * Gets the player's assigned position.
     * @return the assigned position
     */
    @Override
    public Position getAssignedPosition() {
        return this.assignedPosition;
    }

    /**
     * Sets the player's assigned position.
     * @param assignedPosition the position to assign
     */
    @Override
    public void setAssignedPosition(Position assignedPosition) {
        this.assignedPosition = assignedPosition;
    }

    /**
     * Gets the player's skill level.
     * @return the skill level
     */
    @Override
    public int getSkillLevel() {
        return this.skillLevel;
    }

    /**
     * Sets the player's skill level.
     * @param skillLevel the skill level to set
     */
    @Override
    public void setSkillLevel(int skillLevel) {
        this.skillLevel = skillLevel;
    }

    /**
     * Gets the player's jersey number.
     * @return the jersey number
     */
    @Override
    public int getJerseyNumber() {
        return this.jerseyNumber;
    }

    /**
     * Sets the player's jersey number.
     * @param jerseyNumber the jersey number to set
     */
    @Override
    public void setJerseyNumber(int jerseyNumber) {
        this.jerseyNumber = jerseyNumber;
    }
}
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

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
    private LocalDate dateOfBirth;
    /**
     * The player's preferred position on the field
     */
    private Position preferredPosition;
    /**
     * The player's skill level (higher is better)
     */
    private int skillLevel;
//    /**
//     * The player's jersey number, set to default 0 and handled once he is assigned to a team
//     */
//    private int jerseyNumber=0;
    /**
     * The player's assigned Position in the squad/team
     */
    private Position assignedPosition;

    /**
     * Creates a SoccerPlayer with basic information and preferred position.
     *
     * @param firstName         The player's first name
     * @param lastName          The player's last name
     * @param DOB               The player's date of birth
     * @param preferredPosition The player's preferred position
     */
    public SoccerPlayer(String firstName, String lastName, LocalDate DOB, Position preferredPosition) throws IllegalArgumentException{
        if (firstName == null || lastName == null || firstName.length()==0 || lastName.length()==0) {
            throw new IllegalArgumentException("The firstname and lastname should not be empty or null");
        }
        else if (isPlayerTooOld(DOB)){
            throw new IllegalArgumentException("Player is too old!");
        }
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
    public SoccerPlayer(String firstName, String lastName, LocalDate DOB, Position preferredPosition, int skillLevel) throws IllegalArgumentException{
        if (firstName == null || lastName == null || firstName.length()==0 || lastName.length()==0) {
            throw new IllegalArgumentException("The firstname and lastname should not be empty or null");
        }
        else if (isPlayerTooOld(DOB)){
            throw new IllegalArgumentException("Player is too old!");
        }
        else if (skillLevel > 5 || skillLevel < 1){
            throw new IllegalArgumentException("Skill level must be between 1-5!");
        }


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
    public void setFirstName(String firstName) throws IllegalArgumentException{
        if (firstName == null || firstName.length()==0){
            throw new IllegalArgumentException("Firstname cannot be null or empty!");
        }
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
        if (lastName == null || lastName.length()==0){
            throw new IllegalArgumentException("Firstname cannot be null or empty!");
        }
        this.lastName = lastName;
    }

    /**
     * Gets the player's date of birth.
     * @return the date of birth
     */
    @Override
    public LocalDate getDOB() {
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
        if (skillLevel > 5 || skillLevel < 1){
            throw new IllegalArgumentException("Skill level must be between 1-5!");
        }
        this.skillLevel = skillLevel;
    }

//    /**
//     * Gets the player's jersey number.
//     * @return the jersey number
//     */
//    @Override
//    public int getJerseyNumber() {
//        return this.jerseyNumber;
//    }

//    /**
//     * Sets the player's jersey number.
//     * @param jerseyNumber the jersey number to set
//     */
//    @Override
//    public void setJerseyNumber(int jerseyNumber, Team team) throws IllegalArgumentException{
//        if (team instanceof Team) {
//            this.jerseyNumber = jerseyNumber;
//        } else {
//            throw new IllegalArgumentException("Jersey number can only be assigned by a team!");
//        }
//    }

    /** Method to check if a player is >10 years old
     *
     * @param dateOfBirth the date of birth of the player
     * @return true if he is older than 10 else false
     */
    private boolean isPlayerTooOld(LocalDate dateOfBirth){
        return dateOfBirth.isBefore(LocalDate.now().minus(10, ChronoUnit.YEARS));
    }
}
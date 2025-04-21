package view;

import model.Position;
import java.time.LocalDate;

/**
 * Stores raw player input from the form.
 * Implements accessors defined by IPlayerFormData.
 */
public class PlayerFormData implements IPlayerFormData {
    private final String firstName;
    private final String lastName;
    private final LocalDate dob;
    private final Position position;
    private final int skillLevel;

    /**
     * Constructs a new PlayerFormData object with user-provided form values.
     *
     * @param firstName the player's first name
     * @param lastName the player's last name
     * @param dob the player's date of birth
     * @param position the preferred playing position
     * @param skillLevel the assessed skill level (1–5)
     */
    public PlayerFormData(String firstName, String lastName, LocalDate dob,
                          Position position, int skillLevel) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dob = dob;
        this.position = position;
        this.skillLevel = skillLevel;
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    @Override
    public LocalDate getDOB() {
        return dob;
    }

    @Override
    public Position getPosition() {
        return position;
    }

    @Override
    public int getSkillLevel() {
        return skillLevel;
    }
}

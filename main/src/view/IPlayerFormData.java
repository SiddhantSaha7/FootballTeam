package view;

import model.Position;
import java.time.LocalDate;

/**
 * Interface for form data representing a soccer player.
 * Provides access to player input fields.
 */
public interface IPlayerFormData {

    /**
     * Gets the player's first name.
     * @return the first name
     */
    String getFirstName();

    /**
     * Gets the player's last name.
     * @return the last name
     */
    String getLastName();

    /**
     * Gets the player's date of birth.
     * @return date of birth
     */
    LocalDate getDOB();

    /**
     * Gets the player's preferred position.
     * @return preferred position
     */
    Position getPosition();

    /**
     * Gets the player's skill level.
     * @return skill level
     */
    int getSkillLevel();
}
package view;

import java.time.format.DateTimeParseException;

/**
 * Interface for the player form input view.
 * Collects and clears player information entered by the user.
 */
public interface IPlayerFormView {

    /**
     * Retrieves user-entered form data as a PlayerFormData object.
     * @return the form data
     * @throws IllegalArgumentException if any fields are invalid
     * @throws DateTimeParseException if the date format is incorrect
     */
    PlayerFormData getPlayerFormData() throws IllegalArgumentException, DateTimeParseException;

    /**
     * Clears all input fields in the form.
     */
    void clearForm();
}

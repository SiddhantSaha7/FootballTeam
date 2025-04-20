package view;

import java.awt.event.ActionListener;

/**
 * Interface representing the main view in the MVC architecture.
 * Provides access to subviews and methods for user interaction and feedback.
 */
public interface IMainView {

    /**
     * Returns the form view used for inputting player details.
     *
     * @return the player form view component
     */
    PlayerFormView getPlayerFormView();

    /**
     * Returns the list view that displays candidate players.
     *
     * @return the player list view component
     */
    PlayerListView getPlayerListView();

    /**
     * Returns the view containing team control buttons.
     *
     * @return the team control view component
     */
    TeamControlsView getTeamControlsView();

    /**
     * Retrieves form data entered by the user.
     *
     * @return a PlayerFormData object containing raw user input
     */
    PlayerFormData getPlayerFormData();

    /**
     * Clears all fields in the player form.
     */
    void clearPlayerForm();

    /**
     * Displays a message in the main output area, replacing any existing content.
     *
     * @param message the message to display
     */
    void showMessage(String message);

    /**
     * Appends a message to the main output area without erasing previous content.
     *
     * @param message the message to append
     */
    void appendMessage(String message);

    /**
     * Connects all view buttons to their respective action listeners.
     *
     * @param addPlayerListener    listener for adding a player
     * @param removePlayerListener listener for removing a player
     * @param createTeamListener   listener for creating the team
     * @param showTeamListener     listener for showing the team
     * @param showLineupListener   listener for showing the starting lineup
     */
    void setupListeners(
            ActionListener addPlayerListener,
            ActionListener removePlayerListener,
            ActionListener createTeamListener,
            ActionListener showTeamListener,
            ActionListener showLineupListener);

    /**
     * Sets whether the main window is visible.
     *
     * @param b true to make visible, false to hide
     */
    void setVisible(boolean b);
}


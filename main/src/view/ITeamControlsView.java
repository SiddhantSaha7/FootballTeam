package view;

import java.awt.event.ActionListener;

/**
 * Interface for the control panel that manages team actions.
 * Connects control buttons to team operations.
 */
public interface ITeamControlsView {

    /**
     * Sets the listener for the create team button.
     * @param listener the action listener
     */
    void setCreateTeamListener(ActionListener listener);

    /**
     * Sets the listener for the show team roster button.
     * @param listener the action listener
     */
    void setShowTeamListener(ActionListener listener);

    /**
     * Sets the listener for the show starting lineup button.
     * @param listener the action listener
     */
    void setShowLineupListener(ActionListener listener);
}


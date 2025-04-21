package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * View component responsible for team management controls.
 * Provides buttons for creating team, showing roster, and showing lineup.
 */
public class TeamControlsView extends JPanel implements ITeamControlsView{
    private JButton createTeamButton;
    private JButton showTeamButton;
    private JButton showLineupButton;
    
    /**
     * Constructor to initialize the team controls panel.
     */
    public TeamControlsView() {
        setLayout(new GridLayout(3, 1, 0, 5));
        
        createTeamButton = new JButton("Create Team");
        showTeamButton = new JButton("Show Team Roster");
        showLineupButton = new JButton("Show Starting Lineup");
        
        // Add components to panel
        add(createTeamButton);
        add(showTeamButton);
        add(showLineupButton);
        
        // Add border and title
        setBorder(BorderFactory.createTitledBorder("Team Management"));
    }
    
    /**
     * Sets the action listener for the create team button.
     * @param listener The action listener
     */
    public void setCreateTeamListener(ActionListener listener) {
        createTeamButton.addActionListener(listener);
    }
    
    /**
     * Sets the action listener for the show team button.
     * @param listener The action listener
     */
    public void setShowTeamListener(ActionListener listener) {
        showTeamButton.addActionListener(listener);
    }
    
    /**
     * Sets the action listener for the show lineup button.
     * @param listener The action listener
     */
    public void setShowLineupListener(ActionListener listener) {
        showLineupButton.addActionListener(listener);
    }
}
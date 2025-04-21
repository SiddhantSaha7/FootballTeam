package controller;

import model.*;
import view.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Controller component of the MVC architecture for the U10 Soccer Team application.
 * Manages the flow of data between the model (BritishColumbiaFootballTeam) and the view components.
 * Also responsible for creating and initializing the view.
 */
public class SoccerTeamController implements ISoccerTeamController{
    private MainView mainView;
    private BritishColumbiaFootballTeam team;
    private ArrayList<Player> candidatePlayers;
    private boolean teamCreated = false;
    
    /**
     * Default constructor that initializes the data model.
     * The view will be created when startApplication is called.
     */
    public SoccerTeamController() {
        this.candidatePlayers = new ArrayList<>();
    }
    
    /**
     * Starts the application by creating and initializing the view.
     */
    public void startController() {
        // Create the main view
        this.mainView = new MainView();
        
        // Set up action listeners for all view components
        this.mainView.setupListeners(
            new AddPlayerListener(),
            new RemovePlayerListener(),
            new CreateTeamListener(),
            new ShowTeamListener(),
            new ShowLineupListener()
        );
        
        // Display the view
        this.mainView.setVisible(true);
    }
    
    /**
     * Listener for the add player button.
     */
    class AddPlayerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            PlayerFormData formData = mainView.getPlayerFormData();
            if (formData != null) {
                try {
                    Player player = new SoccerPlayer(
                            formData.getFirstName(),
                            formData.getLastName(),
                            formData.getDOB(),
                            formData.getPosition(),
                            formData.getSkillLevel()
                    );
                    candidatePlayers.add(player);
                    mainView.getPlayerListView().addPlayerToList(player);
                    mainView.clearPlayerForm();
                    mainView.showMessage("Player added to candidate list.");
                } catch (IllegalArgumentException ex) {
                    mainView.showMessage("Error: " + ex.getMessage());
                }
            }
        }

    }
    
    /**
     * Listener for the remove player button.
     */
    class RemovePlayerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            int selectedIndex = mainView.getPlayerListView().getSelectedPlayerIndex();
            if (selectedIndex >= 0) {
                // Remove from controller's data model
                candidatePlayers.remove(selectedIndex);
                // Update view
                mainView.getPlayerListView().removePlayerFromList(selectedIndex);
                mainView.showMessage("Player removed from candidate list.");
            } else {
                mainView.showMessage("No player selected for removal.");
            }
        }
    }
    
    /**
     * Listener for the create team button.
     */
    class CreateTeamListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Use controller's data model directly
            ArrayList<Player> candidates = new ArrayList<>(candidatePlayers);
            
            // Check if we have enough players
            if (candidates.size() < 10) {
                mainView.showMessage("Error: At least 10 players are required to create a team.");
                return;
            }
            
            try {
                // Create the team with candidates
                team = new BritishColumbiaFootballTeam(candidates);
                teamCreated = true;
                
                // Create the starting lineup
                team.createStartingLineup();
                
                mainView.showMessage("Team successfully created with " + candidates.size() + " players.");
                mainView.appendMessage("Jersey numbers have been assigned to all players.");
                mainView.appendMessage("Starting lineup has been created.");
            } catch (IllegalArgumentException ex) {
                mainView.showMessage("Error creating team: " + ex.getMessage());
            }
        }
    }
    
    /**
     * Listener for the show team button.
     */
    class ShowTeamListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!teamCreated || team == null) {
                mainView.showMessage("Team has not been created yet.");
                return;
            }
            
            String teamRoster = team.getAllPlayersSorted();
            mainView.showMessage("Team Roster:\n\n" + teamRoster);
        }
    }
    
    /**
     * Listener for the show lineup button.
     */
    class ShowLineupListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (!teamCreated || team == null) {
                mainView.showMessage("Team has not been created yet.");
                return;
            }
            
            String lineup = team.getStartingLineup();
            mainView.showMessage("Starting Lineup:\n\n" + lineup);
        }
    }
}
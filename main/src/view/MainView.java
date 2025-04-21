package view;

import model.Player;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.format.DateTimeParseException;

/**
 * Main view component that integrates all other view components.
 * Responsible for overall layout and communication between views.
 */
public class MainView extends JFrame implements IMainView{
    private PlayerFormView playerFormView;
    private PlayerListView playerListView;
    private TeamControlsView teamControlsView;
    private JTextArea outputArea;

    /**
     * Constructor to initialize the main frame and all subviews.
     */
    public MainView() {
        // Set up the frame
        setTitle("U10 Soccer Team Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // Main panel with border layout
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(new EmptyBorder(10, 10, 10, 10));

        // Initialize subviews
        playerFormView = new PlayerFormView();
        playerListView = new PlayerListView();
        teamControlsView = new TeamControlsView();

        // Output area
        JPanel outputPanel = createOutputPanel();

        // Add components to main panel
        mainPanel.add(playerFormView, BorderLayout.NORTH);
        mainPanel.add(playerListView, BorderLayout.WEST);
        mainPanel.add(teamControlsView, BorderLayout.CENTER);
        mainPanel.add(outputPanel, BorderLayout.SOUTH);

        // Add main panel to frame
        add(mainPanel);
    }

    /**
     * Creates the panel containing the output text area.
     *
     * @return The output panel
     */
    private JPanel createOutputPanel() {
        JPanel outputPanel = new JPanel(new BorderLayout());

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setPreferredSize(new Dimension(750, 200));

        // Add components to panel
        outputPanel.add(new JLabel("Output:"), BorderLayout.NORTH);
        outputPanel.add(scrollPane, BorderLayout.CENTER);

        // Add border and title
        outputPanel.setBorder(BorderFactory.createTitledBorder("Results"));

        return outputPanel;
    }

    /**
     * Gets the player form view component.
     *
     * @return The player form view
     */
    public PlayerFormView getPlayerFormView() {
        return playerFormView;
    }

    /**
     * Gets the player list view component.
     *
     * @return The player list view
     */
    public PlayerListView getPlayerListView() {
        return playerListView;
    }

    /**
     * Gets the team controls view component.
     *
     * @return The team controls view
     */
    public TeamControlsView getTeamControlsView() {
        return teamControlsView;
    }

    /**
     * Attempts to get player input from the form.
     *
     * @return The player object if valid, null otherwise
     */
    public Player getPlayerInput() {
        try {
            return playerFormView.getPlayerInput();
        } catch (IllegalArgumentException e) {
            showMessage("Error: " + e.getMessage());
            return null;
        } catch (DateTimeParseException e) {
            showMessage("Invalid date format. Please use YYYY-MM-DD.");
            return null;
        }
    }

    /**
     * Gets form data from the input view.
     *
     * @return PlayerFormData or null
     */
    public PlayerFormData getPlayerFormData() {
        try {
            return playerFormView.getPlayerFormData();
        } catch (IllegalArgumentException | DateTimeParseException e) {
            showMessage("Error: " + e.getMessage());
            return null;
        }
    }


    /**
     * Clears the player input form.
     */
    public void clearPlayerForm() {
        playerFormView.clearForm();
    }

    /**
     * Displays a message in the output area.
     *
     * @param message The message to display
     */
    public void showMessage(String message) {
        outputArea.setText(message);
    }

    /**
     * Appends a message to the output area.
     *
     * @param message The message to append
     */
    public void appendMessage(String message) {
        outputArea.append(message + "\n");
    }

    /**
     * Sets up all action listeners for the view components.
     *
     * @param addPlayerListener    Listener for the add player button
     * @param removePlayerListener Listener for the remove player button
     * @param createTeamListener   Listener for the create team button
     * @param showTeamListener     Listener for the show team button
     * @param showLineupListener   Listener for the show lineup button
     */
    public void setupListeners(
            ActionListener addPlayerListener,
            ActionListener removePlayerListener,
            ActionListener createTeamListener,
            ActionListener showTeamListener,
            ActionListener showLineupListener) {

        playerListView.setAddPlayerListener(addPlayerListener);
        playerListView.setRemovePlayerListener(removePlayerListener);
        teamControlsView.setCreateTeamListener(createTeamListener);
        teamControlsView.setShowTeamListener(showTeamListener);
        teamControlsView.setShowLineupListener(showLineupListener);
    }

}
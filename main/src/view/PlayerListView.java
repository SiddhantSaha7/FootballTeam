package view;

import model.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

/**
 * View component responsible for displaying the list of candidate players.
 * Provides a scrollable list and buttons for adding/removing players.
 */
public class PlayerListView extends JPanel implements IPlayerListView{
    private JList<String> playerList;
    private DefaultListModel<String> playerListModel;
    private JButton addPlayerButton;
    private JButton removePlayerButton;
    
    /**
     * Constructor to initialize the player list panel.
     */
    public PlayerListView() {
        setLayout(new BorderLayout(5, 5));
        
        // model.Player list with scrolling
        playerListModel = new DefaultListModel<>();
        playerList = new JList<>(playerListModel);
        JScrollPane scrollPane = new JScrollPane(playerList);
        scrollPane.setPreferredSize(new Dimension(250, 200));
        
        // Button panel
        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 5, 0));
        addPlayerButton = new JButton("Add Player");
        removePlayerButton = new JButton("Remove Player");
        
        buttonPanel.add(addPlayerButton);
        buttonPanel.add(removePlayerButton);
        
        // Add components to panel
        add(new JLabel("Candidate Players:"), BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
        
        // Add border
        setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 10));
    }
    
    /**
     * Adds a player to the displayed list.
     * @param player The player to display
     */
    public void addPlayerToList(Player player) {
        String playerInfo = player.getLastName() + ", " + player.getFirstName() + 
                           " (" + player.getPreferredPosition() + ", Skill: " + player.getSkillLevel() + ")";
        playerListModel.addElement(playerInfo);
    }
    
    /**
     * Gets the index of the selected player in the list.
     * @return The selected index, or -1 if none selected
     */
    public int getSelectedPlayerIndex() {
        return playerList.getSelectedIndex();
    }
    
    /**
     * Removes a player from the displayed list.
     * @param index The index of the player to remove
     */
    public void removePlayerFromList(int index) {
        if (index >= 0 && index < playerListModel.size()) {
            playerListModel.remove(index);
        }
    }
    
    /**
     * Sets the action listener for the add button.
     * @param listener The action listener
     */
    public void setAddPlayerListener(ActionListener listener) {
        addPlayerButton.addActionListener(listener);
    }
    
    /**
     * Sets the action listener for the remove button.
     * @param listener The action listener
     */
    public void setRemovePlayerListener(ActionListener listener) {
        removePlayerButton.addActionListener(listener);
    }
}
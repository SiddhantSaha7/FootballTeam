package view;

import model.Player;
import model.Position;
import model.SoccerPlayer;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * View component responsible for the player input form.
 * Handles the UI for adding new players.
 */
public class PlayerFormView extends JPanel implements IPlayerFormView{
    private JTextField firstNameField;
    private JTextField lastNameField;
    private JTextField dobField;
    private JComboBox<Position> positionComboBox;
    private JComboBox<Integer> skillLevelComboBox;
    
    /**
     * Constructor to initialize the player form panel.
     */
    public PlayerFormView() {
        setLayout(new GridLayout(2, 5, 5, 5));
        
        // Labels
        add(new JLabel("First Name:"));
        add(new JLabel("Last Name:"));
        add(new JLabel("DOB (YYYY-MM-DD):"));
        add(new JLabel("Position:"));
        add(new JLabel("Skill Level:"));
        
        // Input fields
        firstNameField = new JTextField();
        lastNameField = new JTextField();
        dobField = new JTextField();
        
        // Position combo box
        positionComboBox = new JComboBox<>(Position.values());
        
        // Skill level combo box
        Integer[] skillLevels = {1, 2, 3, 4, 5};
        skillLevelComboBox = new JComboBox<>(skillLevels);
        
        // Add components to panel
        add(firstNameField);
        add(lastNameField);
        add(dobField);
        add(positionComboBox);
        add(skillLevelComboBox);
        
        // Add border and title
        setBorder(BorderFactory.createTitledBorder("Add Player"));
    }
    
    /**
     * Clears the player input form.
     */
    public void clearForm() {
        firstNameField.setText("");
        lastNameField.setText("");
        dobField.setText("");
        positionComboBox.setSelectedIndex(0);
        skillLevelComboBox.setSelectedIndex(0);
    }

    /**
     * Gets raw player form input.
     * @return Form data
     */
    public PlayerFormData getPlayerFormData() throws IllegalArgumentException, DateTimeParseException {
        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        String dobString = dobField.getText().trim();
        Position position = (Position) positionComboBox.getSelectedItem();
        int skillLevel = (Integer) skillLevelComboBox.getSelectedItem();

        LocalDate dob = LocalDate.parse(dobString, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        return new PlayerFormData(firstName, lastName, dob, position, skillLevel);
    }

}
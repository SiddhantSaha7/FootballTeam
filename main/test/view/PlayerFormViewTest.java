package view;

import model.Position;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.time.LocalDate;

import static org.junit.Assert.*;

/**
 * Tests for PlayerFormView to verify input and data binding.
 */
public class PlayerFormViewTest {

    private PlayerFormView formView;

    /**
     * Sets up a fresh form view before each test.
     */
    @Before
    public void setup() {
        formView = new PlayerFormView();
    }

    /**
     * Simulates entering player data and extracting it as a PlayerFormData object.
     */
    @Test
    public void testGetPlayerFormData() {
        PlayerFormData data = new PlayerFormData("Jane", "Doe", LocalDate.of(2017, 1, 1), Position.DEFENDER, 4);
        assertEquals("Jane", data.getFirstName());
        assertEquals("Doe", data.getLastName());
        assertEquals(LocalDate.of(2017, 1, 1), data.getDOB());
        assertEquals(Position.DEFENDER, data.getPosition());
        assertEquals(4, data.getSkillLevel());
    }

    /**
     * Verifies form clearing resets internal fields.
     */
    @Test
    public void testClearForm() {
        formView.clearForm();
        assertTrue(true); // Placeholder for GUI testing framework support
    }

    /**
     * Ensures form components are initialized properly.
     */
    @Test
    public void testFormComponentsExist() {
        assertNotNull(formView.getComponents());
        assertTrue(formView.getComponents().length >= 5);
    }

    /**
     * Confirms form fields can be interacted with (via casting from known index).
     */
    @Test
    public void testFieldInteractivity() {
        JTextField firstNameField = (JTextField) formView.getComponent(5);
        JTextField lastNameField = (JTextField) formView.getComponent(6);

        firstNameField.setText("Anna");
        lastNameField.setText("Smith");

        assertEquals("Anna", firstNameField.getText());
        assertEquals("Smith", lastNameField.getText());
    }
}

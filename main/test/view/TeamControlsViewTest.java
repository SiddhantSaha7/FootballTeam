package view; /**
 * JUnit4 test suite for TeamControlsView.
 * Verifies button bindings for team control actions.
 */
import org.junit.Before;
import org.junit.Test;
import view.TeamControlsView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static org.junit.Assert.*;

/**
 * Tests for TeamControlsView to ensure button wiring is functional.
 */
public class TeamControlsViewTest {

    private TeamControlsView controlsView;
    private boolean actionCalled;

    /**
     * Initializes the view before each test.
     */
    @Before
    public void setup() {
        controlsView = new TeamControlsView();
        actionCalled = false;
    }

    /**
     * Tests the create team button binding.
     */
    @Test
    public void testCreateTeamButtonListener() {
        controlsView.setCreateTeamListener(e -> actionCalled = true);
        JButton button = (JButton) controlsView.getComponent(0);
        button.doClick();
        assertTrue(actionCalled);
    }

    /**
     * Tests the show team button binding.
     */
    @Test
    public void testShowTeamButtonListener() {
        controlsView.setShowTeamListener(e -> actionCalled = true);
        JButton button = (JButton) controlsView.getComponent(1);
        button.doClick();
        assertTrue(actionCalled);
    }

    /**
     * Tests the show lineup button binding.
     */
    @Test
    public void testShowLineupButtonListener() {
        controlsView.setShowLineupListener(e -> actionCalled = true);
        JButton button = (JButton) controlsView.getComponent(2);
        button.doClick();
        assertTrue(actionCalled);
    }
} 

package view;

import model.Position;
import model.SoccerPlayer;
import model.Player;
import org.junit.Before;
import org.junit.Test;

import javax.swing.*;
import java.time.LocalDate;

import static org.junit.Assert.*;

/**
 * Tests for PlayerListView component.
 */
public class PlayerListViewTest {

    private PlayerListView listView;
    private Player samplePlayer;

    /**
     * Initializes the list view and a test player before each test.
     */
    @Before
    public void setup() {
        listView = new PlayerListView();
        samplePlayer = new SoccerPlayer("Lily", "Green", LocalDate.of(2016, 4, 15), Position.FORWARD, 4);
    }

    /**
     * Tests adding a player to the visual list.
     */
    @Test
    public void testAddPlayerToList() {
        listView.addPlayerToList(samplePlayer);
        JScrollPane scrollPane = (JScrollPane) listView.getComponent(1);
        JViewport viewport = scrollPane.getViewport();
        JList<?> list = (JList<?>) viewport.getView();
        assertEquals(1, list.getModel().getSize());
    }

    /**
     * Tests removing a player from the list.
     */
    @Test
    public void testRemovePlayerFromList() {
        listView.addPlayerToList(samplePlayer);
        listView.removePlayerFromList(0);
        JScrollPane scrollPane = (JScrollPane) listView.getComponent(1); // this is correct
        JViewport viewport = scrollPane.getViewport();
        JList<?> list = (JList<?>) viewport.getView();
        assertEquals(0, list.getModel().getSize());
    }

    /**
     * Tests index retrieval when a player is selected.
     */
    @Test
    public void testGetSelectedPlayerIndex() {
        listView.addPlayerToList(samplePlayer);
        JScrollPane scrollPane = (JScrollPane) listView.getComponent(1); // this is correct
        JViewport viewport = scrollPane.getViewport();
        JList<?> list = (JList<?>) viewport.getView();
        list.setSelectedIndex(0);
        assertEquals(0, listView.getSelectedPlayerIndex());
    }

    /**
     * Tests no selection returns -1.
     */
    @Test
    public void testNoSelectedPlayerIndex() {
        assertEquals(-1, listView.getSelectedPlayerIndex());
    }
} 

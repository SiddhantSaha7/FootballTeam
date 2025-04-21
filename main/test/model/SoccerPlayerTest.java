package model;

import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class SoccerPlayerTest {
    private SoccerPlayer player;
    private LocalDate testDate;
    private Position testPosition;

    /**
     * Sets up test data before each test
     */
    @Before
    public void setUp() throws Exception {
        testDate = LocalDate.of(2017, 1, 1);
        testPosition = Position.FORWARD;
        player = new SoccerPlayer("John", "Doe", testDate, testPosition, 5);
    }

    /**
     * Tests constructor with position parameter
     */
    @Test
    public void testPositionConstructor() {
        SoccerPlayer posPlayer = new SoccerPlayer("Bob", "Wilson", testDate, testPosition);
        assertEquals("Bob", posPlayer.getFirstName());
        assertEquals("Wilson", posPlayer.getLastName());
        assertEquals(testDate, posPlayer.getDOB());
        assertEquals(testPosition, posPlayer.getPreferredPosition());
        assertEquals(0, posPlayer.getSkillLevel());
    }

    /**
     * Tests full constructor with all parameters
     */
    @Test
    public void testFullConstructor() {
        assertEquals("John", player.getFirstName());
        assertEquals("Doe", player.getLastName());
        assertEquals(testDate, player.getDOB());
        assertEquals(testPosition, player.getPreferredPosition());
        assertEquals(5, player.getSkillLevel());
    }

    /**
     * Tests constructor with invalid skill level
     */
    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithWrongSkillLevel(){
        Player wrongSkillPlayer = new SoccerPlayer("John", "Doe", testDate, testPosition, 51);
    }

    /**
     * Tests getting preferred position
     */
    @Test
    public void testGetPreferredPosition() {
        assertEquals(testPosition, player.getPreferredPosition());
    }

    /**
     * Tests setting preferred position
     */
    @Test
    public void testSetPreferredPosition() {
        Position newPosition = Position.MIDFIELDER;
        player.setPreferredPosition(newPosition);
        assertEquals(newPosition, player.getPreferredPosition());
    }

    /**
     * Tests getting and setting first name
     */
    @Test
    public void testGetAndSetFirstName() {
        player.setFirstName("Mike");
        assertEquals("Mike", player.getFirstName());
    }

    /**
     * Tests getting and setting last name
     */
    @Test
    public void testGetAndSetLastName() {
        player.setLastName("Johnson");
        assertEquals("Johnson", player.getLastName());
    }

    /**
     * Tests getting date of birth
     */
    @Test
    public void testGetDOB() {
        assertEquals(testDate, player.getDOB());
    }

    /**
     * Tests getting and setting skill level
     */
    @Test
    public void testGetAndSetSkillLevel() {
        player.setSkillLevel(5);
        assertEquals(5, player.getSkillLevel());
    }

    /**
     * Tests constructor with null names
     */
    @Test(expected = IllegalArgumentException.class)
    public void testExceptionCaseNullNames() {
        SoccerPlayer nullNamePlayer = new SoccerPlayer(null, null, testDate, Position.GOALIE);
    }

    /**
     * Tests setting negative skill level
     */
    @Test(expected = IllegalArgumentException.class)
    public void testExceptionCaseNegativeSkillLevel() {
        player.setSkillLevel(-5);
        assertEquals(-5, player.getSkillLevel());
    }

    /**
     * Tests constructor with invalid date
     */
    @Test(expected = IllegalArgumentException.class)
    public void testExceptionOlderPlayer() {
        SoccerPlayer nullDatePlayer = new SoccerPlayer("Test", "Player", LocalDate.of(2014, 4, 4), Position.GOALIE);
    }
}
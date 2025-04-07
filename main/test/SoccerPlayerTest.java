import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class SoccerPlayerTest {
    private SoccerPlayer player;
    private LocalDate testDate;
    private Position testPosition;

    @Before
    public void setUp() throws Exception {
        testDate = LocalDate.of(2017, 1, 1);
        testPosition = Position.FORWARD;
        player = new SoccerPlayer("John", "Doe", testDate, testPosition, 5);
    }


    @Test
    public void testPositionConstructor() {
        SoccerPlayer posPlayer = new SoccerPlayer("Bob", "Wilson", testDate, testPosition);
        assertEquals("Bob", posPlayer.getFirstName());
        assertEquals("Wilson", posPlayer.getLastName());
        assertEquals(testDate, posPlayer.getDOB());
        assertEquals(testPosition, posPlayer.getPreferredPosition());
        assertEquals(0, posPlayer.getSkillLevel());
    }

    @Test
    public void testFullConstructor() {
        assertEquals("John", player.getFirstName());
        assertEquals("Doe", player.getLastName());
        assertEquals(testDate, player.getDOB());
        assertEquals(testPosition, player.getPreferredPosition());
        assertEquals(5, player.getSkillLevel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorWithWrongSkillLevel(){
        Player wrongSkillPlayer = new SoccerPlayer("John", "Doe", testDate, testPosition, 51);
    }

    @Test
    public void testGetPreferredPosition() {
        assertEquals(testPosition, player.getPreferredPosition());
    }

    @Test
    public void testSetPreferredPosition() {
        Position newPosition = Position.MIDFIELDER;
        player.setPreferredPosition(newPosition);
        assertEquals(newPosition, player.getPreferredPosition());
    }

    @Test
    public void testGetAndSetFirstName() {
        player.setFirstName("Mike");
        assertEquals("Mike", player.getFirstName());
    }

    @Test
    public void testGetAndSetLastName() {
        player.setLastName("Johnson");
        assertEquals("Johnson", player.getLastName());
    }

    @Test
    public void testGetDOB() {
        assertEquals(testDate, player.getDOB());
    }

    @Test
    public void testGetAndSetSkillLevel() {
        player.setSkillLevel(5);
        assertEquals(5, player.getSkillLevel());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionCaseNullNames() {
        SoccerPlayer nullNamePlayer = new SoccerPlayer(null, null, testDate, Position.GOALIE);

    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionCaseNegativeSkillLevel() {
        player.setSkillLevel(-5);
        assertEquals(-5, player.getSkillLevel()); // Note: You might want to add validation
    }

    @Test(expected = IllegalArgumentException.class)
    public void testExceptionOlderPlayer() {
        SoccerPlayer nullDatePlayer = new SoccerPlayer("Test", "Player", LocalDate.of(2014, 4, 4), Position.GOALIE);
    }
}
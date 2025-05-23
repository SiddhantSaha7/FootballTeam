package model;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BritishColumbiaFootballTeamTest {
    private BritishColumbiaFootballTeam team;
    private List<Player> initialPlayers;

    @Before
    public void setUp() throws Exception {
        // Create a team with exactly MIN_TEAM_SIZE (10) players
        initialPlayers = new ArrayList<>();
        for (int i = 0; i < 19; i++) {
            initialPlayers.add(new SoccerPlayer(
                    "First" + i,
                    "Last" + i,
                    LocalDate.of(2016, 1, 1),
                    Position.values()[i % 4],  // Cycle through positions
                    (int) (Math.random() * 5) + 1
            ));
        }
        team = new BritishColumbiaFootballTeam(initialPlayers);
    }

    /**
     * Tests adding a player to a team that is not full.
     * Verifies the team size increases to 20.
     */
    @Test
    public void addPlayer() {
        Player newPlayer = new SoccerPlayer("New", "Player", LocalDate.of(2016, 2, 2), Position.GOALIE);
        team.addPlayer(newPlayer);
        assertEquals(20, team.getAllPlayersSorted().split("\n").length);
    }

    /**
     * Tests adding a player to a full team (20 players).
     * Expects an IllegalStateException to be thrown.
     */
    @Test(expected = IllegalStateException.class)
    public void addPlayerToFullTeam() {
        BritishColumbiaFootballTeam fullTeam = new BritishColumbiaFootballTeam();
        for (int i = 0; i < 20; i++) {
            fullTeam.addPlayer(new SoccerPlayer("F" + i, "L" + i, LocalDate.of(2016, 1, 1), Position.DEFENDER));
        }
        fullTeam.addPlayer(new SoccerPlayer("Extra", "Player", LocalDate.of(2016, 1, 1), Position.MIDFIELDER));
    }

    /**
     * Tests removing a player from a team with more than the minimum size.
     * Verifies the team size decreases to 18 and the player is no longer listed.
     */
    @Test
    public void removePlayer() {
        Player toRemove = initialPlayers.get(0);
        team.removePlayer(toRemove);
        assertEquals(18, team.getAllPlayersSorted().split("\n").length);
        assertFalse(team.getAllPlayersSorted().contains("Last0"));
    }

    /**
     * Tests removing a player from a team with the minimum size (10).
     * Expects an IllegalStateException to be thrown.
     */
    @Test(expected = IllegalStateException.class)
    public void removePlayerFromMinSizeTeam() {
        for (int i = 0; i < 9; i++) {
            team.removePlayer(initialPlayers.get(i));
        }
        team.removePlayer(initialPlayers.get(0));  // Should throw exception
    }

    /**
     * Tests assigning jersey numbers to all players in a full team.
     * Verifies all 20 players get unique numbers between 1 and 20.
     */
    @Test
    public void assignJerseyNumber() {
        BritishColumbiaFootballTeam fullTeam = new BritishColumbiaFootballTeam();
        for (int i = 0; i < 20; i++) {
            fullTeam.addPlayer(new SoccerPlayer("F" + i, "L" + i, LocalDate.of(2016, 1, 1), Position.values()[i % 4]));
        }
        String players = fullTeam.getAllPlayersSorted();
        String[] playerLines = players.split("\n");

        assertEquals(20, playerLines.length);

        List<Integer> numbers = new ArrayList<>();
        for (String line : playerLines) {
            int jersey = Integer.parseInt(line.split("Jersey Number: ")[1]);
            assertTrue(jersey >= 1 && jersey <= 20);
            assertFalse(numbers.contains(jersey));
            numbers.add(jersey);
        }
    }

    /**
     * Tests creating a starting lineup with varied skills and positions.
     * Verifies the lineup has 7 players with correct position counts.
     */
    @Test
    public void createStartingLineup() {
        team = new BritishColumbiaFootballTeam();
        team.addPlayer(new SoccerPlayer("Goalie", "One", LocalDate.of(2016, 1, 1), Position.GOALIE, 3));
        team.addPlayer(new SoccerPlayer("Def", "One", LocalDate.of(2016, 1, 1), Position.DEFENDER, 2));
        team.addPlayer(new SoccerPlayer("Def", "Two", LocalDate.of(2016, 1, 1), Position.DEFENDER, 4));
        team.addPlayer(new SoccerPlayer("Mid", "One", LocalDate.of(2016, 1, 1), Position.MIDFIELDER, 1));
        team.addPlayer(new SoccerPlayer("Mid", "Two", LocalDate.of(2016, 1, 1), Position.MIDFIELDER, 5));
        team.addPlayer(new SoccerPlayer("Mid", "Three", LocalDate.of(2016, 1, 1), Position.MIDFIELDER, 2));
        team.addPlayer(new SoccerPlayer("Fwd", "One", LocalDate.of(2016, 1, 1), Position.FORWARD, 2));
        team.addPlayer(new SoccerPlayer("Extra", "One", LocalDate.of(2016, 1, 1), Position.FORWARD, 3));
        team.addPlayer(new SoccerPlayer("Extra", "Two", LocalDate.of(2016, 1, 1), Position.DEFENDER, 5));
        team.addPlayer(new SoccerPlayer("Extra", "Three", LocalDate.of(2016, 1, 1), Position.MIDFIELDER, 1));

        team.createStartingLineup();
        String lineup = team.getStartingLineup();
        String[] lines = lineup.split("\n");

        assertEquals(7, lines.length);
        assertTrue(lineup.contains("Position: GOALIE"));
        assertEquals(2, countOccurrences(lineup, "Position: DEFENDER"));
        assertEquals(3, countOccurrences(lineup, "Position: MIDFIELDER"));
        assertTrue(lineup.contains("Position: FORWARD"));
    }

    /**
     * Tests creating a starting lineup when players prefer only one position.
     * Verifies the lineup still has 7 players with all required positions filled.
     */
    @Test
    public void createStartingLineupWithInsufficientPreferredPositions() {
        team = new BritishColumbiaFootballTeam();
        for (int i = 0; i < 10; i++) {
            team.addPlayer(new SoccerPlayer("F" + i, "L" + i, LocalDate.of(2016, 1, 1), Position.MIDFIELDER, (int) (Math.random() * 5) + 1));
        }
        team.createStartingLineup();
        String lineup = team.getStartingLineup();
        String[] lines = lineup.split("\n");

        assertEquals(7, lines.length);
        assertTrue(lineup.contains("Position: GOALIE"));
        assertEquals(2, countOccurrences(lineup, "Position: DEFENDER"));
        assertEquals(3, countOccurrences(lineup, "Position: MIDFIELDER"));
        assertTrue(lineup.contains("Position: FORWARD"));
    }

    /**
     * Tests retrieving all players sorted by last name.
     * Verifies the list has 19 players and is in alphabetical order.
     */
    @Test
    public void getAllPlayersSorted() {
        team.assignJerseyNumber();
        String players = team.getAllPlayersSorted();
        String[] lines = players.split("\n");

        assertEquals(19, lines.length);
        for (int i = 1; i < lines.length; i++) {
            String prevLastName = lines[i - 1].split(", ")[0].split("Name: ")[1];
            String currLastName = lines[i].split(", ")[0].split("Name: ")[1];
            assertTrue(prevLastName.compareToIgnoreCase(currLastName) <= 0);
        }
    }

    /**
     * Tests retrieving the starting lineup sorted by position and last name.
     * Verifies the lineup has 7 players and follows the correct sorting order.
     */
    @Test
    public void getStartingLineup() {
        team = new BritishColumbiaFootballTeam();
        team.addPlayer(new SoccerPlayer("Zack", "Apple", LocalDate.of(2016, 1, 1), Position.GOALIE, 5));
        team.addPlayer(new SoccerPlayer("Bob", "Zebra", LocalDate.of(2016, 1, 1), Position.DEFENDER, 2));
        team.addPlayer(new SoccerPlayer("Alice", "Yak", LocalDate.of(2016, 1, 1), Position.DEFENDER, 4));
        team.addPlayer(new SoccerPlayer("Charlie", "Cat", LocalDate.of(2016, 1, 1), Position.MIDFIELDER, 4));
        team.addPlayer(new SoccerPlayer("Bob", "Bat", LocalDate.of(2016, 1, 1), Position.MIDFIELDER, 2));
        team.addPlayer(new SoccerPlayer("Dave", "Dog", LocalDate.of(2016, 1, 1), Position.MIDFIELDER, 5));
        team.addPlayer(new SoccerPlayer("Eve", "Fox", LocalDate.of(2016, 1, 1), Position.FORWARD, 4));
        team.addPlayer(new SoccerPlayer("Extra", "One", LocalDate.of(2016, 1, 1), Position.FORWARD, 1));
        team.addPlayer(new SoccerPlayer("Extra", "Two", LocalDate.of(2016, 1, 1), Position.DEFENDER, 1));
        team.addPlayer(new SoccerPlayer("Extra", "Three", LocalDate.of(2016, 1, 1), Position.MIDFIELDER, 2));

        team.assignJerseyNumber();
        team.createStartingLineup();
        String lineup = team.getStartingLineup();
        String[] lines = lineup.split("\n");

        assertEquals(7, lines.length);
        assertTrue(lines[0].contains("Position: GOALIE"));  // Apple
        assertTrue(lines[1].contains("Position: DEFENDER") && lines[1].contains("Yak"));  // Alice Yak
        assertTrue(lines[2].contains("Position: DEFENDER") && lines[2].contains("Zebra"));  // Bob Zebra
        assertTrue(lines[3].contains("Position: MIDFIELDER") && lines[3].contains("Bat"));  // Bob Bat
        assertTrue(lines[4].contains("Position: MIDFIELDER") && lines[4].contains("Cat"));  // Charlie Cat
        assertTrue(lines[5].contains("Position: MIDFIELDER") && lines[5].contains("Dog"));  // Dave Dog
        assertTrue(lines[6].contains("Position: FORWARD"));  // Fox
    }

    /**
     * Tests constructing a team with fewer than 10 players.
     * Expects an IllegalArgumentException to be thrown.
     */
    @Test(expected = IllegalArgumentException.class)
    public void constructorWithTooFewPlayers() {
        List<Player> tooFew = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            tooFew.add(new SoccerPlayer("F" + i, "L" + i, LocalDate.of(2016, 1, 1), Position.values()[i % 4]));
        }
        new BritishColumbiaFootballTeam(tooFew);
    }

    /**
     * Tests constructing a team with more than 20 players.
     * Expects the lowest ranked player to be trimmed
     */
    @Test
    public void constructorWithTooManyPlayers() {
        List<Player> tooMany = new ArrayList<>();
        for (int i = 0; i < 21; i++) {
            tooMany.add(new SoccerPlayer("F" + i, "L" + i, LocalDate.of(2016, 1, 1), Position.values()[i % 4]));
        }
        Team newTeam = new BritishColumbiaFootballTeam(tooMany);
        assertEquals(20, newTeam.getAllPlayersSorted().split("\n").length);
    }


    /**
     * Helper method to count occurrences of a substring in a text.
     * @param text The text to search in
     * @param substring The substring to count
     * @return The number of occurrences
     */
    private int countOccurrences(String text, String substring) {
        int count = 0;
        int index = 0;
        while ((index = text.indexOf(substring, index)) != -1) {
            count++;
            index += substring.length();
        }
        return count;
    }
}
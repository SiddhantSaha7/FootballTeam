import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Demonstrates usage of soccer team classes.
 */
public class Driver {

    /**
     * Main method to run the demonstration.
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {

        Player p1 = new SoccerPlayer("Adil", "Jain", LocalDate.of(2016, 10, 12), Position.GOALIE, 3);
        Player p2 = new SoccerPlayer("Liam", "Parker", LocalDate.of(2016, 5, 23), Position.DEFENDER, 3);
        Player p3 = new SoccerPlayer("Emma", "Soto", LocalDate.of(2017, 2, 17), Position.MIDFIELDER, 4);
        Player p4 = new SoccerPlayer("Noah", "Kumar", LocalDate.of(2016, 8, 30), Position.FORWARD, 2);
        Player p5 = new SoccerPlayer("Ava", "Chen", LocalDate.of(2018, 12, 1), Position.DEFENDER, 5);
        Player p6 = new SoccerPlayer("Ethan", "Rossi", LocalDate.of(2016, 3, 15), Position.MIDFIELDER, 1);
        Player p7 = new SoccerPlayer("Sophia", "Ali", LocalDate.of(2017, 7, 9), Position.FORWARD, 3);
        Player p8 = new SoccerPlayer("Mason", "Wong", LocalDate.of(2019, 1, 27), Position.GOALIE, 4);
        Player p9 = new SoccerPlayer("Isabella", "Diaz", LocalDate.of(2016, 11, 4), Position.MIDFIELDER, 2);
        Player p10 = new SoccerPlayer("Lucas", "Kim", LocalDate.of(2018, 6, 19), Position.DEFENDER, 5);
        Player p11 = new SoccerPlayer("Mia", "Patel", LocalDate.of(2016, 9, 8), Position.FORWARD, 3);
        Player p12 = new SoccerPlayer("James", "Lopez", LocalDate.of(2019, 4, 25), Position.DEFENDER, 1);
        Player p13 = new SoccerPlayer("Olivia", "Nguyen", LocalDate.of(2016, 10, 31), Position.MIDFIELDER, 4);
        Player p14 = new SoccerPlayer("William", "Singh", LocalDate.of(2017, 3, 14), Position.DEFENDER, 2);
        Player p15 = new SoccerPlayer("Amelia", "Cruz", LocalDate.of(2019, 8, 7), Position.FORWARD, 5);
        Player p16 = new SoccerPlayer("Benjamin", "Ito", LocalDate.of(2016, 12, 22), Position.GOALIE, 3);
        Player p17 = new SoccerPlayer("Charlotte", "Reyes", LocalDate.of(2018, 5, 16), Position.MIDFIELDER, 1);
        Player p18 = new SoccerPlayer("Elijah", "Gupta", LocalDate.of(2017, 2, 28), Position.DEFENDER, 4);
        Player p19 = new SoccerPlayer("Harper", "Silva", LocalDate.of(2019, 7, 11), Position.FORWARD, 2);
        Player p20 = new SoccerPlayer("Alexander", "Yama", LocalDate.of(2017, 9, 3), Position.MIDFIELDER, 5);
        Player p21 = new SoccerPlayer("Alexander", "Skaarsgard", LocalDate.of(2016, 9, 3), Position.DEFENDER, 1);

        ArrayList<Player> a = new ArrayList<>();
        a.add(p1);
        a.add(p2);
        a.add(p3);
        a.add(p4);
        a.add(p5);
        a.add(p6);
        a.add(p7);
        a.add(p8);
        a.add(p9);
        a.add(p10);
        a.add(p11);
        a.add(p12);
        a.add(p13);
        a.add(p14);
        a.add(p15);
        a.add(p16);
        a.add(p17);
        a.add(p18);
        a.add(p19);
        a.add(p20);
        a.add(p21);
        // Testing creation of team
        BritishColumbiaFootballTeam team = new BritishColumbiaFootballTeam(a);
        // Testing getting all the players in the team
        System.out.println(team.getAllPlayersSorted());
        // Testing creation of the starting lineup

        team.createStartingLineup();
        System.out.println(team.getStartingLineup());

        // Testing removing and adding player from team + creating lineup if not players exists of a certain position
        // All the goalies are removed in this test
        team.removePlayer(p1);
        team.removePlayer(p8);
        team.removePlayer(p16);

        System.out.println(team.getAllPlayersSorted());
        System.out.println(team.getStartingLineup());
    }
}
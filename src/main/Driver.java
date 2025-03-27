import java.util.ArrayList;
import java.util.Date;

/**
 * Demonstrates usage of soccer team classes.
 */
public class Driver {

    /**
     * Main method to run the demonstration.
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        Player p1 = new SoccerPlayer("Adil", "Jain", new Date(2010, 10, 12), Position.GOALIE, 3);
        Player p2 = new SoccerPlayer("Liam", "Parker", new Date(2008, 5, 23), Position.DEFENDER, 3);
        Player p3 = new SoccerPlayer("Emma", "Soto", new Date(2011, 2, 17), Position.MIDFIELDER, 4);
        Player p4 = new SoccerPlayer("Noah", "Kumar", new Date(2009, 8, 30), Position.FORWARD, 2);
        Player p5 = new SoccerPlayer("Ava", "Chen", new Date(2012, 12, 1), Position.DEFENDER, 5);
        Player p6 = new SoccerPlayer("Ethan", "Rossi", new Date(2007, 3, 15), Position.MIDFIELDER, 1);
        Player p7 = new SoccerPlayer("Sophia", "Ali", new Date(2010, 7, 9), Position.FORWARD, 3);
        Player p8 = new SoccerPlayer("Mason", "Wong", new Date(2013, 1, 27), Position.GOALIE, 4);
        Player p9 = new SoccerPlayer("Isabella", "Diaz", new Date(2008, 11, 4), Position.MIDFIELDER, 2);
        Player p10 = new SoccerPlayer("Lucas", "Kim", new Date(2011, 6, 19), Position.DEFENDER, 5);
        Player p11 = new SoccerPlayer("Mia", "Patel", new Date(2009, 9, 8), Position.FORWARD, 3);
        Player p12 = new SoccerPlayer("James", "Lopez", new Date(2012, 4, 25), Position.DEFENDER, 1);
        Player p13 = new SoccerPlayer("Olivia", "Nguyen", new Date(2007, 10, 31), Position.MIDFIELDER, 4);
        Player p14 = new SoccerPlayer("William", "Singh", new Date(2010, 3, 14), Position.DEFENDER, 2);
        Player p15 = new SoccerPlayer("Amelia", "Cruz", new Date(2013, 8, 7), Position.FORWARD, 5);
        Player p16 = new SoccerPlayer("Benjamin", "Ito", new Date(2008, 12, 22), Position.GOALIE, 3);
        Player p17 = new SoccerPlayer("Charlotte", "Reyes", new Date(2011, 5, 16), Position.MIDFIELDER, 1);
        Player p18 = new SoccerPlayer("Elijah", "Gupta", new Date(2009, 2, 28), Position.DEFENDER, 4);
        Player p19 = new SoccerPlayer("Harper", "Silva", new Date(2012, 7, 11), Position.FORWARD, 2);
        Player p20 = new SoccerPlayer("Alexander", "Yama", new Date(2007, 9, 3), Position.MIDFIELDER, 5);

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

        // Testing creation of team
        BritishColumbiaFootballTeam team = new BritishColumbiaFootballTeam(a);
        // Testing Jersey Number Assignment
        team.assignJerseyNumber();
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
        Player p21 = new SoccerPlayer("Alexander", "Skaarsgard", new Date(2009, 9, 3), Position.DEFENDER, 1);
        team.addPlayer(p21);
        System.out.println(team.getAllPlayersSorted());

        team.createStartingLineup();
        System.out.println(team.getStartingLineup());
    }
}
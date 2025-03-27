import java.io.StringBufferInputStream;
import java.lang.reflect.Array;
import java.util.*;

public class BritishColumbiaFootballTeam implements Team {
  private List<Player> players;
  private List<Player> startingLineup;
  private Set<Integer> assignedJerseyNumbers;

  private static final int MAX_TEAM_SIZE = 20;
  private static final int MIN_TEAM_SIZE = 10;
  private static final int STARTING_LINEUP_SIZE = 7;

  public BritishColumbiaFootballTeam() {
    this.players = new ArrayList<>();
    this.startingLineup = new ArrayList<>();
    this.assignedJerseyNumbers = new HashSet<>();
  }

  public BritishColumbiaFootballTeam(List<Player> players) {
    this.players = new ArrayList<>(players);
    this.startingLineup = new ArrayList<>();
    this.assignedJerseyNumbers = new HashSet<>();
  }

  @Override
  public void addPlayer(Player p) throws IllegalStateException{
    if (this.players.size() == MAX_TEAM_SIZE){
      throw new IllegalStateException("You cannot have more than 20 members in a team!");
    }
    else{
      this.players.add(p);
    }
  }

  @Override
  public void removePlayer(Player p) throws IllegalStateException{
  if (this.players.size() == MIN_TEAM_SIZE){}
    throw new IllegalStateException("You cannot have less than 10 members in a team!");
  }

  @Override
  public void assignJerseyNumber() {
    int teamSize = this.players.size();
    int i = 0;
    while(teamSize != i){
      if (this.players.get(i).getJerseyNumber() != 0){
        i++;
        continue;
      }
      int jerseyNum = (int) ((Math.random() * 20) + 1);
      if (!assignedJerseyNumbers.contains(jerseyNum)) {
        this.players.get(i).setJerseyNumber(jerseyNum);
        assignedJerseyNumbers.add(jerseyNum);
        i++;
      }
    }
  }

  @Override
  public void addPlayersToStartingLineup() {
    ArrayList<Player> copyList = new ArrayList<>(this.players);

    Collections.sort(copyList, new Comparator<Player>() {
      @Override
      public int compare(Player p1, final Player p2) {
        return -1*(Integer.valueOf(p1.getSkillLevel()).compareTo(Integer.valueOf(p2.getSkillLevel())));
      }
    });
//    Collections.sort(copyList, Collections.reverseOrder());
    Iterator<Player> it = copyList.iterator();
    int goalieCount = 1;
    int defenderCount = 2;
    int midfielderCount = 3;
    int forwardCount = 1;
    while (it.hasNext()){
      Player currPlayer = it.next();

      if (currPlayer.getPreferredPosition()==Position.GOALIE && goalieCount > 0){
        this.startingLineup.add(currPlayer);
        goalieCount--;
      }
      else if (currPlayer.getPreferredPosition()==Position.DEFENDER && defenderCount > 0){
        this.startingLineup.add(currPlayer);
        defenderCount--;
      }
      else if (currPlayer.getPreferredPosition()==Position.MIDFIELDER && midfielderCount > 0){
        this.startingLineup.add(currPlayer);
        midfielderCount--;
      }
      else if (currPlayer.getPreferredPosition()==Position.FORWARD && forwardCount > 0){
        this.startingLineup.add(currPlayer);
        forwardCount--;
      }
      if (this.startingLineup.size() == STARTING_LINEUP_SIZE){
        break;
      }
    }
    it = copyList.iterator();
    while (it.hasNext() && this.startingLineup.size() != 7){
      Player currPlayer = it.next();
      if (this.startingLineup.contains(currPlayer)){
        continue;
      }
      else{
        if (goalieCount > 0){
          currPlayer.setPreferredPosition(Position.GOALIE);
          this.startingLineup.add(currPlayer);
          goalieCount--;
        }
        else if (defenderCount > 0){
          currPlayer.setPreferredPosition(Position.DEFENDER);
          this.startingLineup.add(currPlayer);
          defenderCount--;
        }
        else if (midfielderCount > 0){
          currPlayer.setPreferredPosition(Position.MIDFIELDER);
          this.startingLineup.add(currPlayer);
          midfielderCount--;
        }
        else if (forwardCount > 0){
          currPlayer.setPreferredPosition(Position.FORWARD);
          this.startingLineup.add(currPlayer);
          forwardCount--;
        }

        if (this.startingLineup.size() == STARTING_LINEUP_SIZE){
          break;
        }
      }
    }
  }

  @Override
  public List<Player> getPlayer() {
    return new ArrayList<>(players);
  }

  @Override
  public String getAllPlayersSorted() {
    ArrayList<Player> copyList = new ArrayList<>(this.players);
    Collections.sort(copyList, new Comparator<Player>() {
      @Override
      public int compare(Player p1, final Player p2) {
        return p1.getLastName().compareToIgnoreCase(p2.getLastName());
      }
    });
    Iterator<Player> it = copyList.iterator();
    String teamList = "";
    while (it.hasNext()){
      Player currPlayer = it.next();
      teamList +=  "Name: " +currPlayer.getLastName() + ", " + currPlayer.getFirstName() + "; Jersey Number: " + String.valueOf(currPlayer.getJerseyNumber()) + "\n";
    }
    return teamList;
  }

  @Override
  public String getStartingLineup() {
    ArrayList<Player> copyList = new ArrayList<>(this.startingLineup);
    Collections.sort(copyList, new Comparator<Player>() {
      @Override
      public int compare(Player p1, final Player p2) {
        int posCompare = p1.getPreferredPosition().compareTo(p2.getPreferredPosition());
        if (posCompare == 0){
          return p1.getLastName().compareToIgnoreCase(p2.getLastName());
        }
        else{
          return posCompare;
        }
      }
    });

    Iterator<Player> it = copyList.iterator();
    String lineup = "";
    while (it.hasNext()){
      Player currPlayer = it.next();
      lineup +=  "Name: " +currPlayer.getLastName() + ", " + currPlayer.getFirstName() + "; Jersey Number: " + String.valueOf(currPlayer.getJerseyNumber()) + "; Position: "+ currPlayer.getPreferredPosition().toString() + "\n";
    }
    return lineup;
  }

  public static void main(String[] args){
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
    Player p12 = new SoccerPlayer("James", "Lopez", new Date(2012, 4, 25), Position.GOALIE, 1);
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

    BritishColumbiaFootballTeam team = new BritishColumbiaFootballTeam(a);
    team.assignJerseyNumber();
    System.out.println(team.getAllPlayersSorted());
    team.addPlayersToStartingLineup();
    System.out.println(team.getStartingLineup());
  }
}

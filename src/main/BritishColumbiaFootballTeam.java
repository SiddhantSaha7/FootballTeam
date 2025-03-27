package src.main;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import main.Player;

public class BritishColumbiaFootballTeam implements Team {
  private List<Player> players;
  private List<Player> startingLineup;
  private Set<Integer> assignedJerseyNumbers;
  private static final int MAX_TEAM_SIZE = 20;
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
  public boolean addPlayer(Player p) {
    return false;
  }

  @Override
  public void removePlayer(Player p) {

  }


  @Override
  public void assignJerseyNumber() {

  }

  @Override
  public void addPlayersToStartingLineup() {

  }

  @Override
  public List<Player> getPlayer() {
    return new ArrayList<>(players);
  }

  @Override
  public List<Player> getAllPlayersSorted() {
    return List.of();
  }

  @Override
  public List<Player> getStartingLineup() {
    return List.of();
  }
}

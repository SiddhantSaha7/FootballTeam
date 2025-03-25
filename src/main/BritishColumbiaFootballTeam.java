package main;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    if (players.size() >= MAX_TEAM_SIZE) {
      System.out.println("Team is full (max size: " + MAX_TEAM_SIZE + "). Cannot add " + p.getFirstName() + " " + p.getLastName() + ".");
      return false;
    }

    players.add(p);
    System.out.println("Added " + p.getFirstName() + " " + p.getLastName() + " to the team.");
    return true;
  }

  @Override
  public void removePlayer(Player p) {
    if (players.contains(p)) {
      players.remove(p);
      startingLineup.remove(p);
      if (p.getJerseyNumber() != 0) {
        assignedJerseyNumbers.remove(p.getJerseyNumber());
      }
      p.setJerseyNumber(0); // Reset jersey number
      System.out.println("Removed " + p.getFirstName() + " " + p.getLastName() + " from the team.");
    } else {
      System.out.println(p.getFirstName() + " " + p.getLastName() + " is not in the team.");
    }

  }

  @Override
  public void assignJerseyNumber() {
    assignedJerseyNumbers.clear(); // Reset jersey numbers
    for (int i = 0; i < players.size(); i++) {
      int jerseyNumber = i + 1;
      players.get(i).setJerseyNumber(jerseyNumber);
      assignedJerseyNumbers.add(jerseyNumber);
    }
    System.out.println("Jersey numbers assigned to all players.");

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

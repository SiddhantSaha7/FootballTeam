import java.util.List;

public interface Team {
  void addPlayer(Player p);
  void removePlayer(Player p);
  void assignJerseyNumber();
  void addPlayersToStartingLineup();
  List<Player> getPlayer();
  String getAllPlayersSorted();
  String getStartingLineup();
}

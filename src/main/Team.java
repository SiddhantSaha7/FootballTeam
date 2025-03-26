package src.main;

import main.Player;

import java.util.List;

public interface Team {
  boolean addPlayer(Player p);
  void removePlayer(Player p);
  void assignJerseyNumber();
  void addPlayersToStartingLineup();
  List<Player> getPlayer();
  List<Player> getAllPlayersSorted();
  List<Player> getStartingLineup();
}

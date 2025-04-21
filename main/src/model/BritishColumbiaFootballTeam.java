package model;

import java.util.*;

/**
 * A U10 soccer team implementation.
 */
public class BritishColumbiaFootballTeam implements Team {
    /**
     * All players
     */
    private List<Player> players;
    /**
     * Starting lineup
     */
    private List<Player> startingLineup;
    /**
     * Assigned jersey numbers
     */
    private Map<Player, Integer> assignedJerseyNumbers;

    /**
     * Max team size
     */
    private static final int MAX_TEAM_SIZE = 20;
    /**
     * Min team size
     */
    private static final int MIN_TEAM_SIZE = 10;
    /**
     * Starting lineup size
     */
    private static final int STARTING_LINEUP_SIZE = 7;

    /**
     * Creates empty team
     */
    public BritishColumbiaFootballTeam() {
        this.players = new ArrayList<>();
        this.startingLineup = new ArrayList<>();
        this.assignedJerseyNumbers = new HashMap<>();
    }

    /**
     * Creates team with players, and assigns them the jersey numbers
     * This does not create the starting lineup, only the team
     *
     * @param players List of players
     * @throws IllegalArgumentException if size invalid (>20 or <10)
     */
    public BritishColumbiaFootballTeam(List<Player> players) throws IllegalArgumentException {
        if (players.size() > 20) {
            Collections.sort(players, new Comparator<Player>() {
                @Override
                public int compare(Player p1, final Player p2) {
                    return -1 * (Integer.valueOf(p1.getSkillLevel()).compareTo(Integer.valueOf(p2.getSkillLevel())));
                }
            });
            players = players.subList(0, 20);
            ;
        }
        if (players.size() < 10) {
            throw new IllegalArgumentException("Team size should be between 10-20 players!");
        }
        this.players = new ArrayList<>(players);
        this.startingLineup = new ArrayList<>();
        this.assignedJerseyNumbers = new HashMap<>();
        // assign jersey numbers to all the players
        this.assignJerseyNumber();
    }

    /**
     * Adds player to the team
     * This just adds the player to the team, not to the starting lineup
     * Assign jersey number to the players again
     *
     * @param p the player to be added
     * @throws IllegalStateException if team already has 20 players
     */
    @Override
    public void addPlayer(Player p) throws IllegalStateException {
        if (this.players.size() == MAX_TEAM_SIZE) {
            throw new IllegalStateException("You cannot have more than 20 members in a team!");
        } else {
            this.players.add(p);
            this.assignJerseyNumber();
        }
    }

    /**
     * Removes player from the team
     * This removes the player from the team and removes his jersey number as well
     * If he is a part of the starting lineup, then the player is removed from there as well
     *
     * @param p the player to be removed
     * @throws IllegalStateException if team has only 10 players
     */
    @Override
    public void removePlayer(Player p) throws IllegalStateException {
        if (this.players.size() == MIN_TEAM_SIZE) {
            throw new IllegalStateException("You cannot have less than 10 members in a team!");
        }
        this.players.remove(p);
        // Remove the jersey number of the player
        this.assignedJerseyNumbers.remove(p);
        // Remove from starting lineup if player is a part of it and then recreate starting lineup
        if (this.startingLineup.contains(p)) {
            this.startingLineup.remove(p);
            this.createStartingLineup();
        }
    }

    /**
     * Assigns jersey numbers
     */
    @Override
    public void assignJerseyNumber() {
        for (Player p: this.players) {

            if (this.assignedJerseyNumbers.containsKey(p)) {
                continue;
            }
            int jerseyNum = (int) ((Math.random() * 20) + 1);
            while (this.assignedJerseyNumbers.containsValue(jerseyNum)) {
                jerseyNum = (int) ((Math.random() * 20) + 1);
            }
            this.assignedJerseyNumbers.put(p, jerseyNum);
        }
    }

    /**
     * Creates starting lineup
     */
    @Override
    public void createStartingLineup() {
        this.startingLineup.clear();
        ArrayList<Player> copyList = new ArrayList<>(this.players);
        Collections.sort(copyList, new Comparator<Player>() {
            @Override
            public int compare(Player p1, final Player p2) {
                return -1 * (Integer.valueOf(p1.getSkillLevel()).compareTo(Integer.valueOf(p2.getSkillLevel())));
            }
        });

        int goalieCount = 1;
        int defenderCount = 2;
        int midfielderCount = 3;
        int forwardCount = 1;
        for (Player currPlayer : copyList) {

            if (currPlayer.getPreferredPosition() == Position.GOALIE && goalieCount > 0) {
                this.startingLineup.add(currPlayer);
                currPlayer.setAssignedPosition(Position.GOALIE);
                goalieCount--;
            } else if (currPlayer.getPreferredPosition() == Position.DEFENDER && defenderCount > 0) {
                this.startingLineup.add(currPlayer);
                currPlayer.setAssignedPosition(Position.DEFENDER);
                defenderCount--;
            } else if (currPlayer.getPreferredPosition() == Position.MIDFIELDER && midfielderCount > 0) {
                this.startingLineup.add(currPlayer);
                currPlayer.setAssignedPosition(Position.MIDFIELDER);
                midfielderCount--;
            } else if (currPlayer.getPreferredPosition() == Position.FORWARD && forwardCount > 0) {
                this.startingLineup.add(currPlayer);
                currPlayer.setAssignedPosition(Position.FORWARD);
                forwardCount--;
            }
            if (this.startingLineup.size() == STARTING_LINEUP_SIZE) {
                break;
            }
        }

        for (Player currPlayer : copyList) {
            if (this.startingLineup.size() != STARTING_LINEUP_SIZE) {
                if (this.startingLineup.contains(currPlayer)) {
                    continue;
                } else {
                    if (goalieCount > 0) {
                        this.startingLineup.add(currPlayer);
                        currPlayer.setAssignedPosition(Position.GOALIE);
                        goalieCount--;
                    } else if (defenderCount > 0) {
                        this.startingLineup.add(currPlayer);
                        currPlayer.setAssignedPosition(Position.DEFENDER);
                        defenderCount--;
                    } else if (midfielderCount > 0) {
                        this.startingLineup.add(currPlayer);
                        currPlayer.setAssignedPosition(Position.MIDFIELDER);
                        midfielderCount--;
                    } else if (forwardCount > 0) {
                        this.startingLineup.add(currPlayer);
                        currPlayer.setAssignedPosition(Position.FORWARD);
                        forwardCount--;
                    }

                    if (this.startingLineup.size() == STARTING_LINEUP_SIZE) {
                        break;
                    }
                }
            }
        }
    }

    /**
     * Gets all players sorted
     *
     * @return String of players
     */
    @Override
    public String getAllPlayersSorted() {
        ArrayList<Player> copyList = new ArrayList<>(this.players);
        Collections.sort(copyList, new Comparator<Player>() {
            @Override
            public int compare(Player p1, final Player p2) {
                return p1.getLastName().compareToIgnoreCase(p2.getLastName());
            }
        });
        StringBuilder teamList = new StringBuilder();
        for (Player currPlayer: copyList) {
            teamList.append("Name: ").append(currPlayer.getLastName()).append(", ").append(currPlayer.getFirstName()).append("; Jersey Number: ").append(this.assignedJerseyNumbers.get(currPlayer)).append("\n");
        }
        return teamList.toString();
    }

    /**
     * Gets starting lineup
     *
     * @return String of lineup
     */
    @Override
    public String getStartingLineup() {
        ArrayList<Player> copyList = new ArrayList<>(this.startingLineup);
        Collections.sort(copyList, new Comparator<Player>() {
            @Override
            public int compare(Player p1, final Player p2) {
                int posCompare = p1.getAssignedPosition().compareTo(p2.getAssignedPosition());
                if (posCompare == 0) {
                    return p1.getLastName().compareToIgnoreCase(p2.getLastName());
                } else {
                    return posCompare;
                }
            }
        });

        StringBuilder lineup = new StringBuilder();
        for (Player currPlayer: copyList) {
            lineup.append("Name: ").append(currPlayer.getLastName()).append(", ").append(currPlayer.getFirstName()).append("; Jersey Number: ").append(this.assignedJerseyNumbers.get(currPlayer)).append("; Position: ").append(currPlayer.getAssignedPosition().toString()).append("\n");
        }
        return lineup.toString();
    }
}
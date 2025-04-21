package view;

import model.Player;
import java.awt.event.ActionListener;

/**
 * Interface for the view component that displays candidate players.
 * Supports adding, removing, and selecting players from the list.
 */
public interface IPlayerListView {

    /**
     * Adds a player to the displayed list.
     * @param player the player to add
     */
    void addPlayerToList(Player player);

    /**
     * Gets the index of the selected player in the list.
     * @return index of selected player, or -1 if none
     */
    int getSelectedPlayerIndex();

    /**
     * Removes a player at a given index from the list.
     * @param index index of the player to remove
     */
    void removePlayerFromList(int index);

    /**
     * Sets the action listener for the add player button.
     * @param listener the action listener
     */
    void setAddPlayerListener(ActionListener listener);

    /**
     * Sets the action listener for the remove player button.
     * @param listener the action listener
     */
    void setRemovePlayerListener(ActionListener listener);
}

package nuk.logic;

import java.util.Arrays;

public class TurnService implements ITurnService {

    private GameSettings settings;
    private Player currentPlayer;

    public TurnService() {
        settings = SettingsManager.getInstance().getSettings();
        currentPlayer = settings.getPlayers()[0];
    }

    @Override
    public Player getCurrentTurn() {
        return currentPlayer;
    }

    @Override
    public void next() {
        Player[] players = settings.getPlayers();
        int idx = Arrays.asList(players).indexOf(currentPlayer);

        currentPlayer = players[(idx + 1) % players.length];
    }
}

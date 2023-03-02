package nuk;


import nuk.logic.Figure;
import nuk.logic.GameManager;
import nuk.logic.GameSettings;
import nuk.logic.SettingsManager;
import nuk.util.Vector2D;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Figure[] players = {
                new Figure("x", Color.CYAN),
                new Figure("o", Color.MAGENTA)
        };

        GameSettings gameSettings = new GameSettings(
                new Vector2D(3, 3),
                players,
                3
                );

        SettingsManager settingsManager = SettingsManager.getInstance();
        settingsManager.setSettings(gameSettings);

        GameManager gameManager = new GameManager();
        gameManager.newGame();
        gameManager.startGame();

    }
}
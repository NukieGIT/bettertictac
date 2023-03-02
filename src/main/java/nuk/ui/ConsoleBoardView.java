package nuk.ui;

import nuk.events.Event;
import nuk.events.EventManager;
import nuk.logic.BoardModel;
import nuk.logic.Figure;
import nuk.logic.GameSettings;
import nuk.logic.SettingsManager;
import nuk.util.Vector2D;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class ConsoleBoardView implements IBoardView {

    boolean hasWon;
    private boolean stopInput;
    private GameSettings settings;
    private EventManager<Vector2D> onNewPosition;
    private BoardModel model;

    public ConsoleBoardView(BoardModel model) {
        this.model = model;
        hasWon = false;
        stopInput = false;
        settings = SettingsManager.getInstance().getSettings();
        onNewPosition = new EventManager<>();
    }

    public void handleWinEvent(Figure figure) {
        stopInput = true;
        System.out.println(figure.getFigure());
    }

    private void renderBoard() {
        Vector2D size = settings.getSize();

        for (int i = 0; i < size.y; i++) {
            for (int j = 0; j < size.x; j++) {

                Figure figure = model.getMap().get(new Vector2D(j, i));
                String val = figure == null ? " " : figure.getFigure();

                if (j == size.x - 1) {
                    System.out.printf(" %s ", val);
                } else {
                    System.out.printf(" %s |", val);
                }
            }
            if (i == size.y - 1) continue;
            String s = "";
            for (int j = 0; j < size.x; j++) {
                if (j == size.x - 1) {
                    s += "---";
                } else {
                    s += "---+";
                }
            }
            System.out.println();
            System.out.println(s);
        }

    }

    @Override
    public void show() {
        renderBoard();
        getUserInput();
    }

    private void getUserInput() {
        while (!stopInput) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("\nYour Move: ");
            String userInput = null;
            try {
                userInput = br.readLine();
            } catch (IOException e) {
                System.out.println("error while getting user input");
                System.out.println(e.getMessage());
            }
            String[] splitUserInput = userInput.trim().split("\\s+");
            Vector2D pos = new Vector2D(Integer.parseInt(splitUserInput[0]), Integer.parseInt(splitUserInput[1]));
            onNewPosition.invoke(this, pos);
            renderBoard();
        }
        stopInput = false;
    }

    @Override
    public void hide() {
        stopInput = true;
    }

    @Override
    public Event<Vector2D> getNewPositionEvent() {
        return onNewPosition.getEvent();
    }
}

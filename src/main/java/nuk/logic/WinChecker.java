package nuk.logic;


import nuk.util.Vector2D;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class WinChecker {

    private ArrayList<Vector2D> visited = new ArrayList<>();
    private ArrayList<Vector2D> correctPositions = new ArrayList<>();

    private GameSettings settings;

    private final Vector2D[] DIRECTIONS = {
            new Vector2D(1, 0),
            new Vector2D(0, 1),
            new Vector2D(1, 1),
            new Vector2D(-1, 1)
    };

    public WinChecker() {
        settings = SettingsManager.getInstance().getSettings();
    }

    public Player WinnerCheck(HashMap<Vector2D, Player> map) {
        int toWin = settings.getToWin();
        visited.clear();

        for(Map.Entry<Vector2D, Player> entry : map.entrySet()) {
            Vector2D k = entry.getKey();
            Player v = entry.getValue();

            for (Vector2D dir : DIRECTIONS) {
                correctPositions.clear();
                correctPositions.add(k);
                IsPosValid(map, toWin, k, v, dir, false);
                IsPosValid(map, toWin, k, v, dir, true);

                if (correctPositions.size() >= toWin) {
                    return v;
                }
            }
        }
        return null;
    }

    private void IsPosValid(HashMap<Vector2D, Player> map, int toWin, Vector2D k, Player v, Vector2D dir, boolean isReverse) {
        int checkDir = 1;
        if (isReverse) checkDir = -1;

        for (int i = 1; i < toWin; i++) {
            Vector2D pos = k.getAdded(dir.getMultiplied(i * checkDir));
            Player atPos = map.get(pos);
            if (atPos == v) {
                correctPositions.add(pos);
                visited.add(pos);
            } else {
                break;
            }
        }
    }


}

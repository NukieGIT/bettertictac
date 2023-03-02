package nuk.logic;

public class SettingsManager {

    private static SettingsManager INSTANCE;

    private GameSettings settings;

    private SettingsManager() {
    }

    public void setSettings(GameSettings settings) {
        this.settings = settings;
    }

    public GameSettings getSettings() {
        return settings;
    }

    public static SettingsManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new SettingsManager();
        }
        return INSTANCE;
    }
}

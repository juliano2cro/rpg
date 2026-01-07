package rpg;

public class GameSettings {

    private static GameSettings instance;
    private int maxStatPoints = 100;

    private GameSettings() {}

    public static GameSettings getInstance() {
        if (instance == null) {
            instance = new GameSettings();
        }
        return instance;
    }

    public boolean isValid(Character character) {
        return character.getPowerLevel() <= maxStatPoints;
    }
}

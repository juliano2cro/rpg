package rpg.settings;

import rpg.core.Character;

public class GameSettings {

    private static GameSettings instance;
    private int maxStatPoints = 300;

    private GameSettings() {}

    public static GameSettings getInstance() {
        if (instance == null) {
            instance = new GameSettings();
        }
        return instance;
    }

    //bonus
    public boolean isValid(Character character) {
        return character.getPowerLevel() <= maxStatPoints;
    }
}
package rpg;

public class Telepathy extends CharacterDecorator {

    public Telepathy(Character character) {
        super(character);
    }

    @Override
    public String getDescription() {
        return character.getDescription() + " + Télépathie";
    }

    @Override
    public int getPowerLevel() {
        return character.getPowerLevel() + 15;
    }
}

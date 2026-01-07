package rpg;

public class FireResistance extends CharacterDecorator {

    public FireResistance(Character character) {
        super(character);
    }

    @Override
    public String getDescription() {
        return character.getDescription() + " + Résistance au feu";
    }

    @Override
    public int getPowerLevel() {
        return character.getPowerLevel() + 5;
    }
}
package rpg;

public abstract class CharacterDecorator extends Character {

    protected Character character;

    public CharacterDecorator(Character character) {
        super(character.name, character.strength, character.agility, character.intelligence);
        this.character = character;
    }

    @Override
    public abstract String getDescription();

    @Override
    public abstract int getPowerLevel();
}

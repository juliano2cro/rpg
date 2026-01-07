package rpg;

public class Character {
    protected String name;
    protected int strength;
    protected int agility;
    protected int intelligence;

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public int getPowerLevel() {
        return strength * 2 + agility * 2 + intelligence * 3;
    }

    public String getDescription() {
        return "Personnage " + name +
                " [FOR=" + strength +
                ", AGI=" + agility +
                ", INT=" + intelligence + "]";
    }
}
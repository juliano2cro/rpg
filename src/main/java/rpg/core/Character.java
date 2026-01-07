package rpg.core;

public class Character {

    public String name;
    public int strength;
    public int agility;
    public int intelligence;

    public Character(String name, int strength, int agility, int intelligence) {
        this.name = name;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
    }

    public int getPowerLevel() {
        return strength + agility + intelligence;
    }

    public String getDescription() {
        return "Nom : " + name +
                ", Force : " + strength +
                ", Agilité : " + agility +
                ", Intelligence : " + intelligence;
    }
}
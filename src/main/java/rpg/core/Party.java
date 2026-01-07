package rpg.core;

import rpg.decorator.FireResistance;
import rpg.decorator.Invisibility;
import rpg.decorator.Telepathy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Party {

    private List<Character> characters = new ArrayList<>();
    private Random random = new Random();

    public void addCharacter(Character character) {
        characters.add(character);
    }


    // Calcule la puissance totale de l'équipe
    public int getTotalPower() {
        int total = 0;
        for (Character chars : characters) {
            total += chars.getPowerLevel();
        }
        return total;
    }

    //chaque joueur lance un dé et le résultat est additionné

    public int playTurn() {
        int totalTeamScore = 0;

        System.out.println("----- Équipe -----");
        for (int i = 0; i < characters.size(); i++) {
            Character character = characters.get(i);

            // Lance du dé et application de la capacité
            int de = random.nextInt(6) + 1;
            character = applyEffect(character, de);

            // Score du joueur = puissance + valeur du dé
            int playerScore = character.getPowerLevel() + de;
            totalTeamScore += playerScore;

            // Affichage du joueur
            System.out.println("Joueur : " + character.name +
                    " | Chiffre du dé : " + de +
                    " | Score : " + playerScore);
        }

        System.out.println("Score total de l'équipe : " + totalTeamScore);
        return totalTeamScore;
    }

    //Applique l'effet du dé à un personnage
    
    private Character applyEffect(Character character, int de) {
        switch (de) {
            case 2:
            case 5:
                return new Invisibility(character);
            case 3:
                return new FireResistance(character);
            case 4:
            case 6:
                return new Telepathy(character);
            default:
                // 1 → aucun effet
                return character;
        }
    }
}

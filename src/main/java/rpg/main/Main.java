package rpg.main;

import rpg.builder.CharacterBuilder;
import rpg.core.Character;
import rpg.core.Party;
import rpg.dao.CharacterDAO;
import rpg.decorator.Invisibility;
import rpg.decorator.Telepathy;
import rpg.settings.GameSettings;


public class Main {

    public static void main(String[] args) {

        // Création des personages

        //personnage avec des capacités spéciales
        Character perso1 = new CharacterBuilder()
                .setName("Juliano")
                .setStrength(75)
                .setAgility(75)
                .setIntelligence(75)
                .build();
        perso1 = new Invisibility(perso1); //pour l'exo 7 cap spécial
        perso1 = new Telepathy(perso1);

        Character perso2 = new CharacterBuilder()
                .setName("Julien")
                .setStrength(99)
                .setAgility(7)
                .setIntelligence(3)
                .build();

        Character perso3 = new CharacterBuilder()
                .setName("Adam")
                .setStrength(2)
                .setAgility(2)
                .setIntelligence(2)
                .build();
        perso3 = new Invisibility(perso3); //pour l'exo 7 cap spécial
        perso3 = new Telepathy(perso3);

        Character perso4 = new CharacterBuilder()
                .setName("Fabien")
                .setStrength(50)
                .setAgility(1)
                .setIntelligence(1)
                .build();

        Character perso5 = new CharacterBuilder()
                .setName("Bastien")
                .setStrength(0)
                .setAgility(0)
                .setIntelligence(56)
                .build();

        Character perso6 = new CharacterBuilder()
                .setName("Jean")
                .setStrength(0)
                .setAgility(200)
                .setIntelligence(0)
                .build();

        // Création de l'instance DAO
        CharacterDAO dao = new CharacterDAO();

        // Stockage des personnages
        dao.save(perso1);
        dao.save(perso2);
        dao.save(perso3);
        dao.save(perso4);
        dao.save(perso5);
        dao.save(perso6);

        // Affichage et validation
        System.out.println("---- Personnages stockés ----");
        for (Character character : dao.findAll()) {
            System.out.println(character.getDescription());
            System.out.println("Puissance : " + character.getPowerLevel());
            System.out.println("Valide selon GameSettings : " +
                    GameSettings.getInstance().isValid(character));
            System.out.println("--------------------------------");
        }


        // Création des équipes
        Party teamA = new Party();
        teamA.addCharacter(perso1);
        teamA.addCharacter(perso2);

        Party teamB = new Party();
        teamB.addCharacter(perso3);
        teamB.addCharacter(perso4);
        teamB.addCharacter(perso5);
        teamB.addCharacter(perso6);

        System.out.println("---- Début du duel ----");

        // Chaque équipe joue son tour
        System.out.println("\n--- Équipe A ---");
        int scoreA = teamA.playTurn();

        System.out.println("\n--- Équipe B ---");
        int scoreB = teamB.playTurn();

        // Affichage de l'équipe gagnante
        System.out.println("\n---- Résultat final ----");
        if (scoreA > scoreB) {
            System.out.println("Équipe A gagne !");
        } else if (scoreB > scoreA) {
            System.out.println("Équipe B gagne !");
        } else {
            System.out.println("Match nul !");
        }

        // Bonus trie personnage
        System.out.println("\n---- Tri par puissance ----");
        for (Character c : dao.sort()) {
            System.out.println(c.getDescription());
        }
    }
}

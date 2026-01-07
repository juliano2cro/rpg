package rpg.dao;

import rpg.core.Character;

import java.util.ArrayList;
import java.util.List;

public class CharacterDAO implements DAO<Character> {

    private List<rpg.core.Character> characters = new ArrayList<>();

    @Override
    public void save(rpg.core.Character item) {
        characters.add(item);
    }

    @Override
    public rpg.core.Character findByName(String name) {
        for (rpg.core.Character c : characters) {
            if (c.name.equals(name)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public List<Character> findAll() {
        return characters;
    }



    //Question Bonus pour le trie
    public List<Character> sort() {
        // On crée une copie de la liste pour ne pas modifier l'originale
        List<Character> sorted = new ArrayList<>(characters);

        // Double boucle pour comparer chaque élément
        for (int i = 0; i < sorted.size() - 1; i++) {
            for (int j = 0; j < sorted.size() - i - 1; j++) {
                // Comparer les noms
                if (sorted.get(j).name.compareTo(sorted.get(j + 1).name) > 0) {
                    // Échanger les personnages
                    Character saveCharacterTemporaire = sorted.get(j);
                    sorted.set(j, sorted.get(j + 1));
                    sorted.set(j + 1, saveCharacterTemporaire);
                }
            }
        }

        return sorted;
    }

}

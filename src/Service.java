import familyTrees.FamilyTree;
import familyTrees.comparators.ByDateBirth;
import familyTrees.comparators.NameAlphabetical;
import familyTrees.comparators.NameLength;
import human.Human;

import java.util.List;

public class Service {
    List<Human> familyTree;

    public Service(FamilyTree familyTree) {

        this.familyTree = familyTree.getFamilyTree();
    }

    /**
     * Сортирует древо по дате рождения
     */
    public void sortTreeByDateBirth() {
        familyTree.sort(new ByDateBirth());
    }

    /**
     * Сортирует древо в алфавитном порядке
     */
    public void sortTreeByAlphabeticalOrder() {
        familyTree.sort(new NameAlphabetical());
    }
    /**
     * Сортирует древо по длине имени
     */
    public void sortTreeByNameLength() {
        familyTree.sort(new NameLength());
    }


}

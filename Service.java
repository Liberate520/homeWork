import java.time.LocalDate;

import members.Gender;
import members.Human;
import repository.CapableOfPreserving;
import repository.CapableOfRestore;
import repository.FileHandler;
import tree.FamilyTree;

public class Service {
    private FamilyTree<Human> familyTree;

    private String path;

    public Service(String path) {
        this.path = path;
        getFamilyTree();
    }

    @Override
    protected void finalize() throws Throwable {
        save();
    }

    public FamilyTree<Human> getFamilyTree() {
        if (this.familyTree == null) {
            this.familyTree = read();
        }
        if (this.familyTree == null) {
            this.familyTree = createHumanFamily();
        }
        return familyTree;
    }

    /** заполнения дерева */
    public FamilyTree<Human> createHumanFamily() {
        FamilyTree<Human> family = new FamilyTree<>();
        Human ancestor1 = new Human("John Johnson", LocalDate.of(1910, 1, 2), Gender.Male);
        Human ancestor2 = new Human("Eliza Johnson", LocalDate.of(1909, 2, 4), Gender.Female);
        Human ancestor3 = new Human("Donald Ferguson", LocalDate.of(1908, 3, 6), Gender.Male);
        Human secondGen1 = new Human("Mike Johnson", LocalDate.of(1930, 4, 10), Gender.Male, ancestor1, ancestor2);
        Human secondGen2 = new Human("Betty Ferguson", LocalDate.of(1925, 5, 12), Gender.Female, ancestor3, null);
        Human thirdGen1 = new Human("Bobby Johnson", LocalDate.of(1950, 6, 14), Gender.Male, secondGen1, secondGen2);
        Human thirdGen2 = new Human("Christine Johnson", LocalDate.of(1955, 7, 16), Gender.Female, secondGen1, null);
        Human thirdGen3 = new Human("Steve Gomez", LocalDate.of(1951, 8, 18), Gender.Male, null, secondGen2);
        family.addNewMember(ancestor1);
        family.addNewMember(ancestor2);
        family.addNewMember(ancestor3);
        family.addNewMember(secondGen1);
        family.addNewMember(secondGen2);
        family.addNewMember(thirdGen1);
        family.addNewMember(thirdGen2);
        family.addNewMember(thirdGen3);
        return family;
    }

    /** сохранение */
    private void save() {
        CapableOfPreserving preserver = new FileHandler();
        preserver.save(path, familyTree);
    }

    /** чтение */
    private FamilyTree<Human> read() {
        CapableOfRestore restorer = new FileHandler();
        return (FamilyTree<Human>) restorer.read(path);
    }

    public void sortFamilyByName() {
        familyTree.sortByName();
    }

    public void sortFamilyByBirthday() {
        familyTree.sortByBirthday();
    }

    public void sortFamilyByChildrenAmount() {
        familyTree.sortByChildrenAmount();
    }

    public String getInfo() {
        StringBuilder builder = new StringBuilder();
        for (Human human : familyTree) {
            builder.append(human.toString() + "\n");
        }
        return builder.toString();
    }
}

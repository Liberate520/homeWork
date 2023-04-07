import familyTree.FamilyTree;
import familyTree.comparators.HumanComparatorByBirthday;
import familyTree.comparators.HumanComparatorById;
import familyTree.comparators.HumanComparatorByName;
import familyTree.comparators.HumanCompareByNumberChild;
import human.Gender;
import human.Human;

import java.io.InvalidObjectException;

public class Service {

    private int id;

    private FamilyTree tree;
    private FileHandler handler;

    public Service(FamilyTree tree) {
        this.tree = tree;
    }
    public void addHuman(String name, String surname, Gender gender, String dateBirth, Human father, Human mother) {
        tree.add(new Human(id++, name, surname, gender, dateBirth, father, mother));
    }
    public void addHuman(String name, String surname, Gender gender, String dateBirth) {
        tree.add(new Human(id++, name, surname, gender, dateBirth));
    }

    public void save(FamilyTree tree) {save(this.tree);}

   // public void load() throws InvalidObjectException, ClassNotFoundException {tree.load();}




    public void sortByName () {
        tree.getHumanList().sort(new HumanComparatorByName());
    }

    public void sortById () {
        tree.getHumanList().sort(new HumanComparatorById());
    }

    public void sortByBirthday () {
        tree.getHumanList().sort(new HumanComparatorByBirthday());
    }

    public void sortByNumChild () {
        tree.getHumanList().sort(new HumanCompareByNumberChild());
    }

}

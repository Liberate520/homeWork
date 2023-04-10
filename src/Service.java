import famyilyTree.FamilyTree;
import human.Gender;
import human.Human;
import human.HumanComparatorByID;
import human.HumanComparatorByLastName;

import java.time.LocalDate;

public class Service {
    private int id;
    private FamilyTree tree;

    public Service(FamilyTree familyGroup) { this.tree = familyGroup; }

    public FamilyTree getFamilyGroup() {
        return tree;
    }

    public void addHuman(String firstName, String lastName, Gender gender,
                         LocalDate dateBirth, Human father, Human mother) {
        id++;
        tree.add(new Human(id, firstName, lastName, gender, dateBirth, father, mother));
    }

    public void addHuman(String firstName, String lastName, Gender gender,
                         LocalDate dateBirth) {
        id++;
        tree.add(new Human(id, firstName, lastName, gender, dateBirth));
    }

    public void sortByLastName() {
        tree.getFamilyTree().sort(new HumanComparatorByLastName());
    }
    public void sortByID() {

        tree.getFamilyTree().sort(new HumanComparatorByID());
    }

//    public void addHuman(String андрей, String пивоваров, Gender male, LocalDate of) {
//    }
}

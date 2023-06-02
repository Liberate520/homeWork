package homeWork.tree2;

import homeWork.tree2.familyTree.FamilyTree;
import homeWork.tree2.familyTree.comparator.HumanComparatorByAge;
import homeWork.tree2.familyTree.comparator.HumanComparatorByName;
import homeWork.tree2.human.Human;

import java.time.LocalDate;
import java.util.Comparator;

public class Service {

    private FamilyTree family;

    public Service(FamilyTree family) {
        this.family = family;
    }

    public void addFamilyMember(String name, LocalDate date) {
        Human member = new Human(name,  date);
        family.addPeople(member);
    }

    public void sortByName(){
        family.FamilyMembersList().sort(new HumanComparatorByName());
    }

    public void sortByAge(){
        family.FamilyMembersList().sort(new HumanComparatorByAge());
    }
}

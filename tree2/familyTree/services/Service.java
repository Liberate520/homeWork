package homeWork.tree2.familyTree.services;

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
        family.familyMembersList().sort(new HumanComparatorByName());
    }

    public void sortByAge(){
        family.familyMembersList().sort(new HumanComparatorByAge());
    }
}

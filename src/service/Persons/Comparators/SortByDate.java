package service.Persons.Comparators;

import service.Persons.Human;
import service.Persons.Person;
import service.tree.FamilyTree;

public class SortByDate {
    private FamilyTree<Human> familyTree;
//    void SortByDate(FamilyTree familyTree)
//    {
//        this.familyTree = familyTree;
//    }

    public void sortByDate(FamilyTree familyTree)
    {
        familyTree.sort(new DateComparator());
    }
}

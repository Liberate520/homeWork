package service.Persons.Comparators;
import service.tree.FamilyTree;
import service.Persons.Person;
public class SortByName {
    private FamilyTree familyTree;
//    void sortByName(FamilyTree familyTree)
//    {
//        this.familyTree = familyTree;
//    }

    public void sortByName1(FamilyTree familyTree)
    {
        familyTree.sort(new NameComparator());
    }
}

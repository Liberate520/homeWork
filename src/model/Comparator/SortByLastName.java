package model.Comparator;

import model.FamilyTree.FamilyTree;
import model.Persons.Person;

public class SortByLastName<T extends Person>
{
    public <T> void  sortByLastName(FamilyTree familyTree)
    {
       ((FamilyTree) familyTree).sortByLastName(familyTree); 
       System.out.println("Список, отсортированный по фамилии: " + familyTree);
    } 
}

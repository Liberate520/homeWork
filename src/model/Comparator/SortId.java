package model.Comparator;

import model.Persons.Person;
import model.FamilyTree.FamilyTree;

public class SortId<T extends FamilyTree> 
{
    public<T> void SortId(FamilyTree familyTree)
     {
        ((FamilyTree) familyTree).sortById(familyTree);  
        System.out.println("Список, отсортированный по Id: " + familyTree);
     }    
}

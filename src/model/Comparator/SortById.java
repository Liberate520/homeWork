package model.Comparator;

import model.FamilyTree.FamilyTree;

public class SortById 
{
    private FamilyTree familyTree;

   public void SortById(FamilyTree familyTree)
    {
        this.familyTree = familyTree;
    }

    public void sortBy()
    {
        familyTree.sort(new IdComparator());
        System.out.println("Список, отсортированный по id: " + familyTree);
    }
}

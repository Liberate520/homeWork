package model.Comparator;

import model.FamilyTree.FamilyTree;

public class SortById 
{
    private FamilyTree familyTree;

   public void SortById(FamilyTree familyTree)
    {
        this.familyTree = familyTree;
    }

    public void sortBy(FamilyTree familyTree)
    {
        familyTree.sort(new IdComparator());
    }
}

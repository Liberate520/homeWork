package Homework_003;

import java.util.Collections;


public class FamilyTreeService {
    
    private FamilyTree familyTree;
       
    public FamilyTreeService(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }


    public void sortByName(){
        Collections.sort(familyTree.getAll());
    }

    public void sortById(){
        Collections.sort(familyTree.getAll(), new HumanComparatorById());
    }
    
}

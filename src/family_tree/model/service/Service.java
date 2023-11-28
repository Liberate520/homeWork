package family_tree.model.service;

import family_tree.model.base.FileHandler;
import family_tree.model.base.SortFileByAge;
import family_tree.model.base.SortFileByIncome;
import family_tree.model.base.SortFileByLastName;
import family_tree.model.tree.FamilyTree;
import static family_tree.model.tree.FamilyTree.handlerForTree;

public class Service {
//    private FamilyTree<Human> familyTree;

    public Service(){
        FamilyTree familyTree = new FamilyTree();

    }

    FamilyTree familyTree = new FamilyTree();



    public void sortByLastName(){
        SortFileByLastName.sortByLastNameForTree();
    }

    public void sortByAge(){
        SortFileByAge.sortByAgeForTree();
    }

    public void sortByIncome() {
        SortFileByIncome.sortByIncomeForTree();
    }

    public void sortByName() {
        handlerForTree();
    }
}

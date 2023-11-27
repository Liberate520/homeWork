package family_tree.model.service;

import family_tree.model.base.FileHandler;
import family_tree.model.base.SortFileByAge;
import family_tree.model.base.SortFileByIncome;
import family_tree.model.base.SortFileByLastName;
import family_tree.model.tree.FamilyTree;
import family_tree.model.human.Human;

public class Service {
//    private FamilyTree<Human> familyTree;

    public Service(){
        FamilyTree familyTree = new FamilyTree() {
            @Override
            public void getAge() {
                this.age = age;
            }
        };
    }

//    FamilyTree familyTree = new FamilyTree();


    public void sortByLastName(){
        SortFileByLastName.sortByLastNameForTree();
    }

    public void sortByAge(){
        SortFileByAge.sortByAgeForTree();
    }

    public void sortByIncome() {
        SortFileByIncome.sortByIncomeForTree();
    }
}

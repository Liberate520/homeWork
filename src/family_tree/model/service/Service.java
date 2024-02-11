package family_tree.model.service;

import family_tree.model.base.SortFileByLastName;
import family_tree.model.human.*;
import family_tree.model.tree.FamilyTree;

import java.time.LocalDate;

import static family_tree.model.tree.FamilyTree.*;

public class Service {

//    private FamilyTree<Human> familyTree;

    public Service(){
        FamilyTree familyTree = new FamilyTree();
    }

    public void sortByLastName(){
        SortFileByLastName.sortByLastNameForTree();
    }

    public void sortByAge(){ handlerForAge(); }

    public void sortByIncome() {
        handlerForIncome();
    }

    public void sortByName() {
        handlerForTree();
    }

    public void addNewHuman(String lastName, String firstName, Gender gender, Position position, SocialPosition socialPosition, Fondation fondation, double income, LocalDate birthDate, int id) {
        Human newHuman = new Human(lastName, firstName, gender, position, socialPosition, fondation, income, birthDate, id);
//        FamilyTree.addNewHumans(newHuman);
    }
}

package homeWork.ProjectFamilyTree.Presenter;

import homeWork.ProjectFamilyTree.Model.Family_tree;
import homeWork.ProjectFamilyTree.Model.Gender;
import homeWork.ProjectFamilyTree.Model.Human;
import homeWork.ProjectFamilyTree.View.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Family_tree familyTree;

    public Presenter(View view) {
        this.view = view;
        familyTree = new Family_tree();
    }
    public void addHuman(String name, LocalDate localDateOfBirth, LocalDate localDateofDeath, Gender gender){
        familyTree.addHuman(name, localDateOfBirth, localDateofDeath, gender);
    }
    public void getFamilyTreeInfo(){
        String answer = familyTree.getFamilyTree();
        view.printAnswer(answer);
    }
    public void sortByName(){
        familyTree.sortByName();
        getFamilyTreeInfo();
    }
    public void sortByAge(){
        familyTree.sortByAge();
        getFamilyTreeInfo();
    }
}

package family_tree.presenter;

import family_tree.model.base.FileHandlerForTree;
import family_tree.model.human.*;
import family_tree.model.service.Service;
import family_tree.model.tree.FamilyTree;
import family_tree.model.tree.TreeNode;
import family_tree.view.View;

import java.time.LocalDate;

import static family_tree.model.base.SortFileByIncome.humans;

public class Presenter {
    private View view;
    private final Service service;


    public Presenter(View view) {
        service = new Service();
    }

    public void getFamilyListInfo() {
        /*String info = */
        FamilyTree.handlerForTree();
//        view.printAnswer(info);
    }

    public void sortByName() { service.sortByName(); }
    public void sortByLastName() { service.sortByLastName(); }
    public void sortByAge() { service.sortByAge(); }
    public void sortByIncome() {
        service.sortByIncome();
    }

    public void add(String lastName, String firstName, Gender gender, Position position, SocialPosition socialPosition, Fondation fondation, double income, LocalDate birthDate, LocalDate deathDate, double id) {
        service.addNewHuman(lastName, firstName, gender, position, socialPosition, fondation, income, birthDate, deathDate, id);
    }


}

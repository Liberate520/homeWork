package family_tree.presenter;

import family_tree.model.family.FamilyTree;
import family_tree.model.human.Human;
import family_tree.model.service.Service;
import family_tree.view.View;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Presenter {
    private View view;
    private Service service;


    public Presenter(View view) {
        this.view = view;
        service = new Service<>();
    }


    public void addFamilyMember(String gender, String name, String familyName, String strDate) {
        service.addFamilyMember(gender, name, familyName, strDate);
        getFamilyTreeMembers();
    }

    public void getFamilyTreeMembers() {
        String answer = service.getFamilyTreeMembers();
        view.printAnswer(answer);
    }

    public void sortByName() {
        service.sortByName();
    }

    public void sortByAge() {
        service.sortByAge();
    }

    public void saveTreeToFile() {
        service.saveTreeToFile();
    }

    public void getTreeFromFile() {
        service.getTreeFromFile();
    }
}

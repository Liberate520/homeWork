package FamilyTree.Tree.presenter;

import FamilyTree.Tree.model.HumanGroup.Human.Human;
import FamilyTree.Tree.model.HumanGroup.HumanGroup;
import FamilyTree.Tree.model.HumanGroup.Service;
import FamilyTree.Tree.view.View;

import java.util.ArrayList;

public class Presenter {
    private View view;
    private Service service;


    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }


    public void addHumans(String name, String patronymic, int dateOfBirth) {
        service.addHumans(name, patronymic, dateOfBirth);

    }


    public void getHumansInfo() {
        String answer = service.getHumansInfo();
        view.printAnswer(answer);
    }

    public void sortName() {
        service.sortByName();
        getHumansInfo();
    }

    public void sortDateOfBirth() {
        service.sortDateOfBirth();
        getHumansInfo();
    }

    public void sortPatronymic() {
        service.sortPatronymic();
        getHumansInfo();
    }
}

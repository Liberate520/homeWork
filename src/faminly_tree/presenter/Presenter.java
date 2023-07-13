package faminly_tree.presenter;

import faminly_tree.model.human.Gender;
import faminly_tree.model.human.Human;
import faminly_tree.model.service.Service;
import faminly_tree.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;
    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHuman(String name, Gender gender, LocalDate date) {
        service.addHuman(name, gender, date);
        //TODO ответ пользователю получилось или нет (через boolean, например)
    }

    public void sortByAge() {
        service.sortByAge();
    }

    public void sortByName() {
        service.sortByName();
    }

    public void showAllTree() {
        service.showAllTree();
    }
    public boolean connection(int parentID, int childID) {
        return service.connection(parentID, childID);
    }
}

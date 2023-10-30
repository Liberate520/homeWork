package ru.gb.family_tree.presenter;


import ru.gb.family_tree.human.Gender;
import ru.gb.family_tree.human.Human;
import ru.gb.family_tree.service.Service;
import ru.gb.family_tree.ui.ConsoleUI;
import ru.gb.family_tree.ui.View;

public class Presenter {

    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void allTree() {
        String tree = service.getInfoShort();
        view.printAnswer(tree);
    }

    public void addBody(String lastname, String name, Gender gender) {
        Human somebody = service.addNewToFamily(lastname, name, gender);
        view.printAnswer(service.infoByID(somebody.getId()));
    }

    public void getBodyInfoById(int id) {
        view.printAnswer(service.infoByID(id));
    }

    public void sortById() {
        service.sortById();
        view.printAnswer(service.getInfoShort());
    }

    public void sortByLastname() {
        service.sortByLastname();
        view.printAnswer(service.getInfoShort());
    }

}

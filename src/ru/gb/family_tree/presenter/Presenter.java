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

    public void setBirthday(int id, int year, int month, int day) {
        service.setBirthday(id, year, month, day);
        view.printAnswer(service.infoByID(id));
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

    public void setDeathdate(int id, int year, int month, int day) {
        service.setDeathdate(id, year, month, day);
        view.printAnswer(service.infoByID(id));
    }

    public void addSpouse(int one, int two) {
        service.addSpouse(one, two);
        view.printAnswer(service.infoByID(one));
    }

    public void addChild(int parentId, int childId) {
        service.addChild(parentId, childId);
        view.printAnswer(service.infoByID(parentId));
    }

    public void sortByAge() {
        service.sortByAge();
        view.printAnswer(service.getInfoShort());
    }

    public void load() {
        service.load();
    }

    public void save() {
        service.save();
    }
}

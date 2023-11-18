package ru.gb.family_tree.presenter;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.service.Service;
import ru.gb.family_tree.view.View;

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
        view.printAnswer(service.addNewToFamily(lastname, name, gender).toString());
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

    public boolean checkId(int id) {
        return service.checkId(id);
    }
}

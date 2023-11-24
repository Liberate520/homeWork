package ru.gb.family_tree.presenter;

import ru.gb.family_tree.model.exception.HumanExcistsException;
import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.service.Service;
import ru.gb.family_tree.view.View;

import java.io.IOException;

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

    public void addBody(String lastname, String name, Gender gender) throws HumanExcistsException {
        view.printAnswer(service.addNewToFamily(lastname, name, gender).toString());
    }

    public boolean setBirthday(int id, int year, int month, int day) {
        if (service.setBirthday(id, year, month, day)) {
            view.printAnswer(service.infoByID(id));
            return true;
        }
        return false;
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

    public boolean setDeathdate(int id, int year, int month, int day) {
        if (service.setDeathdate(id, year, month, day)) {
            view.printAnswer(service.infoByID(id));
            return true;
        }
        return false;
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

    public void load() throws IOException {
        service.load();
    }

    public boolean save() {
        return service.save();
    }

    public boolean checkId(int id) {
        return service.checkId(id);
    }
}

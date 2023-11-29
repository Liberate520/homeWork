package ru.medved_sa.tree_family.presenter;

import ru.medved_sa.tree_family.model.Service;
import ru.medved_sa.tree_family.model.save.FileHandler;
import ru.medved_sa.tree_family.view.View;

import java.util.ArrayList;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service(new FileHandler<>());
    }

    public void addHuman(String name, String gender, String birthDate) {
        String answer = service.addHuman(name, gender, birthDate);
        view.printAnswer(answer);
    }

    public boolean setParent(int personId, int parentId){
        if (service.checkId(personId) & service.checkId(parentId)) {
            service.setParent(personId, parentId);
            return true;
        }
        return false;
    }

    public void getHumanList() {
        String answer = service.getHumanList();
        view.printAnswer(answer);
    }

    public void sortByName() {
        service.sortByFirstName();
        getHumanList();

    }

    public void sortByAge() {
        service.sortByAge();
        getHumanList();
    }
    public void sortById() {
        service.sortById();
        getHumanList();
    }

    public boolean readFile(String filePath) {
        return service.readFile(filePath);
    }

    public boolean saveFile(String filePath) {
        return service.saveFile(filePath);
    }

}

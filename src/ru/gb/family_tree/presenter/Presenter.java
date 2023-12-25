package ru.gb.family_tree.presenter;

import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.service.Service;
import ru.gb.family_tree.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        service = new Service();
        this.view = view;
    }

    public void addHuman(String name, Gender gender, LocalDate birthDate) {
        String answer = service.addHuman(name, gender, birthDate);
        view.print(answer);
    }

    public void getFamilyTreeInfo() {
        view.print(service.getHumanList());
    }


    public void getByName(String name){
        System.out.println(service.getByName(name));
    }

    public boolean setWedding(long humanId1, long humanId2){
        return service.setWedding(humanId1, humanId2);
    }

    public boolean setDivorce(long humanId1, long humanId2){
        return service.setDivorce(humanId1, humanId2);
    }

    public boolean setParent(long parentId, long childId){
        return service.setParent(parentId, childId);
    }

    public boolean setChild(long childId, long parentId){
        return service.setChild(childId, parentId);
    }

    public void remove(long id){
        service.remove(id);
    }

    public void sortByName() {
        service.sortByName();
        getFamilyTreeInfo();
    }

    public void sortByAge() {
        service.sortByAge();
        getFamilyTreeInfo();
    }
}
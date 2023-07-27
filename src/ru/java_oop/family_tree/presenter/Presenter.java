package ru.java_oop.family_tree.presenter;

import ru.java_oop.family_tree.model.human.Gender;
import ru.java_oop.family_tree.model.service.Service;
import ru.java_oop.family_tree.view.View;

import java.time.LocalDate;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        service = new Service();
    }

    public void addHumanFamilyMember(String name, Gender gender, LocalDate birthDate) {
        service.addHumanFamilyMember(name, gender, birthDate);
        getFamilyTreeInfo();
    }

    public void getFamilyTreeInfo() {
        String info = service.getFamilyTreeInfo();
        view.printAnswer(info);
    }

    public void sortByName() {
        service.sortByName();
        getFamilyTreeInfo();
    }

    public void sortByAge() {
        service.sortByAge();
        getFamilyTreeInfo();
    }

    public void setParentRelation(long parent_id, long child_id) {
        service.setParentChildRelation(parent_id, child_id);
        getFamilyTreeInfo();
    }
}

package family_tree.presenter;

import java.time.LocalDate;

import family_tree.model.human.Gender;
import family_tree.model.human.Kinship;
import family_tree.model.service.Service;
import family_tree.view.View;

public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view) {
        this.view = view;
        this.service = new Service("family.out");
    }

    public void addHuman(String name, String surName, String patronymic, String gender, String dateOfBirth,
            String dateOfDeath) {
        service.addHuman(name, surName, patronymic, Gender.valueOf(gender), convertLocalDate(dateOfBirth), 
                        convertLocalDate(dateOfDeath));
        view.printAnswer("Человек добавлен.");
        getFamilyTreeInfo();
    }

    private LocalDate convertLocalDate(String locaDate) {
        if (locaDate != null) {
            return LocalDate.parse(locaDate);
        }
        return null;
    }

    public void getFamilyTreeInfo() {
        view.printAnswer(service.getFamilyTreeInfo());
    }

    public void sortByAge() {
        service.sortByAge();
        getFamilyTreeInfo();
    }

    public void sortByName() {
        service.sortByName();
        getFamilyTreeInfo();
    }

    public void sortBySurname() {
        service.sortBySurname();
        getFamilyTreeInfo();
    }

    public void sortByPatronymic() {
        service.sortByPatronymic();
        getFamilyTreeInfo();
    }

    public void addKinship(int idHuman, int idKinshipHuman, String kinship) {
        service.addKinship(idHuman, idKinshipHuman, Kinship.valueOf(kinship));
        getFamilyTreeInfo();
    }

    public void getSibling(int id) {
        view.printAnswer(service.getSibling(id));
    }

    public void getParents(int id) {
        view.printAnswer(service.getParents(id));
    }

    public void getChildren(int id) {
        view.printAnswer(service.getChildren(id));
    }

    public void fileSave() {
        if (service.fileSave()) {
            view.printAnswer("Семейное дерево сохранено.");
        } else {
            view.printAnswer("Ошибка записи.");
        }  
    }

    public void fileRead() {
        if (service.fileRead()) {
            view.printAnswer("Семейное дерево загружено.");
            getFamilyTreeInfo();
        } else {
            view.printAnswer("Ошибка чтения.");
        }  
    }

    public void remove(int id) {
        service.removeHuman(id);
        getFamilyTreeInfo();
    }

}

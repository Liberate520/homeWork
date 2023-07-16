package ru.gb.family_tree.presenter;

import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.saveload.FileHandler;
import ru.gb.family_tree.model.tree.FamilyTree;
import ru.gb.family_tree.view.View;

public class Presenter {
    private View view;
    private FamilyTree<Human> service;

    public Presenter(View view) {
        this.view = view;
        service = new FamilyTree<Human>();
    }

    public void addMember(String fio, String gender, String birthDate) {
        // Парсинг и валидация данных
        // Добавление пользователя
        // Ответ пользователю
    }

    public void getMembers() {
        view.print(service.toString());
        view.start();
    }

    public void sortByName() {
        service.sortByName();
        getMembers();
    }

    public void sortByBirthDate() {
        service.sortByBirthDate();
        getMembers();
    }

    public void back() {
        if (view.previousMenu() == null) view.start();
        else view.print(view.previousMenu().getMenu());
    }

    public void importFromObjectFile() {
        try {
            FileHandler fh = new FileHandler("obj.out");
            service = (FamilyTree<Human>) fh.read();
        } catch (Exception e) {
            view.print("Ошибка при импорте объекта из файла");
            view.print(e.getMessage());
        }
    }

    public int getTreeSize() { return service.countMembers(); }

    public boolean autoimport() {
        try {
            FileHandler fh = new FileHandler("obj.out");
            service = (FamilyTree<Human>) fh.read();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

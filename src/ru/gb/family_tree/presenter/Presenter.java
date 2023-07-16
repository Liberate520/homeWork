package ru.gb.family_tree.presenter;

import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.saveload.FileHandler;
import ru.gb.family_tree.model.tree.FamilyTree;
import ru.gb.family_tree.view.View;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Presenter {
    private View view;
    private FamilyTree<Human> service;

    public Presenter(View view) {
        this.view = view;
        service = new FamilyTree<Human>();
    }

    public void addMember(HashMap<String, String> data) {
        try {
            Human human = new Human(data.get("surname"), data.get("name"), data.get("patronymic"), data.get("gender"),
                    LocalDate.parse(data.get("birthDate")));
            service.addMember(human);
            view.print("Человек успешно добавлен");
        } catch (Exception e) {
            view.print("Произошла ошибка при добавлении человека в семейное древо");
            view.print(e.getMessage());
        }
    }

    public void getMembers() {
        view.print(service.toString());
    }

    public void sortByName() {
        service.sortByName();
        getMembers();
    }

    public void sortByBirthDate() {
        service.sortByBirthDate();
        getMembers();
    }

    public void importFromObjectFile(String fileName) {
        try {
            service = (FamilyTree<Human>) new FileHandler(fileName).read();
            view.print("Импорт выполнен успешно");
        } catch (IOException e) {
            view.print("Произошла ошибка при импорте из файла: проверьте правильность введенного имени и убедитесь, " +
                       "что файл существует");
        } catch (ClassNotFoundException e) {
            view.print("Произошла ошибка при попытке импортировать дерево: не найден класс для импорта");
        }
        catch (ClassCastException e ) {
            view.print("Произошла ошибка при попытке импортировать дерево: неверные данные");
        }
    }

    public int getTreeSize() { return service.countMembers(); }
}

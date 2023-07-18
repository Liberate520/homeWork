package ru.gb.family_tree.model.services;

import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.saveload.FileHandler;
import ru.gb.family_tree.model.tree.FamilyTree;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;

public class TreeService implements Service {
    private FamilyTree<Human> tree;

    public TreeService() {
        this.tree = new FamilyTree<>();
    }

    @Override
    public String getData(String data) {
        return data;
    }

    public String addMember(HashMap<String, String> data) {
        StringBuilder sb = new StringBuilder();
        try {
            tree.addMember(new Human(
                    data.get("surname"),
                    data.get("name"),
                    data.get("patronymic"),
                    data.get("gender"),
                    LocalDate.parse(data.get("birthDate"))));
            sb.append("Человек успешно добавлен");
            return getData(sb.toString());
        } catch (Exception e) {
            sb.append("Произошла ошибка при добавлении человека в семейное древо");
            sb.append(e.getMessage());
            return getData(sb.toString());
        }
    }

    public String getMembers() {
        return getData(tree.toString());
    }

    public void sortByName() {
        tree.sortByName();
    }

    public void sortByBirthDate() {
        tree.sortByBirthDate();
    }

    public String importTree(String fileName) {
        try {
            tree = (FamilyTree<Human>) new FileHandler(fileName).read();
            return getData("Импорт выполнен успешно");
        } catch (IOException e) {
            return getData("Произошла ошибка при импорте из файла: " +
                           "проверьте правильность введенного имени и убедитесь, " +
                           "что файл существует");
        } catch (ClassNotFoundException e) {
            return getData("Произошла ошибка при попытке импортировать дерево: не найден класс для импорта");
        }
        catch (ClassCastException e) {
            return getData("Произошла ошибка при попытке импортировать дерево: неверные данные");
        }
    }

    public String exportTree(String fileName) {
        try {
            new FileHandler(fileName).write(tree);
            return getData("Экспорт выполнен успешно");
        } catch (IOException e) {
            return getData("Произошла ошибка при экспорте в файл: " +
                    "проверьте правильность введенного имени и убедитесь, " +
                    "что файл существует");
        }
    }

    public int getTreeSize() {
        return tree.countMembers();
    }
}

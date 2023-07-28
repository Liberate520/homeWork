package ru.gb.family_tree.model.services;

import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.saveload.*;
import ru.gb.family_tree.model.tree.FamilyTree;

import java.io.IOException;
import java.io.InvalidClassException;
import java.time.LocalDate;
import java.util.HashMap;

public class HumanTreeService {
    private FamilyTree<Human> tree;

    public HumanTreeService() {
        this.tree = new FamilyTree<>();
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
            return sb.toString();
        } catch (Exception e) {
            sb.append("Произошла ошибка при добавлении человека в семейное древо");
            sb.append(e.getMessage());
            return sb.toString();
        }
    }

    public String getMembers() {
        return tree.toString();
    }

    public void sortByName() {
        tree.sortByName();
    }

    public void sortByBirthDate() {
        tree.sortByBirthDate();
    }

    public String importTreeFromObjectFile(Reading<FamilyTree<Human>> reader) {
        try {
            this.tree = tree.read(reader);
            return "Импорт выполнен успешно";
        } catch (InvalidClassException e) {
            return "Произошла ошибка при попытке импортировать дерево: класс для импорта был модифицирован";
        } catch (ClassNotFoundException e) {
            return "Произошла ошибка при попытке импортировать дерево: не найден класс для импорта";
        } catch (IOException e) {
            return "Произошла ошибка при импорте из файла: " +
                    "проверьте правильность введенного имени и убедитесь, " +
                    "что файл существует\n" + e.getMessage();
        } catch (ClassCastException e) {
            return "Произошла ошибка при попытке импортировать дерево: неверные данные";
        }
    }

    public String exportTreeToObjectFile(Writing handler) {
        try {
            handler.write(tree);
            return "Экспорт выполнен успешно";
        } catch (IOException e) {
            return "Произошла ошибка при экспорте в файл: " +
                    "проверьте правильность введенного имени и убедитесь, " +
                    "что файл существует";
        }
    }

    public int getTreeSize() {
        return tree.countMembers();
    }

}

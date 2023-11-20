package ru.gb.family_tree.model.service;

import ru.gb.family_tree.model.builder.HumanBuilder;
import ru.gb.family_tree.model.human.Gender;
import ru.gb.family_tree.model.human.Human;
import ru.gb.family_tree.model.tree.FamilyTree;
import ru.gb.family_tree.model.writer.FIleHandler;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;

public class Service {
    private FamilyTree<Human> tree;
    private HumanBuilder builder;
    private FIleHandler fh;

    public Service() {
        tree = new FamilyTree<>();
        builder = new HumanBuilder();
        fh = new FIleHandler();
    }

    public Human addNewToFamily(String lastname, String name, Gender gender) {
        Human human = builder.build(lastname, name, gender);
        tree.addMember(human);
        return human;
    }

    public String infoByID(int id) {
        return tree.infoById(id);
    }

    public void setBirthday(int id, int year, int month, int day) {
        Human human = tree.findInTree(id);
        if (human != null) {
            human.setBirthday(checkDate(year, month, day));
        }
    }

    private LocalDate checkDate(int year, int month, int day) {
        LocalDate date = null;
        if (dateIsValid(year, month, day)) {
            date = LocalDate.of(year, month, day);
        }
        if (date == null) {
            System.out.println("Данные не добавлены!");
        }
        return date;
    }

    private boolean dateIsValid(int year, int month, int day) {
        try {
            LocalDate date = LocalDate.of(year, month, day);
            return true;
        } catch (DateTimeException e) {
            System.out.println("Дата указана неверно!");
            return false;
        }
    }

    public String getInfoShort() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Human member : tree) {
            stringBuilder.append(member);
            if (member.getBirthday() == null) {
                stringBuilder.append(", возраст неизвестен\n");
            } else {
                stringBuilder.append(", возраст: ").append(member.age()).append("\n");
            }
        }
        return stringBuilder.toString();
    }

    public void sortByLastname() {
        tree.sortByLastname();
    }

    public void sortByName() {
        tree.sortByName();
    }

    public void sortByAge() {
        tree.sortByAge();
    }

    public void sortById() {
        tree.sortById();
    }

    @Override
    public String toString() {
        return getInfoShort();
    }

    public void setDeathdate(int id, int year, int month, int day) {
        Human human = tree.findInTree(id);
        if (human != null) {
            human.setDeathday(checkDate(year, month, day));
        }
    }

    public void addSpouse(int one, int two) {
        Human first = tree.findInTree(one);
        Human second = tree.findInTree(two);
        first.setSpouse(second);
    }

    public void addChild(int parentId, int childId) {
        Human parent = tree.findInTree(parentId);
        Human child = tree.findInTree(childId);
        parent.setChild(child);
    }

    public void load() {
        try {
            tree = (FamilyTree) fh.read("output.data");
        } catch (RuntimeException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void save() {
        FIleHandler fh = new FIleHandler();
        if (fh.write(tree, "output.data")) System.out.println("Данные успешно записаны");
    }

    public boolean checkId(int id) {
        Human human = tree.findInTree(id);
        if (human != null) {
            return true;
        }
        return false;
    }

}

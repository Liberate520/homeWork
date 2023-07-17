package family_tree.Presenter;

import java.time.LocalDate;

import family_tree.Model.familyTree.FamilyTree;
import family_tree.Model.fileHandlers.FileHandler;
import family_tree.Model.human.Gender;
import family_tree.Model.human.Human;
import family_tree.View.ConsoleUI;

public class Presenter {
    private ConsoleUI view;
    private FamilyTree<Human> familyTree;
    private FileHandler fileHandler;

    public Presenter(ConsoleUI view) {
        this.view = view;
        familyTree = new FamilyTree<Human>();
        fileHandler = new FileHandler();
    }

    public void addHuman(String name, LocalDate birthDate, Gender gender) {
        Human human = new Human(name, birthDate, gender);
        if (familyTree.addItem(human)) {
            System.out.println("Добавление человека прошло успешно!");
        } 
        else System.out.println("Такой человек уже присутсвует в дереве.");
    }

    public void getFamilyTreeInfo(int sortBy) {
        switch (sortBy) {
            case 1:
                familyTree.sortByName();
                break;
            case 2:
                familyTree.sortByBirthDate();
                break;
            case 3:
                familyTree.sortByAge();
                break;
            default:
                break;
        }
        System.out.println(familyTree.getFamilyTree());
    }

    public Human findHuman(String name) {
        return familyTree.getByName(name);
    }

    public void setDeathDate(Human human, LocalDate deathDate) {
        if (human.setDeathDate(deathDate)) {
            System.out.println("Добавление даты смерти прошло успешно!");
        } else {
            System.out.println("При добавление даты смерти произошла ошибка.");
        }
    }

    public void createFamily(Human parent1, Human parent2, Human child) {
        if (child.createRelatings(parent1, parent2, child)) {
            System.out.println("Создание связей прошло успешно!");
        }
        else System.out.println("При создании связей произошла ошибка.");
    }

    public void addChild(Human parent, Human child) {
        if (parent.addChildren(child)) {
            System.out.println("Добавление ребенка прошло успешно!");
        } else {
            System.out.println("Этот ребенок уже добавлен.");
        }
    }

    public void addParents(Human child, Human parent1, Human parent2) {
        if (child.addParents(parent1, parent2)) {
            System.out.println("Добавление родителей прошло успешно!");
        }
        else System.out.println("При добавлении родителей произошла ошибка.");
    }

    public void saveTree(String filePath) {
        if (fileHandler.save(this.familyTree, filePath)) {
            System.out.println("Сохранение дерева прошло успешно!");
        } else {
            System.out.println("При сохранении дерева произошла ошибка!");
        }
    }

    public void loadTree(String filePath) {
        this.familyTree = (FamilyTree<Human>) fileHandler.read(filePath);
        if (this.familyTree != null) {
            System.out.println("Загрузка дерева прошла успешно!");
        }
        else System.out.println("При загрузке дерева произошла ошибка!");
    }

    public void deleteHuman(Human human) {
        if (familyTree.deleteItem(human)) {
            System.out.println("Удаление человека прошло успешно!");
        }
        else System.out.println("Такого человека в дереве нет.");
    }
}

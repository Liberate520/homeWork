package genTree;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import interfaces.Loadable;
import interfaces.Saveable;

public class GenTree implements Saveable, Loadable {
    private static String fileExt;

    private Set<Human> humans;
    private int size;

    static {
        fileExt = ".genTree";
    }

    // конструктор
    public GenTree() {
        humans = new HashSet<Human>();
        size = 0;
    }

    public int size() {
        return size;
    }

    // вывести всех людей в древе
    public void showAllHumans() {
        if (size < 1) {
            System.out.println("GenTree is empty");
        }
        else {
            for (Human human: humans) {
                human.showFullInfo();
            }
        }
    }

    // вернуть список людей по ФИО
    public ArrayList<Human> findHumansByFullName(String firstName,
                                                 String midName,
                                                 String lastName) {
        String fullName = String.format("%s %s %s", firstName, midName, lastName);
        ArrayList<Human> result = new ArrayList<Human>();
        for (Human human: humans) {
            if (human.getFullName().equals(fullName)) {
                result.add(human);
            }
        }
        return result;
    }

    // вернуть человека по id
    public Human getHumanById(int id) {
        for (Human human: humans) {
            if (human.getId() == id) {
                return human;
            }
        }
        return null;
    }

    public void addHuman(Human human) {
        humans.add(human);
        size += 1;
    }

    public void addChildToId(Human child, int id) {
        if (size > 0) {
            Human parent = getHumanById(id);
            if (parent != null) {
                parent.addChild(child);
            }
            else {
                // что-то сделать если человек по id не найден
            }
        }
        else {
            // что-то сделать если дерево пусто
        }
    }

    public void addParentToId(Human parent, int id) {
        if (size > 0) {
            Human child = getHumanById(id);
            if (child != null) {
                if (parent.getGender() == Gender.man) {
                    child.setFather(parent);
                }
                else {
                    child.setMother(parent);
                }
            }
            else {
                // что-то сделать если человек по id не найден
            }
        }
        else {
            // что-то сделать если дерево пусто
        }
    }

    @Override
    public String getFileExt() {
        return fileExt;
    }
}
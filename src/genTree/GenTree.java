package genTree;

import java.util.ArrayList;
import java.util.Iterator;
import genTree.comparators.ByAge;
import genTree.comparators.ByFullName;
import genTree.comparators.ByHierarchyLevel;
import human.Human;
import human.enums.Gender;
import interfaces.Loadable;
import interfaces.Saveable;

public class GenTree implements Saveable, Loadable, Iterable<Human> {
    private static String fileExt;

    private ArrayList<Human> humans;
    private int size;

    static {
        fileExt = ".genTree";
    }

    // конструктор
    public GenTree() {
        humans = new ArrayList<Human>();
        size = 0;
    }

    // вернуть кол-во людей в дереве
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

    // добавить человека в дерево
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
                // TODO что-то сделать если человек по id не найден
            }
        }
        else {
            // TODO что-то сделать если дерево пусто
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

    // переопределение из Saveable
    @Override
    public String getFileExt() {
        return fileExt;
    }

    // переопределение из Iterable
    @Override
    public Iterator<Human> iterator() {
        return new GenTreeIterator(humans);
    }

    // сортировки с использованием классов-компараторов
    public void sortByHierarchyLevel() {
        humans.sort(new ByHierarchyLevel());
    }

    public void sortByFullName() {
        humans.sort(new ByFullName());
    }

    public void sortByAge() {
        humans.sort(new ByAge());
    }
}
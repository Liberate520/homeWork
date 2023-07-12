package genTree;

import java.util.ArrayList;
import java.util.Iterator;
import genTree.comparators.ByAge;
import genTree.comparators.ByFullName;
import genTree.comparators.ByHierarchyLevel;
import interfaces.GenTreeItem;
import interfaces.Loadable;
import interfaces.Saveable;
import treeItems.enums.Gender;

public class GenTree<T extends GenTreeItem<T>> implements Saveable, Loadable, Iterable<T> {
    private static String fileExt;

    private ArrayList<T> items;
    private int size;

    static {
        fileExt = ".genTree";
    }

    // конструктор
    public GenTree() {
        items = new ArrayList<T>();
        size = 0;
    }

    // вернуть кол-во элементов в дереве
    public int size() {
        return size;
    }

    // вывести все элементы в древе
    public void showAllItems() {
        if (size < 1) {
            System.out.println("GenTree is empty");
        }
        else {
            for (T item: items) {
                item.showFullInfo();
            }
        }
    }

    // вернуть список элементов по имени
    public ArrayList<T> findItemsByFullName(String fullName) {
        ArrayList<T> result = new ArrayList<T>();
        for (T item: items) {
            if (item.getFullName().contains(fullName)) {
                result.add(item);
            }
        }
        return result;
    }

    // вернуть элемент по id
    public T getItemById(int id) {
        for (T item: items) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    // добавить элемент в дерево
    public void addItem(T item) {
        items.add(item);
        size += 1;
    }

    public void addChildToId(T child, int id) {
        if (size > 0) {
            T parent = getItemById(id);
            if (parent != null) {
                parent.addChild(child);
            }
            else {
                System.out.println("id not found");
            }
        }
        else {
            System.out.println("tree is empty");
        }
    }

    public void addParentToId(T parent, int id) {
        if (size > 0) {
            T child = getItemById(id);
            if (child != null) {
                if (parent.getGender() == Gender.man) {
                    child.setFather(parent);
                }
                else {
                    child.setMother(parent);
                }
            }
            else {
                System.out.println("id not found");
            }
        }
        else {
            System.out.println("tree is empty");
        }
    }

    // переопределение из Saveable
    @Override
    public String getFileExt() {
        return fileExt;
    }

    // переопределение из Iterable
    @Override
    public Iterator<T> iterator() {
        return new GenTreeIterator<>(items);
    }

    // сортировки с использованием классов-компараторов
    public void sortByHierarchyLevel() {
        items.sort(new ByHierarchyLevel<>());
    }

    public void sortByFullName() {
        items.sort(new ByFullName<>());
    }

    public void sortByAge() {
        items.sort(new ByAge<>());
    }
}
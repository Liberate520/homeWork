package model.genTree;

import java.util.ArrayList;
import java.util.Iterator;
import model.genTree.comparators.ByAge;
import model.genTree.comparators.ByFullName;
import model.genTree.comparators.ByHierarchyLevel;
import model.interfaces.Loadable;
import model.interfaces.Saveable;
import model.treeItems.GenTreeItem;

public class GenTree<T extends GenTreeItem> implements Saveable, Loadable, Iterable<T> {
    private static String fileExt;

    private ArrayList<T> items = new ArrayList<T>();
    private int id = 1;
    private int size = 0;

    static {
        fileExt = ".genTree";
    }

    // вернуть кол-во элементов в дереве
    public int size() {
        return size;
    }

    // вернуть строку всех элементов в древе
    public String getTreeFullInfo() {
        if (size < 1) {
            return "Древо пусто";
        }
        StringBuilder sb = new StringBuilder();
        for (T item: items) {
            sb.append(item.getFullInfo());
        }
        return sb.toString();
    }

    // вернуть строку элементов найденых по имени
    public String getItemsByFullName(String fullName) {
        boolean found = false;
        StringBuilder sb = new StringBuilder();
        for (T item: items) {
            if (item.getFullName().contains(fullName)) {
                sb.append(item.getFullInfo());
                found = true;
            }
        }
        if (found) {
            return sb.toString();
        }
        return "Ничего не нашлось";
    }

    // вернуть элемент по id
    public T getItemById(int id) {
        for (T item: items) {
            if (item.getId() == id) {
                return item;
            }
        }
        // если не нашёлся - null
        return null;
    }

    // добавить элемент в древо
    public void addItem(T item) {
        item.setId(id);
        items.add(item);
        id += 1;
        size += 1;
    }

    // переопределение из Saveable
    @Override
    public String getFileExt() {
        return fileExt;
    }

    // переопределение из Iterable
    @Override
    public Iterator<T> iterator() {
        return new GenTreeIterator<T>(items);
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
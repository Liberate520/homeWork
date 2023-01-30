package Model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Tree<T extends Human> implements Iterable<T> {
    private List<T> humanlist;

    public Tree(List<T> humanlist) {
        this.humanlist = humanlist;
    }

    public Tree() {
        this(new ArrayList<>());
    }

    public List<T> getHumanlist() {
        return humanlist;
    }

    public void sethumanlist(List<T> humanlist) {
        this.humanlist = humanlist;
    }

    public void add_human(T human) {
        humanlist.add(human);
    }

    @Override
    public String toString() {
        return "Trees [humanlist=" + humanlist + "]";
    }

    @Override
    public Iterator<T> iterator() {
        return new HumanIterator<T>(humanlist);
    }

    public void sortByName() {
        Collections.sort(humanlist);
    }

    public void sortByBirth() {
        Collections.sort(humanlist, new HumanComparatorByBirth<T>());
    }

    public void searchByName() {
        System.out.println("Введите имя и я найду человека: ");
        Tree<T> tree = new Tree<>();
        Scanner scanner = new Scanner(System.in);
        String search = scanner.nextLine();
        for (Human human : tree) {
            if (human.getName().equals(search)) {
                System.out.println(human);
                break;
            }
        }
        scanner.close();
    }
}

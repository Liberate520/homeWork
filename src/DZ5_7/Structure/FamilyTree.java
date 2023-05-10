package DZ5_7.Structure;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import DZ5_7.Models.Human;

public class FamilyTree<T> implements InterfaceFamilyTree<T>, Serializable {

    private List<T> list;

    private FamilyTree(List<T> list) {
        this.list = list;
    }

    public FamilyTree() {
        this(new ArrayList<T>());
    }

    public List<T> getList() {
        return list;
    }

    public void setList(ArrayList<T> list) {
        this.list = list;
    }


    @Override
    public void add(T t) {
        list.add(t);
    }

    @Override
    public void del(T t) {
        ((Human) t).delCommunication((Human) t);
        list.remove(t);
    }

    @Override
    public void find(T t) {
        System.out.println(list.get(list.indexOf(t)));
    }

    public void find(String name) {
        int n = 1;
        System.out.println("Результат поиска: ");
        for (T t : list) {
            if (((Human) t).getName().indexOf(name) >= 0) {
                System.out.println(n++ + " " + t);
            }
        }
        if (n == 1) {
            System.out.println("Совпадений не найдено");
        }
    }

    @Override
    public String toString() {
        int n = 1;
        String res = "";
        for (T t : list) {
            res += n + " " + t + "\n";
            n++;
        }
        return res;
    }
}

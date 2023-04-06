import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FamilyTree implements Serializable {
    private  List<Human> tree;

    public FamilyTree() {
        this.tree = new ArrayList<>();
    }

    public void add(Human human) {
        this.tree.add(human);
    }
    @Override
    public String toString() {
        for (Human item : tree) {
            if (item.getFather() != null & item.getMother() != null) {
                System.out.println(item + " Мама:" + item.getMother() + " Папа: " + item.getFather());
            }
        }
        return " ";
    }

    public void searchForSurnameandName(String surname, String name) {
        List<Human> temp = new ArrayList<>();
        Object res = null;
        for (Human item : tree) {
            if (item.getName().equals(name) && item.getSurname().equals(surname)) {
                res = item;
            }
        }
        for (Human item : tree) {
            if (item.getFather() != null | item.getMother() != null) {
                if (item.getFather().getSurname().equals(surname) && item.getFather().getName().equals(name) ||
                        item.getMother().getSurname().equals(surname) && item.getMother().getName().equals(name)) {
                    temp.add(item);
                }
            }
        }

        if (!temp.isEmpty()) {
            System.out.println(res + " Дети: " + temp);
        } else {
            System.out.println(res + " Детей нет");
        }
    }
}

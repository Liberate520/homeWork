
import java.util.List;

public class Model<E extends Members> {

    Presenter presenter;
    Tree tree;

    public Model(Presenter presenter, Tree tree) {

        this.presenter = presenter;
        this.tree = tree;
    }

    public void getTree(Tree tree) {
        tree.iterator();
        for (var human : tree) {
            System.out.println(human);
        }
    }

    public void getChildrens(String surname, String name) {
        int i = tree.findHumanIndx(surname, name);
        if (i >= 0) {
            List<E> chil = tree.getMember(i).children;
            for (int index = 0; index < chil.size(); index++) {
                System.out.println(chil.get(index) + "\n");
            }
        } else {
            System.out.println("Такого человека не найдено");
        }

    }

    public void addHumanEnter(String surname, String name, int yearBorn, int yearDead, String sex) {

        tree.addHuman(new Human(surname, name, yearBorn, yearDead, null, null, null, sex));
        System.out.println("Человек добавлен");

        getTree(tree);
    }

    public void sortBySurname() {
        tree.sortBySurname();
        for (var human : tree) {
            System.out.println(human);
        }

    }

    public void sortByDate() {
        tree.sortByDate();
        for (var human : tree) {
            System.out.println(human);
        }
    }
}

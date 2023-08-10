package presenter;

import model.human.Human;
import model.tree.FamilyTree;
import view.View;

public class Presenter {
    private View view;
    private FamilyTree<Human> tree;

    public Presenter(View view) {
        tree = new FamilyTree<>();
        this.view = view;
    }

    public void add(Human human) {
        tree.add(human);
        tree.getInfo();
    }

    public String getHumanList() {
        return tree.getInfo();
    }

    public String sortByAge() {
        tree.sortByAge();
        return getHumanList();
    }

    public String sortByName() {
        tree.sortByName();
        return getHumanList();
    }
}
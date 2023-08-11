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

    public void getHumanListInfo() {
        String answer = tree.getInfo();
        view.print(answer);
    }

    public void sortByAge() {
        tree.sortByAge();
        getHumanListInfo();
    }

    public void sortByName() {
        tree.sortByName();
        getHumanListInfo();
    }
}
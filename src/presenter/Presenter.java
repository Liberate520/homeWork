package presenter;

import Elements.TreeElement;
import Tree.GenealogicalTree;
import Elements.Human;
import UI.View;

public class Presenter<E extends TreeElement> {
    private GenealogicalTree<E> tree;
    private View view;
    public Presenter(GenealogicalTree<E> tree, View view){
        this.tree = tree;
        this.view = view;
        view.setPresenter(this);

    }

    public void addTreeElement(String name, int birthday, int deathDay) {
        tree.addHuman((E) new Human(name, birthday, deathDay));
        view.print("Добавлено");
    }

    public void getTreeElementList() {
        for (E element:
                tree.getTree()) {
            view.print(element.toString());
        }
    }

    public void findTreeElement(String name) {
        view.print(tree.findHuman(name).toString());
    }

    public void sort(){
        tree.sort();
        view.print("Отсортировано.");
    }

}

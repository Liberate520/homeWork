package presenter;

import model.Elements.TreeElement;
import model.Tree.GenealogicalTree;
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
        tree.addElement(new E(name, birthday, deathDay));
        view.print("Добавлено");
    }

    public void getTreeElementList() {
        for (E element:
                tree.getTree()) {
            view.print(element.toString());
        }
    }

    public void findTreeElement(String name) {
        view.print(tree.findElement(name).toString());
    }

    public void sort(){
        tree.sort();
        view.print("Отсортировано.");
    }


}

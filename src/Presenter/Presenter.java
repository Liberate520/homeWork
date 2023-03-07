package Presenter;

import java.io.FileNotFoundException;
import java.io.IOException;

import Model.FileHandler;
import Model.Human;
import Model.Tree;

public class Presenter {
    private Tree<Human> tree;
    private FileHandler fileHandler;
    private Presenter presenter;
    private Human human;

    public Presenter(Presenter presenter) {
        this.presenter = presenter;
    }

    public Presenter getPresenter() {
        return presenter;
    }

    public void comandSortByName() {
        tree.sortByName();
    }

    public void comandSortByBirth() {
        tree.sortByBirth();
    }

    public void comandSave() throws IOException {
        fileHandler.save(tree.getHumanlist());
    }

    public void comandRead() throws IOException, ClassNotFoundException {
        try {
            fileHandler.read();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void comandAddNewHuman() {
        tree.add_human(human);
    }

    public void comandPrintConsoleTree() {
        System.out.println(tree);
    }

    public void comandSearchByName() {
        tree.searchByName();
    }

}

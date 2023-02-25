package presenter;

import myProject.Dynasty;
import myProject.FamilyTree;
import myProject.Handler;
import myProject.Writable;
import ui.View;

import java.io.IOException;


public class Presenter {
    private View view;
    Dynasty dynasty = new Dynasty();
    FamilyTree tree = new FamilyTree();
    Writable handler = new Handler();


    public Presenter(View view) {
        this.view = view;
        view.setPresenter(this);
    }

    public void addRecord(String nextLine) {
        System.out.println("В разработке");
    }
    public void wholeList() {
        dynasty.dynasty(tree);
        tree.List();
        System.out.println();
    }
    public void search(String search) {
        dynasty.dynasty(tree);
        tree.search(search);
        System.out.println();
    }
    public void sorting() {
        dynasty.dynasty(tree);
        tree.sortByName();
        tree.List();
        System.out.println();
    }
    public void save() throws IOException {
        dynasty.dynasty(tree);
        handler.save(tree);
        System.out.println("Список успешно сохранен!");
        System.out.println();
    }

    public void read() throws IOException, ClassNotFoundException {
        System.out.println("Список из файла");
        System.out.println();
        handler.read();
        System.out.println();
    }
}

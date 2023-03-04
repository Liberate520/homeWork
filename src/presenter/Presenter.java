package presenter;

import tree.FamilyTree;
import tree.FileHandler;
import tree.ReadWritable;
import ui.View;

import java.io.IOException;

import static tree.Dynasty.dynasty;


public class Presenter {
    private View view;
    private FamilyTree familyTree = new FamilyTree();
    //private Writable handler = new Handler();
    private ReadWritable fileHandler = new FileHandler("data.out");

    public Presenter(View view) {
        this.view = view;
        dynasty(familyTree);
        view.setPresenter(this);
    }

    public void addRecord(String nextLine) {
        System.out.println("В разработке");
    }

    public void wholeList() {
        familyTree.List();
        System.out.println();
    }
    public void search(String search) {
        familyTree.search(search);
        System.out.println();
    }
    public void sorting() {
        familyTree.sortByName();
        familyTree.List();
        System.out.println();
    }
    public void write() throws IOException {
        fileHandler.write(familyTree);
        System.out.println("Список успешно сохранен!");
        System.out.println();
    }
    public void read() throws IOException, ClassNotFoundException {
        System.out.println("Список из файла");
        System.out.println();
        fileHandler.read();
        System.out.println();
    }
}
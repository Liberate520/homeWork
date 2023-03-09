package presenter;

import tree.FamilyTree;
import tree.FileHandler;
import tree.Person;
import tree.interfaces.ReadWritable;
import ui.interfaces.View;

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
    }
    public void read() throws IOException, ClassNotFoundException {
        familyTree = (FamilyTree<Person>) fileHandler.read();
        System.out.println();
    }
}
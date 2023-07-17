package FamilyTree.Presenter;

import FamilyTree.Model.tree.*;
import FamilyTree.Model.tree.Sex;
import FamilyTree.View.View;

import java.time.LocalDate;

import static FamilyTree.Model.tree.Sex.Female;
import static FamilyTree.Model.tree.Sex.Male;

public class Presenter {
    private View view;
    private Tree tree;

    public Presenter(View view) {
        this.view = view;
        this.tree = new Tree();
    }

    public void addPerson (String name, String sex, LocalDate birthday) {
        Sex enumSex = null;
        if (sex =="1") { enumSex = Male;};
        if (sex =="2") { enumSex = Female;};

        tree.addPerson(new Person(name,enumSex,birthday));
        treeGetInfo();
    }

    public void treeGetInfo() {
        String info= tree.getInfo();
        view.printAnswer(info);
    }

    public void sortByAge() {
        tree.sortAge();
        treeGetInfo();
    }

    public void sortByName() {
        tree.sortName();
        treeGetInfo();
    }
}

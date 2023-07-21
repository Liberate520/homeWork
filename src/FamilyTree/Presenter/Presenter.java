package FamilyTree.Presenter;

import FamilyTree.Model.Servise;
import FamilyTree.Model.tree.*;
import FamilyTree.Model.tree.Sex;
import FamilyTree.View.View;

import java.io.IOException;
import java.time.LocalDate;

import static FamilyTree.Model.tree.Sex.Female;
import static FamilyTree.Model.tree.Sex.Male;

public class Presenter {
    private View view;
    private Servise servise;

    public Presenter(View view) {
        this.view = view;
        this.servise = new Servise();
    }

    public void addPerson (String name, Sex sex, LocalDate birthday) {

        servise.addPerson(name,sex,birthday);
        treeGetInfo();
    }

    public void treeGetInfo() {
        String info= servise.getInfo();
        view.printAnswer(info);
    }

    public void sortByAge() {
        servise.sortAge();
        treeGetInfo();
    }

    public void sortByName() {
        servise.sortName();
        treeGetInfo();
    }

    public void load() throws IOException, ClassNotFoundException {
        servise.load ();
        treeGetInfo();
    }

    public void save() throws IOException, ClassNotFoundException {
        servise.save ();
        load();

    }


    public void showAllPersonInfo(Integer id) {
        servise.showAllPersonInfo(id);
    }

    public void showChildren(Integer id) {
        servise.showChildren(id);
    }


    public void addSpouse(Integer id1, Integer id2) {
        servise.addSpouse (id1, id2);
    }

    public void addParents(Integer id1, Integer id2) {
        servise.addParents(id1, id2);
    }


    public void addChildren(Integer id1, Integer id2) {
        servise.addChildren(id1, id2);
    }


    public void showSpouse(Integer id) {
        servise.showSpouse(id);
    }

    public void showParents(Integer id) {servise.showParents(id);}

}

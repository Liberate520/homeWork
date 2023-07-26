package FamilyTree.Presenter;

import FamilyTree.Model.File.Writeable;
import FamilyTree.Model.Serviсe;
import FamilyTree.Model.tree.*;
import FamilyTree.Model.tree.Sex;
import FamilyTree.View.View;

import java.io.IOException;
import java.time.LocalDate;

public class Presenter {
    private View view;
    private Serviсe serviсe;

    public Presenter(View view, TreeAble tree, Writeable fh) {
        this.view = view;
        this.serviсe = new Serviсe(tree,fh);
    }

    public void addPerson (String name, Sex sex, LocalDate birthday) {

        serviсe.addPerson(name,sex,birthday);
        treeGetInfo();
    }

    public void treeGetInfo() {
        String info= serviсe.getInfo();
        view.printAnswer(info);
    }

    public void sortByAge() {
        serviсe.sortAge();
        treeGetInfo();
    }

    public void sortByName() {
        serviсe.sortName();
        treeGetInfo();
    }

    public void load() throws IOException, ClassNotFoundException {
        serviсe.load ();
        treeGetInfo();
    }

    public void save() throws IOException, ClassNotFoundException {
        serviсe.save ();

    }


    public String showAllPersonInfo(Integer id) {
        return serviсe.showAllPersonInfo(id);
    }

    public String showChildren(Integer id) {
        return serviсe.showChildren(id);
    }


    public void addSpouse(Integer id1, Integer id2) {
        serviсe.addSpouse (id1, id2);
    }

    public void addParents(Integer id1, Integer id2) {
        serviсe.addParents(id1, id2);
    }


    public void addChildren(Integer id1, Integer id2) {
        serviсe.addChildren(id1, id2);
    }


    public String showSpouse(Integer id) {
        return serviсe.showSpouse(id);
    }

    public String showParents(Integer id) {return serviсe.showParents(id);}

}

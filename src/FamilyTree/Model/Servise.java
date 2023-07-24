package FamilyTree.Model;

import FamilyTree.Model.File.FileHandler;
import FamilyTree.Model.File.Writeable;
import FamilyTree.Model.sort.AgeComparator;
import FamilyTree.Model.sort.NameComparator;
import FamilyTree.Model.tree.*;

import java.io.IOException;
import java.time.LocalDate;


public class Servise {
    public TreeAble <Being> tree;
    public Writeable fh;


    public Servise(TreeAble tree,Writeable fh) {
        this.tree= tree;
        this.fh = fh;

    }


    public void addPerson(String name, Sex sex, LocalDate birthday) {
        tree.addPerson(new Person(name,sex,birthday));
    }

    public String getInfo() {
        return  tree.getInfo();
    }


    public void sortAge() {
        tree.sortAge();

    }
    public void sortName() {
        tree.sortName();

    }


    public void load() throws IOException, ClassNotFoundException {
        tree = fh.load ();
    }

    public void addSpouse(Integer id1, Integer id2) {
        tree.getById(id1).addSpouse(tree.getById(id2));
    }


    public void addChildren(Integer id1, Integer id2) {

        tree.getById(id1).addChild(tree.getById(id2));
        tree.addToChild(tree.getById(id1));
    }

    public void addParents(Integer id1, Integer id2) {

        tree.getById(id1).addParent(tree.getById(id2));
        tree.addToParents(tree.getById(id1));
    }


    public String showChildren(Integer id) {
        return    tree.getById(id).getChildrenInfo();
    }




    public void save() throws IOException {
        fh.save(tree);
    }

    public String showSpouse(Integer id) {
        return tree.getById(id).getSpouseInfo();
    }

    public String showParents(Integer id) {
        return  tree.getById(id).getParentsnfo();
    }

    public String showAllPersonInfo(Integer id) {
        return tree.getById(id).showAllPersonInfo();
    }
}

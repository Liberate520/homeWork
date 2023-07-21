package FamilyTree.Model;

import FamilyTree.Model.File.FileHandler;
import FamilyTree.Model.sort.AgeComparator;
import FamilyTree.Model.sort.NameComparator;
import FamilyTree.Model.tree.Person;
import FamilyTree.Model.tree.Sex;
import FamilyTree.Model.tree.Tree;

import java.io.IOException;
import java.time.LocalDate;


public class Servise {
    public Tree tree;
    public FileHandler fh;


    public Servise() {
        this.tree =new Tree();
        this.fh = new FileHandler();
    }
    public void addPerson(String name, Sex sex, LocalDate birthday) {
        tree.addPerson(new Person(name,sex,birthday));
    }

    public String getInfo() {
        return  tree.getInfo();
    }


    public void sortAge() {
        tree.sort (new AgeComparator());

    }
    public void sortName() {
        tree.sort(new NameComparator());

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


    public void showChildren(Integer id) {
        System.out.println(tree.getById(id).getChildrenInfo());
    }




    public void save() throws IOException {
        fh.save(tree);
    }

    public void showSpouse(Integer id) {
        System.out.println(tree.getById(id).getSpouseInfo());
    }

    public void showParents(Integer id) {
        System.out.println(tree.getById(id).getParentsnfo());
    }

    public void showAllPersonInfo(Integer id) {
        System.out.println(tree.getById(id).toString());
        System.out.println(tree.getById(id).getChildrenInfo());
        System.out.println(tree.getById(id).getParentsnfo());
        System.out.println(tree.getById(id).getSpouseInfo());

    }
}

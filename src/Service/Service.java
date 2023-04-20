package OOPjavaTree.src.Service;

import OOPjavaTree.src.Data.Operation;
import OOPjavaTree.src.Person.Human;
import OOPjavaTree.src.Tree.Comparators.HumanComparatorByBirthDate;
import OOPjavaTree.src.Tree.Comparators.HumanComparatorByName;
import OOPjavaTree.src.Tree.Tree;


public class Service {
    private Tree tree;

    public Service(Tree tree) {
        this.tree = tree;
    }
    public Tree getTree() {
        return tree;
    }
    public void setTree(Tree tree) {this.tree = tree;}

    public void add(String name, int birthdate){
        Human human = new Human(name, birthdate);
        tree.add(human);
    }

    public void add(String name, int birthdate, Human father, Human mother){
        Human human = new Human(name, birthdate, father, mother);
        tree.add(human);
    }

    public Human getByName(String name){
        return tree.getByName(name);
    }

    public void saveData(Operation file) {
        file.saveData(getTree());
    }

    public Object loadData(Operation file) {
        return file.loadData();
    }

    public void sortByName(){
        tree.getFamilyBranches().sort(new HumanComparatorByName());
    }

    public void sortByDate(){
        tree.getFamilyBranches().sort(new HumanComparatorByBirthDate());
    }

    @Override
    public String toString() {
        return tree.toString();
    }
}

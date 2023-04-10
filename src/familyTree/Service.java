package familyTree;

import familyTree.comparators.HumanComparatorByBirthday;
import familyTree.comparators.IdComparator;
import familyTree.comparators.HumanComparatorByName;
import familyTree.comparators.HumanCompareByNumberChild;
import member.Gender;
import member.Human;
import service.FileHandler;

import java.io.IOException;

public class Service {
    private int id;
    private FamilyTree tree;
    private FileHandler handler;

    public Service(FamilyTree tree) {
        this.tree = tree;
    }
    public FamilyTree getTree() {
        return tree;
    }
    public FileHandler getHandler() {
        return handler;
    }
    public void setTree(FamilyTree tree) {
        this.tree = tree;
    }
    public void setHandler(FileHandler handler) {
        this.handler = handler;
    }
    public void addHuman(String name, String surname, Gender gender, String dateBirth, Human father, Human mother) {

        tree.add(new Human(id++, name, surname, gender, dateBirth, father, mother));
    }

    public void addHuman(String name, String surname, Gender gender, String dateBirth) {

        tree.add(new Human(id++, name, surname, gender, dateBirth));
    }
    public void printTree(){
        System.out.println(tree.getInfo());
    }
    public void printPetList(){
        System.out.println(tree.getPetList().toString());
    }

    public void save(String fileName){
        if (handler != null && tree != null) {
            try {
                handler.write(tree, fileName);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void load(String fileName) {
        if (handler != null) {
            try {
                tree = (FamilyTree) handler.read(fileName);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void sortByName () {
        tree.getHumanList().sort(new HumanComparatorByName());
    }

    public void sortById () {
        tree.getHumanList().sort(new IdComparator());
    }

    public void sortByBirthday () {
        tree.getHumanList().sort(new HumanComparatorByBirthday());
    }

    public void sortByNumChild () {
        tree.getHumanList().sort(new HumanCompareByNumberChild());
    }

}

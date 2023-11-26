package FamilyTree.model.Service;

import FamilyTree.model.Person.Person;
import FamilyTree.model.Person.PersonBuilder;
import FamilyTree.model.Tree.FamilyTree;

import java.io.Serializable;

public class Service implements Serializable{
    private FamilyTree<Person> tree;
    private String family;
    public PersonBuilder builder;

    public Service() { this(""); }
    public Service(String family) {
        this.tree = new FamilyTree<Person>(family);
        this.family = family;
        this.builder = new PersonBuilder();
    }

    public String getFamilyName() { return family; }
    public FamilyTree<Person> getTree() { return tree; }

    public void sortByName(){ tree.sortByName(); }
    public void sortByAge(){ tree.sortByAge(); }

    public void addPerson(Person person){
        tree.addPerson(person);
    }
    public void addChild(Person person){
        tree.addChild(person);
    }

    public void saveTreeInFile(){
        FileHandler fs = new FileHandler();
        fs.write(tree, "test.bin");
    }

    public void loadFromFile(){
        FileHandler fs = new FileHandler();
        try {
            tree = (FamilyTree<Person>) fs.read("test.bin");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

package FamilyTree.Service;

import FamilyTree.Person.Person;
import FamilyTree.Tree.FamilyTree;
import FamilyTree.Tree.TreeElements;

import java.io.Serializable;
import java.time.LocalDate;

public class Service implements Serializable{
    private FamilyTree<Person> tree;
    private String family;
    public Service(String family) {
        this.family = family;
        tree = new FamilyTree<Person>(family);
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
}

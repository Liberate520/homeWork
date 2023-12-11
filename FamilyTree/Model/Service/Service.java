package FamilyTree.FamilyTree.Model.Service;

import FamilyTree.FamilyTree.Model.Person.Gender;
import FamilyTree.FamilyTree.Model.Person.Person;
import FamilyTree.FamilyTree.Model.Tree.FamilyTree;
import FamilyTree.FamilyTree.Model.Utils.Savable;

import java.util.ArrayList;

public class Service {
    private FamilyTree<Person> tree;
    private Savable<FamilyTree<Person>> storage;

    public Service(Savable storage) {
        this.storage = storage;
        tree = new FamilyTree<>();
    }
        public Service(String filePath){
        tree = storage.restoreTree(filePath);
    }
    public boolean restoreTree(String filePath){
        FamilyTree<Person> tmpTree = new FamilyTree<Person>();
        tmpTree = storage.restoreTree(filePath);
        if (tmpTree.equals(null)){
            return false;
        }
        tree = tmpTree;
        return true;
    }

    public boolean saveTree(String fileName){
        return storage.writeTree(tree, fileName);
    }

    public boolean addPerson(String name, Gender gender, String date, String deathDate){
        Person person = new Person(name,gender,date);
        tree.addPerson(person);
        return true;
    }

    public void setParent(int person_id, int parent_id){
        Person person = tree.getById(person_id);
        person.addParent(tree.getById(parent_id));
    }

    public boolean checkId(int id){
        return tree.checkId(id);
    }
    public String getFamilyInfo() {
        return tree.toString();
    }

    public ArrayList<String> listSortByAge(){
        return tree.sortByAge();
    }

    public ArrayList<String> listSortByChildren(){
        return tree.sortByChildren();
    }


    public void setSpouse(int personId, int spouseId) {

        Person person = tree.getById(personId);
        person.addParent(tree.getById(spouseId));
    }
}
package familyTree.Model.Service;

import familyTree.Model.PersonPack.Gender;
import familyTree.Model.PersonPack.Person;
import familyTree.Model.TreePack.FamilyTree;
import familyTree.Model.UtilsPack.StorageTree;

import java.io.Serializable;
import java.util.ArrayList;

public class Service {
    private FamilyTree<Person> tree;
    private StorageTree<Person> storage = new StorageTree();

    public Service() {
        tree = new FamilyTree<>();
    }
//    public Service(String filePath){
//        tree = storage.restoreTree(filePath);
//    }
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

    public boolean addPerson(String name, Gender gender, String date){
        Person person = new Person(name,gender,date);
        tree.addPerson(person);
        return true;
    }

    public void setParent(int person_id, int parent_id){
        Person person = tree.getPersonById(person_id);
        person.addParent(tree.getPersonById(parent_id));
    }

    public boolean checkId(int id){
       return tree.checkId(id);
    }
    public String getFamilyInfo() {
        return tree.toString();
    }

    public String listSortByAge(){
        StringBuilder tmp=new StringBuilder();
        for (String str : tree.sortByAge()) {
            tmp.append(str);
            tmp.append("\n");
        }
        return tmp.toString();
    }

    public String listSortByChildren(){
        StringBuilder tmp=new StringBuilder();
        for (String str : tree.sortByChildren()) {
            tmp.append(str);
            tmp.append("\n");
        }
        return tmp.toString();
    }


}

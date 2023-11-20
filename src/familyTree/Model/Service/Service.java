package Model.Service;

import Model.PersonPack.Gender;
import Model.PersonPack.Person;
import Model.TreePack.FamilyTree;

import java.util.ArrayList;

public class Service {
    private FamilyTree<Person> tree;

    public Service() {
        tree = new FamilyTree<>();
    }

    public boolean addPerson(String name, Gender gender, String date){
        Person person = new Person(name,gender,date);
        tree.addPerson(person);
        return true;
    }

    public void setParent(Person person, int parent_id){
        person.addParent(tree.getPersonById(parent_id));
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


}

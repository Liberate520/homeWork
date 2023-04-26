package model;

import model.Data.Writable;
import model.People.Comparators.PersonComparatorByGender;
import model.People.Comparators.PersonComparatorById;
import model.People.Comparators.PersonComparatorByIdReverse;
import model.People.Comparators.PersonComparatorByName;
import model.People.Person;
import model.Tree.FamilyTree;

import java.util.Iterator;
import java.util.List;

public class Service {

    public Person person;
    private Writable writable;
    private final String filePath = "Targariens.txt";
    public void dataOutput(){
        writable.dataOutput(targariensThrone, filePath);
    }
    public void deserialization(){
        targariensThrone = writable.deserialization(filePath);
    }
    public int id;
    public FamilyTree<Person> targariensThrone;
    public Service(){
        targariensThrone = new FamilyTree<>();
    }
    public Service(FamilyTree<Person> tree){
        this.targariensThrone = tree;
    }
    public void addTargarien(Person person){
        targariensThrone.addPerson(new Person(id++, person.firstName, person.lastName,
                person.birthDate, person.deathDate, person.gender, person.mother, person.father));
    }
    public void sortByName() {
        targariensThrone.getFamilyTree().sort(new PersonComparatorByName());
    }
    public void sortById(){
        targariensThrone.getFamilyTree().sort(new PersonComparatorById());
    }
    public void sortByIdReverse(){
        targariensThrone.getFamilyTree().sort(new PersonComparatorByIdReverse());
    }
    public void sortByGender(){
        targariensThrone.getFamilyTree().sort(new PersonComparatorByGender());
    }
    public void setWritable(Writable writable){
        this.writable = writable;
    }
    public String getTreeInfo(){
        return targariensThrone.getTreeInfo();
    }
    public List<String> searchPerson(){
        return targariensThrone.searchPerson();
    }
    public List<String> searchPersonDescendance(){
        return targariensThrone.searchPersonDescendance();
    }
    public Iterator<Person> iterator(){
        return targariensThrone.iterator();
    }
    public void getInfo(){person.getInfo();
    }
}

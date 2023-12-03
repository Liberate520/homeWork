package FamilyTree.model.Service;

import FamilyTree.model.Person.Gender;
import FamilyTree.model.Person.Person;
import FamilyTree.model.Person.PersonBuilder;
import FamilyTree.model.Tree.FamilyTree;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Service{
    private FamilyTree<Person> myFamilyTree;
    private String family;
    public PersonBuilder builder;

    public Service() { this(""); }
    public Service(String family) {
        this.myFamilyTree = new FamilyTree<>(family);
        this.family = family;
        this.builder = new PersonBuilder();
    }

    public String getFamilyName() { return family; }
    public FamilyTree<Person> getTree() { return myFamilyTree; }

    public void sortByName(){ myFamilyTree.sortByName(); }
    public void sortByAge(){ myFamilyTree.sortByAge(); }

    public void addPerson(Person person){
        myFamilyTree.addPerson(person);
    }
    public void addPerson(String name, String surname, Gender gender, LocalDate burnData) {
        this.addPerson(builder.build(myFamilyTree.getListFamilyTree().size() + 1, name, surname, gender, burnData));
    }

    public void setMarriage(int idP1, int idP2, String date){
        LocalDate date_marriage = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy MM dd"));
        Person p1 = myFamilyTree.getElementById(idP1);
        Person p2 = myFamilyTree.getElementById(idP2);

        if (p1 != null && p2 != null) {
            myFamilyTree.setMarriage(p1, p2, date_marriage);
        }
    }
//    public void addChild(Person person, Person chield){
//        myTree.addChild(person);
//    }
//    public void addChild(Person person){
//        myTree.addChild(person);
//    }
//    public void addChild(Person person){
//        myTree.addChild(person);
//    }

    public void saveTreeInFile(String fileName){
        FileHandler fs = new FileHandler();
        fs.write(myFamilyTree, fileName);
    }

    public void loadFromFile(String filename){
        FileHandler fs = new FileHandler();
        try {
            myFamilyTree = (FamilyTree<Person>) fs.read(filename);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

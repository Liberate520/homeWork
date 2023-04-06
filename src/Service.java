import familyTree.FamilyTree;
import familyTree.comparators.PersonComparatorByBornDate;
import familyTree.comparators.PersonComparatorByFirstName;
import familyTree.comparators.PersonComparatorByGender;
import familyTree.comparators.PersonComparatorByLastName;
import handler.FileHandler;
import person.Person;
import trees.TreeOfTrees;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Service {
    private TreeOfTrees treeOfTrees;

    public Service(TreeOfTrees treeOfTrees) {
        this.treeOfTrees = treeOfTrees;
    }

    public void addFamilyTree(String newName){
        this.treeOfTrees.addFamilyTree(new FamilyTree(newName));
    }

    public void addFamilyTree(Person person){
        this.treeOfTrees.addFamilyTree(new FamilyTree(person));
    }

    public void addFamilyTree(FamilyTree familyTree){
        this.treeOfTrees.addFamilyTree(familyTree);
    }

    public void addPerson(Person person) {
        for (FamilyTree familyTree : treeOfTrees){
            addPerson(familyTree, person);
        }
    }

    public void addPerson(String familyTreeName, Person person) {
        addPerson(this.findFamilyTree(familyTreeName), person);
    }

    private void addPerson(FamilyTree familyTree, Person person) {
        familyTree.addPerson(person);
    }

    public void addPerson(String firstName, String lastName, boolean isMan) {
        addPerson(firstName, lastName, isMan, new GregorianCalendar());
    }

    public void addPerson(String firstName, String lastName, boolean isMan, Calendar bornDate){
        for (FamilyTree familyTree : treeOfTrees){
            addPerson(familyTree, firstName, lastName, isMan, bornDate);
        }
    }

    public void addPerson(String familyTreeName, String firstName, String lastName, boolean isMan) {
        addPerson(familyTreeName, firstName, lastName, isMan, new GregorianCalendar());
    }

    public void addPerson(String familyTreeName, String firstName, String lastName, boolean isMan, Calendar bornDate) {
        addPerson(this.findFamilyTree(familyTreeName), firstName, lastName, isMan, bornDate);
    }

    private void addPerson(FamilyTree familyTree, String firstName, String lastName, boolean isMan, Calendar bornDate) {
        Person person = new Person(firstName, lastName, isMan, bornDate);
        familyTree.addPerson(person);
    }

    public void addPerson(String firstName, String firstNameSample){
        for (FamilyTree familyTree : treeOfTrees){
            addPerson(familyTree, firstName, firstNameSample);
        }
    }

    public void addPerson(String familyTreeName, String firstName, String firstNameSample) {
        addPerson(this.findFamilyTree(familyTreeName), firstName, firstNameSample);
    }

    private void addPerson(FamilyTree familyTree, String firstName, String firstNameSample) {
        Person person = new Person(familyTree.findPerson(firstNameSample));
        person.setFirstName(firstName);
        familyTree.addPerson(person);
    }

    public FamilyTree findFamilyTree(String name){
        return this.treeOfTrees.findFamilyTree(name);
    }

    public Person findPerson(String firstName){
        for (FamilyTree familyTree : treeOfTrees){
            return familyTree.findPerson(firstName);
        }
        return null;
    }

    public void sortByFirstName() {
        for (FamilyTree familyTree : treeOfTrees) {
            this.sortByFirstName(familyTree);
        }
    }

    public void sortByFirstName(String familyTreeName) {
        this.sortByFirstName(this.findFamilyTree(familyTreeName));
    }

    private void sortByFirstName(FamilyTree familyTree) {
        List<Person> persons = familyTree.getPersonsList();
        persons.sort(new PersonComparatorByFirstName());
        for (person.Person person : persons) {
            person.getChildren().sort(new PersonComparatorByFirstName());
            person.getParents().sort(new PersonComparatorByFirstName());
        }
    }

    public void sortByLastName() {
        for (FamilyTree familyTree : treeOfTrees) {
            this.sortByLastName(familyTree);
        }
    }

    public void sortByLastName(String familyTreeName) {
        this.sortByLastName(this.findFamilyTree(familyTreeName));
    }

    private void sortByLastName(FamilyTree familyTree) {
        List<Person> persons = familyTree.getPersonsList();
        persons.sort(new PersonComparatorByLastName());
        for (person.Person person : persons) {
            person.getChildren().sort(new PersonComparatorByLastName());
            person.getParents().sort(new PersonComparatorByLastName());
        }
    }

    public void sortByGender() {
        for (FamilyTree familyTree : treeOfTrees) {
            this.sortByGender(familyTree);
        }
    }

    public void sortByGender(String familyTreeName) {
        this.sortByGender(this.findFamilyTree(familyTreeName));
    }

    private void sortByGender(FamilyTree familyTree) {
        List<Person> persons = familyTree.getPersonsList();
        persons.sort(new PersonComparatorByGender());
        for (person.Person person : persons) {
            person.getChildren().sort(new PersonComparatorByGender());
            person.getParents().sort(new PersonComparatorByGender());
        }
    }

    public void sortByBornDate() {
        for (FamilyTree familyTree : treeOfTrees) {
            this.sortByBornDate(familyTree);
        }
    }

    public void sortByBornDate(String familyTreeName) {
        this.sortByBornDate(this.findFamilyTree(familyTreeName));
    }

    private void sortByBornDate(FamilyTree familyTree) {
        List<Person> persons = familyTree.getPersonsList();
        persons.sort(new PersonComparatorByBornDate());
        for (person.Person person : persons) {
            person.getChildren().sort(new PersonComparatorByBornDate());
            person.getParents().sort(new PersonComparatorByBornDate());
        }
    }

    public void save(String fileName) {
        FileHandler fileHandler = new FileHandler();
        this.treeOfTrees.save(fileHandler, fileName);
    }
}
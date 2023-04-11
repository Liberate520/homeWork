import familyTree.FamilyTree;
import familyTree.comparators.PersonComparatorByBornDate;
import familyTree.comparators.PersonComparatorByFirstName;
import familyTree.comparators.PersonComparatorByGender;
import familyTree.comparators.PersonComparatorByLastName;
import handler.FileHandler;
import person.Person;
import trees.TOTrees;
import trees.TreeOfTrees;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Service {
    private TOTrees<FamilyTree> treeOfTrees;

    public Service(TOTrees<FamilyTree> treeOfTrees) {
        this.treeOfTrees = treeOfTrees;
    }

    public void addFamilyTree(String newName){
        this.treeOfTrees.addFamilyTree(new FamilyTree<>(newName));
    }

    public void addFamilyTree(Person person){
        this.treeOfTrees.addFamilyTree(new FamilyTree<>(person));
    }

    public void addFamilyTree(FamilyTree<Person> familyTree){
        this.treeOfTrees.addFamilyTree(familyTree);
    }

    public void addPerson(Person person) {
        for (FamilyTree<Person> familyTree : treeOfTrees){
            addPerson(familyTree, person);
        }
    }

    public void addPerson(String familyTreeName, Person person) {
        addPerson(this.findFamilyTree(familyTreeName), person);
    }

    private void addPerson(FamilyTree<Person> familyTree, Person person) {
        familyTree.addPerson(person);
    }

    public void addPerson(String firstName, String lastName, boolean isMan) {
        addPerson(firstName, lastName, isMan, new GregorianCalendar());
    }

    public void addPerson(String firstName, String lastName, boolean isMan, Calendar bornDate){
        for (FamilyTree<Person> familyTree : treeOfTrees){
            addPerson(familyTree, firstName, lastName, isMan, bornDate);
        }
    }

    public void addPerson(String familyTreeName, String firstName, String lastName, boolean isMan) {
        addPerson(familyTreeName, firstName, lastName, isMan, new GregorianCalendar());
    }

    public void addPerson(String familyTreeName, String firstName, String lastName, boolean isMan, Calendar bornDate) {
        addPerson(this.findFamilyTree(familyTreeName), firstName, lastName, isMan, bornDate);
    }

    private Person addPerson(FamilyTree<Person> familyTree, String firstName, String lastName, boolean isMan, Calendar bornDate) {
        Person person = new Person(firstName, lastName, isMan, bornDate);
        familyTree.addPerson(person);
        return person;
    }

    public void addPerson(String firstName, String firstNameSample){
        for (FamilyTree<Person> familyTree : treeOfTrees){
            addPerson(familyTree, firstName, firstNameSample);
        }
    }

    public void addPerson(String familyTreeName, String firstName, String firstNameSample) {
        addPerson(this.findFamilyTree(familyTreeName), firstName, firstNameSample);
    }

    private void addPerson(FamilyTree<Person> familyTree, String firstName, String firstNameSample) {
        Person person = new Person(familyTree.findPerson(firstNameSample));
        person.setFirstName(firstName);
        familyTree.addPerson(person);
    }

    public void addChild(String firstNameParent, String firstNameChild, String lastNameChild, boolean isMan) {
        addChild(firstNameParent, firstNameChild, lastNameChild, isMan, new GregorianCalendar());
    }

    public void addChild(String firstNameParent, String firstNameChild, String lastNameChild, boolean isMan, Calendar bornDate){
        for (FamilyTree<Person> familyTree : treeOfTrees){
            addChild(familyTree, firstNameParent, firstNameChild, lastNameChild, isMan, bornDate);
        }
    }

    private void addChild(FamilyTree<Person> familyTree, String firstNameParent, String firstNameChild, String lastNameChild, boolean isMan, Calendar bornDate) {
        familyTree.findPerson(firstNameParent).addChild(this.addPerson(familyTree, firstNameChild, lastNameChild, isMan, bornDate));
    }

    public void addChild(String firstNameParent, String firstNameChild){
        for (FamilyTree<Person> familyTree : treeOfTrees){
            addChild(familyTree, firstNameParent, firstNameChild);
        }
    }

    public void addChild(String familyTreeName, String firstNameParent, String firstNameChild) {
        addChild(this.findFamilyTree(familyTreeName), firstNameParent, firstNameChild);
    }

    private void addChild(FamilyTree<Person> familyTree, String firstNameParent, String firstNameChild) {
        familyTree.findPerson(firstNameParent).addChild(familyTree.findPerson(firstNameChild));
    }

    public void addMarried(String firstNameMarried1, String firstNameMarried2, boolean isMarried) {
        for (FamilyTree<Person> familyTree : treeOfTrees){
            addMarried(familyTree, firstNameMarried1, firstNameMarried2, isMarried);
        }
    }

    public void addMarried(String familyTreeName, String firstNameMarried1, String firstNameMarried2, boolean isMarried) {
        addMarried(this.findFamilyTree(familyTreeName), firstNameMarried1, firstNameMarried2, isMarried);
    }

    private void addMarried(FamilyTree<Person> familyTree, String firstNameMarried1, String firstNameMarried2, boolean isMarried) {
        familyTree.findPerson(firstNameMarried1).addMarried(familyTree.findPerson(firstNameMarried2), isMarried);
    }

    public FamilyTree<Person> findFamilyTree(String name){
        return this.treeOfTrees.findFamilyTree(name);
    }

    public Person findPerson(String firstName){
        for (FamilyTree<Person> familyTree : treeOfTrees){
            return familyTree.findPerson(firstName);
        }
        return null;
    }

    public void sortByFirstName() {
        for (FamilyTree<Person> familyTree : treeOfTrees) {
            this.sortByFirstName(familyTree);
        }
    }

    public void sortByFirstName(String familyTreeName) {
        this.sortByFirstName(this.findFamilyTree(familyTreeName));
    }

    private void sortByFirstName(FamilyTree<Person> familyTree) {
        List<Person> persons = familyTree.getPersonsList();
        persons.sort(new PersonComparatorByFirstName<>());
        for (person.Person person : persons) {
            ((List<Person>)((ThreadLocal<Object>) person.getChildren())).sort(new PersonComparatorByFirstName<>());
            person.getParents().sort(new PersonComparatorByFirstName<>());
        }
    }

    public void sortByLastName() {
        for (FamilyTree<Person> familyTree : treeOfTrees) {
            this.sortByLastName(familyTree);
        }
    }

    public void sortByLastName(String familyTreeName) {
        this.sortByLastName(this.findFamilyTree(familyTreeName));
    }

    private void sortByLastName(FamilyTree<Person> familyTree) {
        List<Person> persons = familyTree.getPersonsList();
        persons.sort(new PersonComparatorByLastName<>());
        for (person.Person person : persons) {
            ((List<Person>)((ThreadLocal<Object>) person.getChildren())).sort(new PersonComparatorByLastName<>());
            person.getParents().sort(new PersonComparatorByLastName<>());
        }
    }

    public void sortByGender() {
        for (FamilyTree<Person> familyTree : treeOfTrees) {
            this.sortByGender(familyTree);
        }
    }

    public void sortByGender(String familyTreeName) {
        this.sortByGender(this.findFamilyTree(familyTreeName));
    }

    private void sortByGender(FamilyTree<Person> familyTree) {
        List<Person> persons = familyTree.getPersonsList();
        persons.sort(new PersonComparatorByGender<>());
        for (person.Person person : persons) {
            ((List<Person>)((ThreadLocal<Object>) person.getChildren())).sort(new PersonComparatorByGender<>());
            person.getParents().sort(new PersonComparatorByGender<>());
        }
    }

    public void sortByBornDate() {
        for (FamilyTree<Person> familyTree : treeOfTrees) {
            this.sortByBornDate(familyTree);
        }
    }

    public void sortByBornDate(String familyTreeName) {
        this.sortByBornDate(this.findFamilyTree(familyTreeName));
    }

    private void sortByBornDate(FamilyTree<Person> familyTree) {
        List<Person> persons = familyTree.getPersonsList();
        persons.sort(new PersonComparatorByBornDate<>());
        for (person.Person person : persons) {
            ((List<Person>)((ThreadLocal<Object>) person.getChildren())).sort(new PersonComparatorByBornDate<>());
            person.getParents().sort(new PersonComparatorByBornDate<>());
        }
    }

    public void printInfo() {
        this.treeOfTrees.printAllInfo();
    }

    public void save(String fileName) {
        FileHandler<TreeOfTrees<FamilyTree>> fileHandler = new FileHandler<>();
        this.treeOfTrees.save(fileHandler, fileName);
    }

    public TreeOfTrees<FamilyTree> read(String fileName) {
        FileHandler<TreeOfTrees> fileHandler = new FileHandler<>();
        return fileHandler.read(fileName);
    }
}
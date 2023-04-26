import familyTree.FamilyTree;
import person.Person;
import person.Relation;
import person.Sex;
import saving.FileOutStr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Service {
    private FamilyTree<Person> activeTree;
    private List<FamilyTree<Person>> familyTreeList;

    public Service(FamilyTree<Person> tree) {
        this.activeTree = tree;
        familyTreeList = new ArrayList<>();
        familyTreeList.add(tree);
    }

    public Service(){
        this(new FamilyTree<Person>());
    }

    public void addFamilyTree(FamilyTree<Person> familyTree){
        familyTreeList.add(familyTree);
    }

    public void addPerson(String firstName, String lastName, int age, Sex sex){
        activeTree.pushToTree(new Person(firstName, lastName, age, sex));
    }

    public void addPersonAs(String firstName, String lastName, int age, Sex sex,
                            String targetFirstName, String targetLastName, Relation relation){

        Person person = new Person(firstName, lastName, age, sex);
        activeTree.pushToTree(person);
        Person targetPerson = getPerson(targetFirstName, targetLastName);
        if (targetPerson != null) {
            switch (relation) {
                case Spouse -> activeTree.pushSpouseToSet(targetPerson, person);
                case Father -> activeTree.pushFatherToSet(targetPerson, person);
                case Mother -> activeTree.pushMotherToSet(targetPerson, person);
                case Brother -> activeTree.pushBrotherToSet(targetPerson, person);
                case Sister -> activeTree.pushSisterToSet(targetPerson, person);
                case Son -> activeTree.pushSonToSet(targetPerson, person);
                case Daughter -> activeTree.pushDaughterToSet(targetPerson, person);
            }
        }
    }

    public Person getPerson(String firstName, String lastName) {
        for (Person item: activeTree) {
            if (item.getFirstName().equals(firstName) && item.getLastName().equals(lastName)) {
                return item;
            }
        }
        return null;
    }

    public String getInfo(String firstName, String lastName, Relation relation) {
        return activeTree.getInfo(firstName, lastName, relation);
    }

    public String getInfo(String firstName, String lastName) {
        return activeTree.getInfo(firstName, lastName);
    }

    public String getTreeInfo(){
        StringBuilder output = new StringBuilder();
        output.append("All records of Family Tree:" + "\n");
        output.append("##################################" + "\n");
        for (Person item: activeTree) {
            output.append(item + "\n");
        }
        output.append("---------------------------------" + "\n");
        return output.toString();
    }

    public void printSortByLastName(){
        List<Person> personList = activeTree.getListSortByLastName();
        for (Person person: personList) {
            System.out.println("ID: " + person.getId() + " " + person.getFirstName() +
                    " " + person.getLastName() + " " + person.getAge());
        }
    }

    public void printSortByFirstName(){
        List<Person> personList = activeTree.getListSortByFirstName();
        for (Person person: personList) {
            System.out.println("ID: " + person.getId() + " " + person.getFirstName() +
                    " " + person.getLastName() + " " + person.getAge());
        }
    }

    public void printSortByAge(){
        List<Person> personList = activeTree.getListSortByAge();
        for (Person person: personList) {
            System.out.println("ID: " + person.getId() + " " + person.getFirstName() +
                    " " + person.getLastName() + " " + person.getAge());
        }
    }

    public void saveFamilyTreeAs(String path, FileOutStr format) throws IOException {
        format.saveFamilyTreeAs(activeTree, path);
    }

    public void loadFamilyTreeFrom(String path, FileOutStr format) throws IOException, ClassNotFoundException {
        activeTree = format.getFamilyTreeFrom(path);
    }

    public void savePersonAs(Person person, String path, FileOutStr format) throws IOException {
        format.savePersonAs(person, path);
    }

    public Person loadPersonFrom(String path, FileOutStr format) throws IOException, ClassNotFoundException {
        return format.getPersonFrom(path);
    }
}

package model;

import model.FamilyTree.Tree;
import model.Human.Gender;
import model.Human.Person;
import model.fileWriter.FileHandler;
import model.fileWriter.Writable;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class Service {
    private Writable writable;
    private Tree<Person> activeTree;


    public Service(Tree<Person> tree){
        this.activeTree = tree;
    }
    public Service(){
        activeTree = new Tree<>();
    }

    public Tree<Person> getActiveTree() {
        return activeTree;
    }

    public String addPerson(String name, String genderString, String birthYear, String birthMonth, String birthDate, long idFather, long idMother) {
        Person father = activeTree.getById(idFather);
        Person mother = activeTree.getById(idMother);
        Gender gender = Gender.valueOf(genderString);
        LocalDate personDateBirth = LocalDate.of(Integer.parseInt(birthYear),Integer.parseInt(birthMonth), Integer.parseInt(birthDate) );
        Person person = new Person(name, gender,personDateBirth,father,mother);
        activeTree.add(person);
        return "Person is added";
    }


    public void sortByName() {
        activeTree.sortByName();
    }

    public void addChild(long idParent, long idChild) {
        Person parent = activeTree.getById(idParent);
        Person child = activeTree.getById(idChild);
        parent.addChild(child);
        child.addParent(parent);
    }

    public void addParent(long idParent, long idChild) {
        Person parent = activeTree.getById(idParent);
        Person child = activeTree.getById(idChild);
        parent.addChild(child);
        child.addParent(parent);
    }

    public void setWedding(long idFirstSpouse, long idSecondSpouse) {
        activeTree.setWedding(idFirstSpouse, idSecondSpouse);
    }

    public void setDevorce(long idFirstSpouse, long idSecondSpouse) {
        activeTree.setDivorce(idFirstSpouse, idSecondSpouse);
    }

    public void save(String filename) throws IOException {
        writable = new FileHandler(filename);
        writable.saveFile(activeTree);
    }

    public Tree load(String filename) throws IOException, ClassNotFoundException {
        writable = new FileHandler(filename);
        activeTree = writable.loadFile();
        return activeTree;
    }

    public List<Person> getSiblings(String sibID) {
        return activeTree.getSiblings(Integer.valueOf(sibID));
    }

    public void sortByBirthDate() {
        activeTree.sortByBirthDate();
    }

    public void removePerson(long idPerson) {
        activeTree.remove(idPerson);
    }
}

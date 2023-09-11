package model;

import model.FamilyTree.Tree;
import model.Human.Gender;
import model.Human.Person;
import model.fileWriter.FileHandler;
import model.fileWriter.Writable;

import java.io.IOException;
import java.time.LocalDate;

public class Service {
    private Writable writable;
    private Tree<Person> activeTree;
    private FileHandler fh;
    private String fileName;

    public Service(Tree<Person> tree){
        this.activeTree = tree;
    }
    public Service(){
        activeTree = new Tree<>();
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
        activeTree.add(parent);
    }

    public void setWedding(long idFirstSpouse, long idSecondSpouse) {
        activeTree.setWedding(idFirstSpouse, idSecondSpouse);
    }

    public void getInfo() {
        System.out.println(activeTree);
    }

    public void save(String filename) throws IOException {
        this.fileName = filename;
        fh = new FileHandler(fileName);
        fh.saveFile(activeTree);
    }

    public Tree load(String filename) throws IOException, ClassNotFoundException {
        this.fileName = filename;
        fh = new FileHandler(fileName);
        activeTree = fh.loadFile();
        return activeTree;
    }

    public void getSiblings(String sibID) {
        System.out.println(activeTree.getSiblings(Integer.valueOf(sibID)));
    }

    public void sortByBirthDate() {
        activeTree.sortByBirthDate();
    }
}

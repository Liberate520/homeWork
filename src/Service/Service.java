package Service;

import FamilyTree.FamilyTree;
import Human.Human;
import Human.HumanComparatorById;
import Human.HumanComparatorByName;
import Human.HumanComparatorByBirthDate;
import FileOperations.InOutTxt;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;

public class Service {
    private int id;
    private Human human;
    private FamilyTree familyTree;

    public Service(FamilyTree familyTree) {
        this.familyTree = familyTree;
    }

    public void addHuman(String status, String name, String surname, LocalDate birthDate, Human mother, Human father) {
        familyTree.addKin(new Human(id++, status, name, surname, birthDate, mother, father));
    }

    public void addHuman(String status, String name, String surname, LocalDate birthDate) {
        familyTree.addKin(new Human(id++, status, name, surname, birthDate));
    }

    public void sortByName() {
        familyTree.getFamilyTree().sort(new HumanComparatorByName());
    }

    public void sortByID() {
        familyTree.getFamilyTree().sort(new HumanComparatorById());
    }

    public void sortByBirthDate() {
        familyTree.getFamilyTree().sort(new HumanComparatorByBirthDate());
    }

    public FamilyTree getFamilyTree() {
        return familyTree;
    }

    public void saveTree() throws IOException {
        InOutTxt copy = new InOutTxt();
        copy.saveData(familyTree, "tree");
    }

    public void loadTree() throws IOException, ClassNotFoundException {
        InOutTxt copy = new InOutTxt();
        FamilyTree tree = (FamilyTree) copy.loadData("tree");
    }

    public void setStatus(String name, String surname, String newStatus) {
        familyTree.getHuman(name, surname).setStatus(newStatus);
    }

    public void setName(String name, String surname, String newName) {
        familyTree.getHuman(name, surname).setName(newName);
    }

    public void setSurname(String name, String surname, String newSurname) {
        familyTree.getHuman(name, surname).setSurname(newSurname);
    }

    public void setBirthDate(String name, String surname, int year, int month, int day) {
        familyTree.getHuman(name, surname).setBirthDate(LocalDate.of(year, month, day));
    }

    public void setMother(String name, String surname, String motherName, String motherSurname) {
        familyTree.getHuman(name, surname).setMother(familyTree.getHuman(motherName, motherSurname));
    }

    public void setFather(String name, String surname, String fatherName, String fatherSurname) {
        familyTree.getHuman(name, surname).setFather(familyTree.getHuman(fatherName, fatherSurname));
    }


    public void removeHuman(String name, String surname) {
        familyTree.removeKin(familyTree.getHuman(name, surname));
    }


    public Human getHuman(String name, String surname) {
        return (Human) familyTree.getHuman(name, surname);
    }

    public String getStatus(String name, String surname) {
        return familyTree.getHuman(name, surname).getStatus();
    }


    public LocalDate getBirthDate(String name, String surname) {
        return familyTree.getHuman(name, surname).getBirthDate();
    }

    public Human getMother(String name, String surname) {
        return (Human)familyTree.getHuman(name, surname).getMother();
    }

    public Human getFather(String name, String surname) {
        return (Human)familyTree.getHuman(name, surname).getFather();
    }

    /*public HashSet <Human> getChildren(String name, String surname) {
        return (HashSet<Human>) familyTree.getHuman(name, surname).getChildren();

    }*/

    public HashSet <Human> getChildren(String name, String surname) {
        return familyTree.getAllChildren(name, surname);

    }
}
package model.service;

import model.family_tree.CustomFamilyTree;
import model.family_tree.FamilyTree;
import model.family_tree.comparators.PersonComparatorByBirthDate;
import model.family_tree.comparators.PersonComparatorByName;
import model.person.Gender;
import model.person.Person;
import model.saving.Saving;
import model.saving.SerializationSave;

import java.time.LocalDate;

public class FamilyTreeService implements Service{
    private FamilyTree<Person> familyTree;

    public FamilyTreeService() {
        familyTree = new FamilyTree<>("");
    }

    @Override
    public String getFamilyInfo() {
        return familyTree.getFamilyInfo();
    }

    @Override
    public String getPersonInfo(int id) {
        return familyTree.getPersonInfo(findByID(id));
    }

    @Override
    public void createNewFamilyTree(String familyName) {
        familyTree = new FamilyTree<>(familyName);
    }

    @Override
    public void createCustomTree() {
        familyTree = new CustomFamilyTree().getCustomFamilyTree();
    }

    @Override
    public void addInFamily(String name, LocalDate birthDate, Gender gender) {
        Person person = new Person(name, birthDate, gender);
        familyTree.addInFamily(person);
    }

    @Override
    public void addDeathDate(int id, LocalDate deathDate) {
        Person person = findByID(id);
        person.setDeathDate(deathDate);
    }

    @Override
    public void getMarried(int husbandID, int wifeID) {
        Person husband = findByID(husbandID);
        Person wife = findByID(wifeID);
        familyTree.isHusbands(husband, wife);
    }

    @Override
    public void getChild(int childID, int fatherID, int motherID) {
        Person child = findByID(childID);
        Person father = findByID(fatherID);
        Person mother = findByID(motherID);
        familyTree.isChildren(child, father, mother);
    }

    @Override
    public void saveFamilyTree() {
        Saving saving = new SerializationSave();
        saving.save(familyTree);
    }

    @Override
    public void downloadFamilyTree(String name) {
        Saving saving = new SerializationSave();
        try {
            familyTree = saving.download(name);
            getFamilyInfo();
        } catch (Exception e) {
            System.out.println("увы((");
        }
    }

    @Override
    public void sortByName() {
        familyTree.sort(new PersonComparatorByName<>());
    }

    @Override
    public void sortByBirthDate() {
        familyTree.sort(new PersonComparatorByBirthDate<>());
    }

    @Override
    public Person findByID(int id) {
        Person findPerson = null;
        for (Person person : familyTree) {
            if (id == person.getId()) {
                findPerson = person;
            }
        }
        return findPerson;
    }

    @Override
    public int getTreeSize() {
        return familyTree.size();
    }
}

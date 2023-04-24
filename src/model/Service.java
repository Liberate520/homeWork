package model;

import family.FamilyTree;

import person.Person;
import person.comparators.PersonComparatorByIdASC;
import person.comparators.PersonComparatorByIdDESC;
import person.comparators.PersonComparatorByNameASC;
import person.comparators.PersonComparatorByNameDESC;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Service<E extends Person> {
    private FamilyTree<E> family;
    private String fileName;

    public void setFamily(FamilyTree<E> family) {
        this.family = family;
    }

    public Service(FamilyTree<E> family) {
        this.family = family;
    }

    public void addPerson(E person, String personName, String personeSurname, Date dateOfBirth, Date dateOfDeath,
                          Integer motherID, Integer fatherID, Integer partnerID) {
        if (person.getID() == -1) {
            int id = family.getId();
            person.setID(id);
        }
        person.setPersonName(personName);
        person.setPersonSurname(personeSurname);
        person.setDateOfBirth(dateOfBirth);
        person.setDateOfDeath(dateOfDeath);
        person.setMotherID(motherID);
        person.setFatherID(fatherID);
        person.setPartnerID(partnerID);
        family.add(person);
    }

    public void deletePerson(Integer id) {
        family.delete(id);
        for (E person : family) {
            if (Objects.equals(person.getMotherID(), id)) person.setMotherID(null);
            else if (Objects.equals(person.getFatherID(), id)) person.setFatherID(null);
            else if (Objects.equals(person.getPartnerID(), id)) person.setPartnerID(null);
        }
    }

//    public void changePerson(E person, String newName, String newSurname, Date newDateOfBirth,
//                             Date newDateOfDeath, Integer newMotherID, Integer newFatherID, Integer newPartnerID) {
//        family.delete(person.getID());
//        addPerson(person, newName, newSurname, newDateOfBirth, newDateOfDeath, newMotherID, newFatherID, newPartnerID);
//  /* добавить проверки на ID :
//    - mother, father, partner - если != null, то должны существовать в HashMap
//    - дополнительные проверки (углубленно).
//
//    ДОРАБОТАТЬ!
//  */
//    }

    public List<E> getSortedListByIdDESC() {
        List<E> result = family.getHumanList();
        result.sort(new PersonComparatorByIdDESC<>());
        return result;
    }

    public List<E> getSortedListByIdASC() {
        List<E> result = family.getHumanList();
        result.sort(new PersonComparatorByIdASC<>());
        return result;
    }

    public List<E> getSortedListByNameASC() {
        List<E> result = family.getHumanList();
        result.sort(new PersonComparatorByNameASC<>());
        return result;
    }

    public List<E> getSortedListByNameDESC() {
        List<E> result = family.getHumanList();
        result.sort(new PersonComparatorByNameDESC<>());
        return result;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void saveTree() throws IOException {
        SaveRestoreSerializable<E> objSave = new SaveRestoreSerializable<>();
        objSave.save(fileName, family);
    }

    public FamilyTree<E> loadTree() throws IOException, ClassNotFoundException {
        SaveRestoreSerializable<E> objLoad = new SaveRestoreSerializable<>();
        FamilyTree<E> result = objLoad.load(fileName);
        setFamily(result);
        return result;
    }

    public Integer getLastID() {
        return family.getId() - 1;
    }

    public String getNamePerson(Integer id) {
        return family.getNameByID(id);
    }

    public String showTree(Integer id) {
        return family.showTree(id);
    }

}

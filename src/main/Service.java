package main;
import java.time.LocalDate;

import person.Person;
import tree.FamilyTree;
import tree.Gender;

public class Service {
    private int id;
    private FamilyTree familyGroup;

    public Service(FamilyTree familyGroup) {
        this.familyGroup = familyGroup;

    }

    public FamilyTree getFamilyGroup() {
        return familyGroup;
    }

    public void addPerson(String firstName, String lastname, LocalDate dateOfBirth, Gender gender, Person mather, Person father) {
        id++;
        familyGroup.add(new Person(id, firstName, lastname, dateOfBirth, gender, father.getIdMather(), mather.getIdFather()));
    }


    public void sortByID() {
        familyGroup.sortByID();
    }

    public void sortByBirthDate() {
        familyGroup.sortByBirthDate();
    }

    public void addPerson(int i, String string, String string2, LocalDate of, Gender male) {
    }

}
package HW_5;

import java.time.LocalDate;

public class Service {
    private int id;
    private FamilyTree familyGroup;

    public Service(FamilyTree familyGroup) {
        this.familyGroup = familyGroup;

    }

    public FamilyTree getFamilyGroup() {
        return familyGroup;
    }

    public void addHuman(String firstName, String lastname, LocalDate dateOfBirth, Sex sex, Human mather, Human father) {
        id++;
        familyGroup.add(new Human(id, firstName, lastname, dateOfBirth, sex, mather, father));
    }

    public void addHuman(String firstName, String lastname, LocalDate dateOfBirth, Sex sex) {
        id++;
        familyGroup.add(new Human(id, firstName, lastname, dateOfBirth, sex));
    }

    public void sortByID() {
        familyGroup.sortByID();
    }

    public void sortByLastName() {
        familyGroup.sortByLastName();
    }
}



package FamilyTree.model.person;

import FamilyTree.model.tree.FamilyTree;
import FamilyTree.model.tree.TreeItem;

import java.time.LocalDate;
import java.util.List;

public class CreatePerson<T extends TreeItem<T>> {
    private FamilyTree<Person> familyTree;
    private Person person;

    public CreatePerson(FamilyTree<Person> familyTree) {
        this.familyTree = familyTree;
    }

    public Person createPerson(String name, String inputGender, LocalDate dateOfBirth, String inputMotherName, String inputFatherName) {
        Gender gender = Gender.valueOf(inputGender);
        Person mother = familyTree.getByName(inputMotherName);
        Person father = familyTree.getByName(inputFatherName);
        person = new Person(name, gender, dateOfBirth, mother, father);

        return person;
    }
}
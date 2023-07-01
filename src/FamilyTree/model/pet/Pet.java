package FamilyTree.model.pet;

import FamilyTree.model.person.Person;
import FamilyTree.model.tree.TreeItem;

import java.io.Serializable;
import java.time.LocalDate;

public class Pet implements Serializable, TreeItem {
    String name;
    LocalDate dateOfBirth;
    public Pet(String name, LocalDate dateOfBirth) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    @Override
    public Person getMother() {
        return null;
    }

    @Override
    public Person getFather() {
        return null;
    }

    @Override
    public String getPersonInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Имя: ");
        sb.append(name);

        return sb.toString();
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                '}';
    }
}

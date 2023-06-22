package FamilyTree.pet;

import FamilyTree.person.Person;
import FamilyTree.tree.TreeItem;

import java.io.Serializable;
import java.time.LocalDate;

public class Pet implements Serializable, TreeItem {
    String name;
    public Pet(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public LocalDate getDateOfBirth() {
        return null;
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

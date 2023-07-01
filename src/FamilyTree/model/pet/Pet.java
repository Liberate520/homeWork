package FamilyTree.model.pet;

import FamilyTree.model.tree.TreeItem;

import java.io.Serializable;
import java.time.LocalDate;

public class Pet implements Serializable, TreeItem<Pet> {
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
    public Pet getMother() {
        return null;
    }

    @Override
    public Pet getFather() {
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
    public boolean addChild(Pet person) {
        return false;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                '}';
    }
}

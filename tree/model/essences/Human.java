package model.essences;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import model.handlers.Saveable;

public class Human extends Creature<Human> implements Saveable {

    public Human(String firstName, String lastName, Gender gender, LocalDate dateBirth) {
        super(firstName, lastName, gender, dateBirth);
    }

    public Human(String firstName, String lastName, Gender gender, LocalDate dateBirth, LocalDate dateDeath) {
        super(firstName, lastName, gender, dateBirth);
        this.dateDeath = dateDeath;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public LocalDate getDateDeath() {
        return dateDeath;
    }

    public Set<Human> getParents() {
        return parents;
    }

    public Set<Human> getChildren() {
        return children;
    }

    public void addParent(Human parent) {
        this.parents.add(parent);
    }

    public void addChild(Human child) {
        this.children.add(child);
        child.addParent(this);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("имя: ");
        sb.append(firstName);
        sb.append(", фамилия: ");
        sb.append(lastName);
        sb.append(", дата рождения: ");
        sb.append(dateBirth);
        sb.append(", дата смерти: ");
        sb.append(getDateDeath());
        sb.append(", родители: ");
        if (getParents().size() > 0) {
            for (Creature human : getParents()) {
                sb.append(human.firstName);
                sb.append(" ");
                sb.append(human.lastName);
                sb.append(", ");
            }
        } else
            sb.append("-, ");
        sb.append("дети: ");
        if (getChildren().size() > 0) {
            for (Creature human : getChildren()) {
                sb.append(human.firstName);
                sb.append(" ");
                sb.append(human.lastName);
                sb.append(", ");
            }
        } else
            sb.append("-");
        return sb.toString();
    }

}

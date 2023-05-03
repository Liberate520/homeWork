package model.essences;

import java.time.LocalDate;
import java.util.Set;

import model.handlers.Saveable;

public class Human extends Creature<Human> implements Saveable {

    public Human(String firstName, String lastName, Gender gender, LocalDate dateBirth, LocalDate dateDeath) {
        super(firstName, lastName, gender, dateBirth, dateDeath);
    }

    public Human(String firstName, String lastName, Gender gender, LocalDate dateBirth) {
        this(firstName, lastName, gender, dateBirth, null);
        // super.dateDeath = dateDeath;
    }

    public LocalDate getDateBirth() {
        return getDateBirth();
    }

    public LocalDate getDateDeath() {
        return getDateDeath();
    }

    public Set<Human> getParents() {
        return getParents();
    }

    public Set<Human> getChildren() {
        return getChildren();
    }

    public void addParent(Human parent) {
        this.getParents().add(parent);
    }

    public void addChild(Human child) {
        this.getChildren().add(child);
        child.addParent(this);
    }

    public String getFirstName() {
        return getFirstName();
    }

    public String getLastName() {
        return getLastName();
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("имя: ");
        sb.append(getFirstName());
        sb.append(", фамилия: ");
        sb.append(getLastName());
        sb.append(", дата рождения: ");
        sb.append(getDateBirth());
        sb.append(", дата смерти: ");
        sb.append(getDateDeath());
        sb.append(", родители: ");
        if (getParents().size() > 0) {
            for (Creature human : getParents()) {
                sb.append(human.getFirstName());
                sb.append(" ");
                sb.append(human.getLastName());
                sb.append(", ");
            }
        } else
            sb.append("-, ");
        sb.append("дети: ");
        if (getChildren().size() > 0) {
            for (Creature human : getChildren()) {
                sb.append(human.getFirstName());
                sb.append(" ");
                sb.append(human.getLastName());
                sb.append(", ");
            }
        } else
            sb.append("-");
        return sb.toString();
    }

}

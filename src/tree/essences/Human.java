package tree.essences;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

import tree.interfaces.AlliService;
import tree.interfaces.Saveable;

public class Human implements Saveable, Comparator<Human>, AlliService<Human> {
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate dateBirth;
    private LocalDate dateDeath;
    protected Set<Human> parents;
    protected Set<Human> children;
    int index;

    public Human(String firstName, String lastName, Gender gender, LocalDate dateBirth, LocalDate dateDeath) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateBirth = dateBirth;
        this.dateDeath = dateDeath;
        this.parents = new HashSet<Human>();
        this.children = new HashSet<Human>();
    }

    public Human(String firstName, String lastName, Gender gender, LocalDate dateBirth) {
        this(firstName, lastName, gender, dateBirth, null);
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public String getDateDeath() {
        if (dateDeath == null) {
            return "-";
        }
        return dateDeath.toString();
    }

    @Override
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String getLastName() {
        return lastName;
    }

    public String getNames() {
        return firstName + " " + lastName;
    }

    @Override
    public Set<Human> getParents() {
        return parents;
    }

    @Override
    public Set<Human> getChildren() {
        return children;
        // StringBuilder sb = new StringBuilder();
        // for (Human child : children) {
        // sb.append(child.firstName);
        // }
        // return sb.toString();
    }

    public void addParent(Human parent) {
        this.parents.add(parent);
    }

    public void addChild(Human child) {
        this.children.add(child);
        child.addParent(this);
    }

    @Override
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
            for (Human human : getParents()) {
                sb.append(human.firstName);
                sb.append(" ");
                sb.append(human.lastName);
                sb.append(", ");
            }
        } else
            sb.append("-, ");
        // sb.append(getParents());
        sb.append("дети: ");
        // sb.append(getChildren());
        if (getChildren().size() > 0) {
            for (Human human : getChildren()) {
                sb.append(human.firstName);
                sb.append(" ");
                sb.append(human.lastName);
                sb.append(", ");
            }
        } else
            sb.append("-");
        return sb.toString();

    }

    @Override
    public int compare(Human hum1, Human hum2) {
        if (hum1.getNames().compareTo(hum2.getNames()) > 0)
            return -1;
        else if (hum1.getNames().compareTo(hum2.getNames()) < 0)
            return 1;
        else
            return 0;
    }

    public String getDataByNames(String firstName, String lastName) {
        return this.getInfo();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Human)) {
            return false;
        }
        Human human = (Human) obj;
        return human.getNames().equals(getNames());
    }

}

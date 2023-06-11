import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private static int humanIdCounter = 0;
    private int id;
    private String name;
    private String gender;
    private String loner;
    private LocalDate dateOfBirth;
    private LocalDate deathDate;
    private Human father;
    private Human mother;
    private List<Human> children;

    public Human(String name, String gender, LocalDate dateOfBirth, Human father, Human mother) {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.deathDate = null;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList<>();
        this.id = humanIdCounter++;
    }

    public Human(String name, String gender, LocalDate dateOfBirth) {
        this(name, gender, dateOfBirth, null, null);
    }

    public Human(String loner){
        this.loner = loner;
    }

    public Human() {

    }

    public String getName() {
        return name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public List<Human> getChildren() {
        return children;
    }

    public List<Human> getParents() {
        List<Human> parents = new ArrayList<>();
        if (father != null) {
            parents.add(father);
        }
        if (mother != null) {
            parents.add(mother);
        }
        return parents;
    }

    public boolean addChild(Human child) {
        if (children == null) {
            children = new ArrayList<>();
        }
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Имя: " + name + ", пол: " + gender + ", Дата рождения: " + dateOfBirth + ", Дата смерти: " + deathDate + ", ";
    }
}
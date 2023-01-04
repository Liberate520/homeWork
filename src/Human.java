import java.io.Serializable;
import java.util.List;

public class Human implements Serializable {

    private String name;
    private String surname;
    private int yearBorn;
    private int yearDead;
    private Human father;
    private Human mother;
    private List<Human> children;
    private String sex;

    public Human(String name, String surname, int yearBorn, int yearDead, Human father, Human mother,
            List<Human> children, String sex) {
        this.name = name;
        this.surname = surname;
        this.yearBorn = yearBorn;
        this.yearDead = yearDead;
        this.father = father;
        this.mother = mother;
        this.children = children;
        this.sex = sex;
    }

    @Override
    public String toString() {
        return String.format("%s %s, Years: %d - %d, Sex - %s, \n",
                this.name, this.surname, this.yearBorn, this.yearDead, this.sex);
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

}

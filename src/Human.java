import java.util.ArrayList;

public class Human extends Members {

    private String surname;

    public Human(String name, String surname, int yearBorn, int yearDead, Human father, Human mother,
            ArrayList<Human> children, String sex) {
        super(name, yearBorn, yearDead, father, mother, children, sex);
        this.surname = surname;
    }

    @Override
    public String toString() {
        return String.format("%s %s, Years: %d - %d, Sex - %s, \n",
                this.name, this.surname, this.yearBorn, this.yearDead, this.sex);
    }

}
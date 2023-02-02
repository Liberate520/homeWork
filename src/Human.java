import java.util.ArrayList;

public class Human extends Members {

    public Human(String surname, String name, int yearBorn, int yearDead, Human father, Human mother,
            ArrayList<Human> children, String sex) {
        super(surname, name, yearBorn, yearDead, father, mother, children, sex);
    }

}
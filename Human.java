package homeWork;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Human implements Serializable {
    private String mother, father;
    private List<String> children;
    private LocalDate localDate;
    private Gender gender;

    public Human(String mother, String father, List<String> children, LocalDate localDate, Gender gender) {
        this.mother = mother;
        this.father = father;
        this.children = children;
        this.localDate = localDate;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Mother: " + mother + "\nFather: " + father + "\nChildren(s): " + children + "\nDay of Birth: " + localDate +
                "\nGender: " + gender;
    }
}

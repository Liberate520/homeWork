import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name;
    private Gender gender;
    private int birthYear;
    private Integer deathYear;
    private List<Person> children;

    public Person(String name, Gender gender, int birthYear) {
        this.name = name;
        this.gender = gender;
        this.birthYear = birthYear;
        this.children = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public Integer getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(Integer deathYear) {
        this.deathYear = deathYear;
    }

    public List<Person> getChildren() {
        return children;
    }

    public void addChild(Person child) {
        children.add(child);
    }

    @Override
    public String toString() {
        return name + " (" + gender + ") - " + birthYear + (deathYear != null ? "-" + deathYear : "");
    }
}

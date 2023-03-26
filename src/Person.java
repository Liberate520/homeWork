import java.util.ArrayList;

public class Person {
    private int birthYear;
    private boolean isAlive;
    private String firstName;
    private String secondName;
    private Gender gender;
    private Person father;
    private Person mother;
    private ArrayList<Person> children = new ArrayList<>();

    public int getBirthYear() {
        return birthYear;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getFullName() {
        return "%s %s".formatted(this.firstName, this.secondName);
    }

    public Gender getGender() {
        return gender;
    }

    public Person getFather() {
        return father;
    }

    public Person getMother() {
        return mother;
    }

    public ArrayList<Person> getChildren() {
        return children;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public void addChild(Person child) {
        this.children.add(child);
    }

    public Person(int birthYear, boolean isAlive, String firstName, String secondName, Gender gender) {
        this.birthYear = birthYear;
        this.isAlive = isAlive;
        this.firstName = firstName;
        this.secondName = secondName;
        this.gender = gender;
    }

    public void printChildren() {
        System.out.println("Children of %s:".formatted(getFullName()));
        children.forEach((child) -> {
            System.out.println(child);
        });
    }

    @Override
    public String toString() {
        return "%s, born in year %d".formatted(
                this.getFullName(),
                this.getBirthYear());
    }
}

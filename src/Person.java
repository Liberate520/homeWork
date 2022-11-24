
import java.util.*;

public class Person {
    private String firstName;
    private String secondName;
    private int age;
    private Sex sex;
    private List<Relative> relatives = new ArrayList<>();

    public Person() {
        this.relatives = new ArrayList<>();
    }

    public Person(String firstName, String secondName, int age, Sex sex) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.sex = sex;

    }

    public Person(String firstName, String secondName, int age, Sex sex, List<Relative> relatives) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.sex = sex;
        this.relatives = relatives;
    }

    public Person addRelative(Person person, FamilyStatus status) {
        this.relatives.add(new Relative(person, status));
        return this;
    }

    public static Person parse(String string) {
        String[] person = string.split(" ");
        return new Person(person[0], person[1], Integer.parseInt(person[2]), Sex.valueOf(person[3]));
    }

    @Override
    public String toString() {
        return String.format("%s %s %d %s", firstName, secondName, age, sex.name());
    }

    public String getFullName() {
        return firstName + " " + secondName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public Sex getSex() {
        return sex;
    }

    public List<Relative> getRelatives() {
        return relatives;
    }

    public void setRelatives(List<Relative> relatives) {
        this.relatives = relatives;
    }
}

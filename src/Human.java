import java.util.ArrayList;
import java.util.List;

public class Human {
    private String firstName;
    private String lastName;
    private int age;
    private Sex sex;
    private Human mother;
    private Human father;
    private List<Human> brothersOrSistersList = new ArrayList<>();

    public Human(String firstName, String lastName, int age, Sex sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.sex = sex;
    }

    public Human() {
        this ("NoName", "NoName", 0, Sex.Male);
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        output.append("Name: " + this.firstName + " " + this.lastName + "\n");
        output.append("Age: " + this.age + "\n");
        output.append("Sex: " + this.sex + "\n");
        if (this.mother != null) {
            output.append("Mother: " + this.mother.firstName + " " + this.mother.lastName + "\n");
        }
        if (this.father != null) {
            output.append("Father: " + this.father.firstName + " " + this.father.lastName + "\n");
        }
        if (this.brothersOrSistersList != null && this.brothersOrSistersList.size() != 0) {
            output.append("Brothers and sisters:" + "\n");
            for (Human person: this.brothersOrSistersList) {
                output.append(person.firstName + " " + person.lastName + "\n");
            }
        }
        return output.toString();
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public void setMother(String firstName, String lastName, int age) {
        Human mother = new Human(firstName, lastName, age, Sex.Female);
        this.mother = mother;
    }

    public void setFather(String firstName, String lastName, int age) {
        Human father = new Human(firstName, lastName, age, Sex.Male);
        this.father = father;
    }

    public void addBrotherOrSister(String firstName, String lastName, int age, Sex sex) {
        Human brotherOrSister = new Human(firstName, lastName, age, sex);
        this.brothersOrSistersList.add(brotherOrSister);
    }
}

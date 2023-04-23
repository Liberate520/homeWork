import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Human implements Serializable {
    private String firstName;
    private String lastName;
    private String birthDate;
    private Human mother;
    private Human father;
    private List<Human> childrens;

    public Human(String firstName, String lastName) {this(firstName,
            lastName, null, null, null);}

    public Human(String firstname, String lastname, String birthDate, Human mother, Human father) {
        this.firstName = firstname;
        this.lastName = lastname;
        this.birthDate = birthDate;
        this.mother = mother;
        this.father = father;
        childrens = new ArrayList<>();
    }

    public boolean addChild(Human child) {
        if (!childrens.contains(child)){
            childrens.add(child);
            return true;
        }
        return false;
    }

    public List<Human> getChildrens() {
        return childrens;
    }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(String birthDate){
        this.birthDate = birthDate;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append("Имя: ");
        sb.append(firstName);
        sb.append(", ");
        sb.append("Фамилия:");
        sb.append(lastName);
        return sb.toString();
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + birthDate + ")";
    }
}
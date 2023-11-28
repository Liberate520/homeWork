import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Human {
    private String firstName;
    private String lastName;

    private Human mather;
    private Human father;
    private List<Human> children = new ArrayList<>();
    private Gender gender;
    private LocalDate birthDate;

    public Human(String firstName, String lastName, Human mather, Human father, List<Human> children, Gender gender,
            LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.mather = mather;
        this.father = father;
        this.children = new ArrayList<>();
        this.gender = gender;
        this.birthDate = birthDate;
        if (children!=null)
        {
            this.children = children;
        }

    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Human getMather() {
        return mather;
    }

    public void setMather(Human mather) {
        this.mather = mather;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public List<Human> getChildren() {
        return children;
    }

    public void setChildren(Human children) {
        this.children.add(children);
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getParrents() {
        return "Mather - " + this.mather.firstName + " " + this.mather.lastName + "  Father - " + this.father.firstName
                + " " + this.father.lastName;
    }
}

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Calendar;

public class Human {
    private String firstName, lastName, middleName;
    private Calendar dateOfBirth;
    private Human mother, father;
    private List<Human> children;
    private Gender sex;
    public Human(String firstName, String lastName,
                 String middleName, Calendar dateOfBirth,
                 Human mother, Human father,
                 List<Human> children, Gender sex) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.dateOfBirth = dateOfBirth;
        this.mother = mother;
        this.father = father;
        this.children = children;
        this.sex = sex;
    }
    public Human(String firstName, String lastName, String middleName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.children = new ArrayList<>();
    }

    public Human() {
        this.firstName = "";
        this.lastName = "";
        this.middleName = "";
        this.dateOfBirth = new GregorianCalendar(2100,0,1);
        this.sex = Gender.male;

        this.children = new ArrayList<Human>();
    }
    public void setChildren(ArrayList<Human> child) {
        for (Human human : child) {
            this.children.add(human);
        }
    }
    public void setMother(Human mother) {
        this.mother = mother;
    }
    public void setFather(Human father) {
        this.father = father;
    }
    public void setFatherAndMother(Human father, Human mother) {
        this.father = father;
        this.mother = mother;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getMiddleName() {
        return middleName;
    }
    public Calendar getDateOfBirth() {
        return dateOfBirth;
    }
    public Human getMother() {
        return mother;
    }
    public Human getFather() {
        return father;
    }
    public List<Human> getChildren() {
        return children;
    }
    public Gender getSex() {
        return sex;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public void setChildren(List<Human> children) {
        this.children = children;
    }
    @Override
    public String toString() {

        return "имя: " + this.firstName + ", фамилия: " + this.lastName + ", отчество: " + this.middleName +
                ", пол: "+ this.sex + ", дата рождения: " + this.dateOfBirth.get(Calendar.YEAR) +
                ", мама: " + this.mother.getLastName() + " " + this.mother.getFirstName() + " " + this.mother.getMiddleName() +
                ", папа: " + this.father.getLastName() + " " + this.father.getFirstName() + " " + this.father.getMiddleName();
    }
}

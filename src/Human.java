import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private String firstName;
    private String lastName;
    private Date birthDate;
    private Sex sex;
    private Human mother, father;
    private List<Human> children;
    private Date deathDate;

    public Human(String firstName, String lastName, Date birthDate, Sex sex, Human mother, Human father, List<Human> children, Date deathDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.sex = sex;
        this.mother = mother;
        this.father = father;
        this.children = children;
        this.deathDate = deathDate;
    }
    
    public Human(String firstName, String lastName, Date birthDate, Sex sex, Human mother, Human father, List<Human> children) {
        this(firstName, lastName, birthDate, sex, mother, father, children, null);
    }

    public Human(String firstName, String lastName, Date birthDate, Sex sex, Human mother, Human father) {
        this(firstName, lastName, birthDate, sex, mother, father, new ArrayList<Human>(), null);
    }

    public Human(String firstName, String lastName, Date birthDate, Sex sex) {
        this(firstName, lastName, birthDate, sex, null, null, new ArrayList<Human>(), null);
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public Date getDeathDate() {
        return this.deathDate;
    }

    public Human getFather() {
        return this.father;
    }

    public Sex getGender() {
        return this.sex;
    }

    public Human getMother() {
        return this.mother;
    }

    public List<Human> getChildren() {
        return this.children;
    }

    public void addChild(Human child) {
        this.children.add(child);
    }

    public void setDeathDate(Date deathDate) {
        this.deathDate = deathDate;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public int getChildrenAmount() {
        return this.children.size();
    }

    public int getAge() {
        LocalDate compareDate;
        if (this.deathDate == null) compareDate = LocalDate.now();
        else compareDate = this.deathDate.toLocalDate();

        LocalDate birthLocalDate = this.birthDate.toLocalDate();
        return Period.between(birthLocalDate, compareDate).getYears();  
    }
}
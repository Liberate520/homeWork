import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.ArrayList;

public class Human implements Serializable {
    private long id;

    private String firstName;
    private String lastName;

    private Human mather;
    private Human father;
    private List<Human> children;

    private Gender gender;

    private LocalDate birthDate;
    private LocalDate deathDate;

    public Human(String firstName, String lastName, Human mather, Human father, Human children, Gender gender,
            LocalDate birthDate, LocalDate deathDate) {
        this.id = -1;
        this.firstName = firstName;
        this.lastName = lastName;
        this.mather = mather;
        this.father = father;
        this.children = new ArrayList<>();
        if (children != null) {
            this.children.add(children);
        }
        this.gender = gender;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
    }

    public Human(String firstName, String lastName, Human mather, Human father,
            Human children, Gender gender,
            LocalDate birthDate) {
        this(firstName, lastName, mather, father, children, gender, birthDate,
                null);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
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

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        if (this.father == null) {
            this.father = father;
        }
    }

    public void setMather(Human mather) {
        if (this.mather == null) {
            this.mather = mather;
        }
    }

    public List<Human> getChildren() {
        return children;
    }

    public void addChildren(Human children) {
        if (!this.children.contains(children)) {
            this.children.add(children);
        }
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

    public int getAge() {
        LocalDate now;
        if (this.deathDate == null) {
            now = LocalDate.now();
        } else {
            now = this.deathDate;
        }
        return Period.between(birthDate, now).getYears();
    }

    public Human getSelf() {
        return this;
    }
}

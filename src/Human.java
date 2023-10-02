import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Human {
    private double id;
    private Gender gender;
    private String firstName;
    private String lastName;
    private String secondName;
    private Date birthday;
    private Date deathday;
    private Human mother;
    private Human father;
    private Set<Marriage>  marriages;
    private Set<Human> children;
    public Human(
            Gender gender,
            String firstName,
            String lastName,
            String secondName,
            Date birthday,
            Date deathday,
            Human mother,
            Human father
            )
    {
        this.gender = gender;
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.deathday =  deathday;
        this.mother = mother;
        this.father = father;
        this.children = new HashSet<>();
    }

    public Date getBirthday() {
        return birthday;
    }
    public String getFirstName() {
        return firstName;
    }
    public Gender getGender() {
        return gender;
    }
    public Human getMother() {
        return mother;
    }
    public Date getDeathday() {
        return deathday;
    }
    public String getLastName() {
        return lastName;
    }
    public String getSecondName() {
        return secondName;
    }
    public Set<Marriage> getMarriages() {
        return marriages;
    }
    public Human getFather() {
        return father;
    }
    public Set<Human> getChildren() {
        return children;
    }
    public void addChild()
    {
        // добавить ребенка
    }
    public void addMarriage()
    {
        // Добавить инфо о браке
    }
}

import java.text.SimpleDateFormat;
import java.util.*;

public class Human {
    private String name;
    private Gender gender;
    private Calendar dateOfBirth;
    private Calendar dateOfDeath;
    private Human father;
    private Human mother;
    private Set<Human> children;

    public Human(String name, Gender gender,
                 Calendar dateOfBirth,
                 Calendar dateOfDeath,
                 Human father, Human mother, Set<Human> children) {
        this.name = name;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.dateOfDeath = dateOfDeath;
        this.father = father;
        this.mother = mother;
        this.children = children;
    }
    public Human() {
        this.name = "Dummy Human";
        this.gender = Gender.MALE;
        this.dateOfBirth = new GregorianCalendar(1900, Calendar.JANUARY, 1);
        this.dateOfDeath = new GregorianCalendar(1900, Calendar.JANUARY, 1);
        this.father = this;
        this.mother = this;
        this.children = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setDateOfBirth(Calendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setDateOfDeath(Calendar dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public void setChildren(Set<Human> children) {
        this.children = children;
    }

    public Gender getGender() {
        return gender;
    }

    public Calendar getDateOfBirth() {
        return dateOfBirth;
    }

    public Calendar getDateOfDeath() {
        return dateOfDeath;
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public Set<Human> getChildren() {
        return children;
    }

    void adChild(Human child){
        this.children.add(child);
    }
    @Override
    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("d MMMM yyyy");
        String deathDate;
        if(dateOfDeath != null) {
            deathDate = dateFormat.format(dateOfDeath.getTime());
        } else {
            deathDate = "" ;
        }
        StringBuilder childrenNames = new StringBuilder();
        for(Human child : children){
            childrenNames.append(child.getName() + ", ");
        }
        return name + ", " + gender +
                ", (" + dateFormat.format(dateOfBirth.getTime()) +
                " - " + deathDate + ") " +
                "children: " + childrenNames +
                "; father: " + father.getName() +
                "; mother: " + mother.getName() + "\n";
    }
}

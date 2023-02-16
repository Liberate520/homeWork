import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Human implements Serializable {
    private String firstname;
    private String lastname;
    private Calendar birthdate;
    private Calendar deathdate;
    private Human father;
    private Human mother;
    private List<Human> children;

    public Human(String firstname, String lastname, Human father, Human mother){
        this(firstname, lastname);
        addParents(father, mother);
    }

    public Human(String firstname, String lastname){
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Calendar getBirthdate() {
        return birthdate;
    }
    
    public void setBirthdate(Calendar birthdate) {
        this.birthdate = birthdate;
    }

    public Calendar getDeathdate() {
        return deathdate;
    }

    public void setDeathdate(Calendar deathdate) {
        this.deathdate = deathdate;
    }

    public void addParents(Human father, Human mother){
        this.father = father;
        this.mother = mother;
        father.addChild(this);
        mother.addChild(this);
    }

    public Human getFather() {
        return father;
    }

    public Human getMother() {
        return mother;
    }

    public void addChild(Human child){
        if (this.children == null) children = new ArrayList<Human>();
        
        this.children.add(child);
    }

    public List<Human> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return firstname + ", " + lastname;
    }
}

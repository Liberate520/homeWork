import java.util.ArrayList;
import java.util.List;

public class Human {
    private Integer dateOfBirth;
    private Integer dateOfDeath;
    private Gender gender;
    private Human mother;
    private Human father;
    private Human partner;
    private List<Human> children;

    public Human () {
        this.children = new ArrayList<Human>();
    }

    public Human(Integer dateOfBirth, Gender gender, Human mother, Human father, Human partner) {
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.mother = mother;
        this.father = father;
        this.partner = partner;
        this.children = new ArrayList<Human>();
    }
/**
 * only
 * setDateOfDeath
 * partner
 * */
    public void setDateOfDeath(Integer dateOfDeath) {
        this.dateOfDeath = dateOfDeath;
    }

    public void setPartner(Human partner) {
        this.partner = partner;
    }

    public void addChild(Human child) {
        this.children.add(child);
    }

    public List<Human> getParents() {
        List<Human> parents = new ArrayList<>();
        parents.add(this.mother);
        parents.add(this.father);
        return parents;
    }

    public Human getMother() {
        return mother;
    }

    public Human getFather() {
        return father;
    }

    public Human getPartner() {
        return partner;
    }

    public List<Human> getChildren() {
        return children;
    }
}

import java.util.ArrayList;
import java.util.List;

public class Human {
    private String firstName;
    private String lastName;
    private String birthDate;
    private Human mother;
    private Human father;

    public Human(String firstname, String lastname, String birthDate, Human mother, Human father) {
        this.firstName = firstname;
        this.lastName = lastname;
        this.birthDate = birthDate;
        this.mother = mother;
        this.father = father;
    }

    public String getFirstName() {
        return firstName;
    }

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

    public List<Human> getChildren() {
        List<Human> children = new ArrayList<>();
        for (Human child : GenealogyTree.getHumans()) {
            if ((child.getMother() == this) || (child.getFather() == this)) {
                children.add(child);
            }
        }
        return children;
    }

    public List<Human> getParents() {
        List<Human> parents = new ArrayList<>();
        if (mother != null) {
            parents.add(mother);
        }
        if (father != null) {
            parents.add(father);
        }
        return parents;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " (" + birthDate + ")";
    }
}